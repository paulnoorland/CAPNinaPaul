package assignment2;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;



//er zijn nu een heleboel ISets, moet dit veranderen in normale sets?
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
		Identifier temp = new Identifier();
		while((nextCharIsLetter(in) || nextCharIsDigit(in) && !nextCharIs(in, ' '))){
			temp.appendChar(nextChar(in));
		}
		return temp;
	}

	void checkAssignment(Scanner in) throws APException{	//still need to work out the spaces!
		IIdentifier key = checkIdentifier(in);
		readSpaces(in);
		
		if (nextCharIs(in, '=')){
			nextChar(in);
			dict.add(key, checkExpression(in));	//add value to dictionary
		} else throw new APException("Wrong format, '=' expected.");	//nog een extra exception als er een spatie in de identifier zit?
	}
	
	void readSpaces(Scanner in){
		while(in.hasNext() && nextCharIs(in, ' ')) in.next();
	}
	
	public INaturalNumber readNaturalNumber(Scanner in){
		INaturalNumber temp = new NaturalNumber<>();			//parameteren met?
		while(nextCharIsDigit(in) && !nextCharIs(in, ' ')){
			temp.addNumber(nextChar(in));
		}
		return temp;
	}
	
	Set<INaturalNumber> readSet(Scanner in){
		Set<INaturalNumber> result = new Set<INaturalNumber>();
		while(!nextCharIs(in, '}')){
			readSpaces(in);
			result.addElement(readNaturalNumber(in));
		}
		nextChar(in);
		readSpaces(in);
		return result;
	}
	
	public Set<INaturalNumber> checkFactor(Scanner in) throws APException{
		readSpaces(in);
		if(nextCharIsLetter(in)) checkIdentifier(in);
		else if(nextCharIs(in, COMPLEX_FACTOR_OPEN)){
			nextChar(in);
			checkExpression(in);
		} else if(nextCharIs(in, SET_OPEN)){
			nextChar(in);
			return readSet(in);
		} else if(nextCharIsLetter(in)){
				
		} else throw new APException("blablabla"); //<--------------------------------------------
		return null;	//Hij gaat spasten als je dit niet doet :/
	}
	
	public ISet<INaturalNumber> checkTerm(Scanner in)throws APException{	//need a better way to handle spaces probably
		Set<INaturalNumber> set1 = checkFactor(in);
		readSpaces(in);
		if(in.hasNext()){
			if(nextChar(in) == INTERSECT){
				Set<INaturalNumber> set2 = checkFactor(in);
				return set1.intersection(set2);
			}
		}
		return set1;
	}
	
	public ISet<INaturalNumber> checkExpression(Scanner in) throws APException{
		ISet<INaturalNumber> set1 = checkTerm(in);
		//out.print("Hallo");
		readSpaces(in);
		if(in.hasNext()){
			readSpaces(in);
			if(nextChar(in) == UNION){
				ISet<INaturalNumber> set2 = checkTerm(in);
				return set1.union(set2);
				
			} else if(nextChar(in) == COMPLEMENT){	//difference and complement the same?
				ISet<INaturalNumber> set2 = checkTerm(in);
				return set1.difference(set2);
				
			} else if(nextChar(in) == SYMMETRIC_DIFFERENCE){
				ISet<INaturalNumber> set2 = checkTerm(in);
				return set1.symmetricDifference(set2);
				
			} else throw new APException("Unexpected input; additive operator ('+' for union, '|' for symmetric difference or '-' for complement) expected.");
		} else return set1;	
	}
	
	void printExpression(ISet<INaturalNumber> set){
		System.out.println("{");
		out.print(set.getLength());
		//ISet<INaturalNumber> temp = set.clone();		//moet dit, de clone spaced het programma
		
		//while(set.getLength() > 0){
		//	System.out.print(set.getElement().getNumber());
		//}
		System.out.print("}");
	}
	void checkStatement(Scanner in) throws APException{
		in.useDelimiter("");
		if (nextCharIsLetter(in)) checkAssignment(in);
		else if (nextChar(in) == PRINT) printExpression(checkExpression(in));
		else if (nextChar(in) == COMMENT);
		else throw new APException("Wrong format: a new line should start with~~~~");
	}
	
	void start(){
		while(in.hasNextLine()){
			readSpaces(in);
			String line = in.nextLine();
			Scanner temp = new Scanner(line);
			temp.useDelimiter("");
			
			try {
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