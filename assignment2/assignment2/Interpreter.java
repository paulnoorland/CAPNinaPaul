package assignment2;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Interpreter {
	
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
	
	private boolean nextCharIs(Scanner in, char c) {
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

	
	void start() {
		String program = in.nextLine();
		Scanner statementScanner = new Scanner(program);
		try {
			Statement statement = statement(statementScanner);
		}
	}
}
