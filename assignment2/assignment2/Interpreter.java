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
								RESULT = '?';
						
	Scanner in = new Scanner(System.in);
	PrintStream out = new PrintStream(System.out);
	
	/*First, completely write-out the parser part of your design. Which means, write a program that reads 
	 *lines of input, and does nothing in case of a correct command, but returns a clear error-message in 
	 *case there are incorrect commands.
	 */
	
	/*Only when the parser works, must you proceed to extend it to an interpreter. The interpreter must 
	 * recognize and execute commands written in the command-language specified below. 
	 */
	
	private char nextChar (Scanner in) {
	    return in.next().charAt(0);
	}
	
	private boolean nextCharIs(Scanner in, char c) {	//Als er iets na de char zit herkent hij hem niet meer..
	    return in.hasNext(Pattern.quote(c+""));
	}
	
	private boolean nextCharIsDigit (Scanner in) {			// must we use this?
	    return in.hasNext("[0-9]");
	}
	
	private boolean notZero(Scanner in) throws APException { //Is this the correct way?
		if(!in.hasNext("[1-9]")) {
			throw new APException("First number is a 0");
		}
		return true;
	}
	
	private boolean nextCharIsLetter (Scanner in) {
	    return in.hasNext("[a-zA-Z]");
	}
	
	private void character(Scanner input, char c) throws APException{
		if (!nextCharIs(input, c)) {
			throw new APException("");
		}
		nextChar(input);
	}
	
	private void eoln(Scanner input) throws APException{
		if(input.hasNext()) {
			throw new APException("Not end of the line");
		}
	}

	Set factor(Scanner scanner) throws APException {
		Set result = new Set();
		if (nextCharIsLetter(in)) {
			//read identifier
			//retrieve the set that belongs with that identifier
		} else if (nextCharIs(in, '{')) {
			
			//read a set until '}'
			//then check whether there is an operator or something
			//save operator, call factor.
		} else if (nextCharIs(in, '(')) {
			//determine the set that is the result of the complex factor
			//Check all chars until a ')' is present
			//If a ')' doesn't exist throw error.
		} else throw new APException("Wrong character");
		return result;
	}
	boolean isAlphanumeric(String string) {
		for (int i = 0; i < string.length(); i++) {
			char temp = string.charAt(i);
			if (!(Character.isDigit(temp) || Character.isLetter(temp)))
				return false;
		}
		return true;
	}

	private boolean checkIdentifierFormat(String string) {
		if (!Character.isLetter(string.charAt(0)) || !isAlphanumeric(string)
				|| !(string.length() > 0))
			return false;
		return true;
	}
	
	void saveVariable(Scanner scanner) throws Exception{
		//the first identifier is the key, the answer to the factor/the set is the value
		String key = scanner.next();
		System.out.print(key);
		//The next 'thing' should be an '='
	
		//add key-value to the dictionary
		//dictionary.add(key, value);
	}
	
	void parse(Scanner scanner) throws Exception{
		if (Character.isLetter(first.charAt(0))){
			saveVariable(scanner);	//klopt geloof ik
		} else if (first.charAt(0) == COMMENT){
			//nothing should happen
		} else if (first.charAt(0) == RESULT){
			//you have to do calculations now, then print something (call factor).
		} else if (first.charAt(0) == ' ');
		else throw new Exception("Wrong input; a new line should start with an Identifier, a '/' for comment or a '?' for printing");
		
	}

	void start() {
		while(in.hasNextLine()){
			String program = in.nextLine();
			Scanner scanner = new Scanner(program);
			try {
				parse(scanner);
			} catch (Exception e) {
				System.out.print(e.getMessage());
			}

		}
	}
	
	public static void main(String[] args){
		new Interpreter().start();
	}
}