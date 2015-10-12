package assignment2;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interpreter {
	public static final char	INTERSECT = '*',
								UNION = '+',
								COMPLEMENT = '-',
								SYMMETRIC_DIFFERENCE = '|',
								COMMENT = '/',
								PRINT = '?',
								COMPLEX_FACTOR_OPEN = '(',
								COMPLEX_FACTOR_CLOSE = ')',
								SET_OPEN = '{',
								SET_CLOSE = '}';
						
	Scanner in = new Scanner(System.in);
	PrintStream out = new PrintStream(System.out);
	
	Dictionary<IIdentifier, ISet<INaturalNumber>> dict;
	
	public Interpreter(){
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
		dict = new Dictionary<IIdentifier, ISet<INaturalNumber>>();
	}
	char nextChar (Scanner in) {
		return in.next().charAt(0);
	}

	boolean nextCharIs(Scanner in, char c) {
		return in.hasNext(Pattern.quote(c+""));
	}
	
	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
	}
	
	boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
	}
	
	public Identifier checkIdentifier(Scanner in){
		StringBuffer s = new StringBuffer();
		
		while((nextCharIsLetter(in) || nextCharIsDigit(in))) 
			s.append(nextChar(in));
		
		return new Identifier(s);
	}

	void checkAssignment(Scanner in) throws APException{
		IIdentifier key = checkIdentifier(in);
		readSpaces(in);
		
		if (nextCharIs(in, '=')){
			nextChar(in);
			
			if (in.hasNext()){
				dict.add(key, checkExpression(in));
				
			} else throw new APException("Wrong format: Missing expression.");
			
		} else throw new APException("Wrong format: unexpected char: '" + nextChar(in)+ " Expected char:/t'='");
	}
	
	void readSpaces(Scanner in){
		while(in.hasNext() && nextCharIs(in, ' ')) in.next();
	}
	
	public INaturalNumber readNaturalNumber(Scanner in){
		INaturalNumber temp = new NaturalNumber<>();
		
		while(nextCharIsDigit(in)) temp.addNumber(nextChar(in));
		return temp;
	}
	
	Set<INaturalNumber> readSet(Scanner in) throws APException {
		Set<INaturalNumber> result = new Set<INaturalNumber>();
		nextChar(in);
		readSpaces(in);
		
		while(nextCharIsDigit(in)){
			result.addElement(readNaturalNumber(in));
			readSpaces(in);
			
			if(nextCharIs(in, ',')) {
				nextChar(in);
				readSpaces(in);
				

				if(!nextCharIsDigit(in) || !nextCharIs(in, SET_CLOSE));
				else 
					throw new APException("Wrong format: A comma should be followed by another natural number");
		
			} else if (nextCharIs(in, SET_CLOSE)) 
				readSpaces(in);
			else 
				throw new APException("Wrong format: ',' expected");	
		}
		
		
		if (nextCharIs(in, SET_CLOSE)) 
			nextChar(in);		
		else 
			throw new APException("Wrong format: '" + SET_CLOSE + "' expected");
		
		return result;
	}
	
	public boolean nextCharIsFactor(Scanner in){
		return (nextCharIs(in, SET_OPEN) || nextCharIs(in, COMPLEX_FACTOR_OPEN) || nextCharIsLetter(in));
	}
	
	public ISet<INaturalNumber> checkFactor(Scanner in) throws APException{
		readSpaces(in);
		ISet<INaturalNumber> result = new Set<INaturalNumber>();
		
		while (nextCharIsFactor(in)){
			if(nextCharIsLetter(in)){
				return dict.getValue(checkIdentifier(in));
				
			} else if(nextCharIs(in, COMPLEX_FACTOR_OPEN)){
				nextChar(in);
				result = checkExpression(in);
				readSpaces(in);
				if (!nextCharIs(in, COMPLEX_FACTOR_CLOSE)) throw new APException("Wrong format: '" + COMPLEX_FACTOR_CLOSE + "' Expected.");
				nextChar(in);	
				
			} else if(nextCharIs(in, SET_OPEN))
				result = readSet(in);			
			  else 
				throw new APException("Wrong format: Set '{ ~~ }', complex factor '( ~~ )' or identifier (key) expected");
		}
		return result;
	}

	
	public ISet<INaturalNumber> checkTerm(Scanner in)throws APException{
		ISet<INaturalNumber> set1 = checkFactor(in);
		readSpaces(in);
		
		while(nextCharIs(in, INTERSECT)){
			nextChar(in);
			readSpaces(in);
			
			if(in.hasNext()){
				ISet<INaturalNumber> set2 = checkFactor(in);
				set1 = set1.intersection(set2);
				readSpaces(in);
				
			} else throw new APException("Wrong format: Missing expression.");	
			}
		return set1;
	}
	
	public boolean nextCharIsAdditiveOperator(Scanner in){
		return (nextCharIs(in, COMPLEMENT) || nextCharIs(in, UNION) || nextCharIs(in, SYMMETRIC_DIFFERENCE));
	}
	
	public ISet<INaturalNumber> handleExpressionException(Scanner in, char c) throws APException{
		readSpaces(in);
		
		if(in.hasNext()){
			ISet<INaturalNumber> set2 = checkTerm(in);
			return set2;
			
		} else throw new APException("Wrong format: Missing expression");	
	}
	
	public ISet<INaturalNumber> checkExpression(Scanner in) throws APException{
		ISet<INaturalNumber> set1 = checkTerm(in);
		readSpaces(in);
			while(nextCharIsAdditiveOperator(in)){	

				if(nextCharIs(in, UNION)){
					nextChar(in);
					ISet<INaturalNumber> set2 = handleExpressionException(in, UNION);
					set1 = set1.union(set2);	
				
				} else if(nextCharIs(in, COMPLEMENT)){
					nextChar(in);
					ISet<INaturalNumber> set2 = handleExpressionException(in, COMPLEMENT);
					set1 = set1.difference(set2);
				
				} else if(nextCharIs(in, SYMMETRIC_DIFFERENCE)){
					nextChar(in);
					ISet<INaturalNumber> set2 = handleExpressionException(in, SYMMETRIC_DIFFERENCE);
					set1 = set1.symmetricDifference(set2);		
					
				}	
			}
			
			boolean isComplexFactor = nextCharIs(in, COMPLEX_FACTOR_CLOSE);	//Bug (?): je kan nu overal haakjes sluiten neerzetten..
			boolean isOperator = nextCharIsAdditiveOperator(in);
		
			if (!isOperator && !isComplexFactor && in.hasNext()){	
				if (nextCharIsDigit(in)){		
					throw new APException("Wrong format: Sets should start with an {");
				} else throw new APException("Wrong format: unexpected char: '" + nextChar(in) + "'");
				
			}
		return set1;	
	}
	
	void printExpression(ISet<INaturalNumber> set){
		while(set.size() != 0){
			INaturalNumber num = set.getElement();
			set.removeElement(num);
			System.out.print(num.getNumber() + " ");
		}
		System.out.println();
	}
	
	void checkStatement(Scanner in) throws APException{
			readSpaces(in);
			if (nextCharIsLetter(in)) checkAssignment(in);
			else if (nextCharIs(in, PRINT)){
				nextChar(in);
				readSpaces(in);
				printExpression(checkExpression(in));
				
			} else if (nextCharIs(in, COMMENT));
			
			else throw new APException("Wrong format: a new line should start with:" + COMMENT + ", " + PRINT + ", or an identifier.");
	}
	
	void checkEmptyLine(String s) throws APException{
		if(s.equals("")) throw new APException("Wrong format: empty lines are not allowed.");
	}
	
	void start(){
		while(true){
			if (!in.hasNextLine()) System.exit(0);
			String line = in.nextLine();

			Scanner temp = new Scanner(line);
			temp.useDelimiter("");
			
			try {
				checkEmptyLine(line);
				checkStatement(temp);
			} catch (APException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args){
		new Interpreter().start();
	}
}