package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Sort {
	
	public static final String[] possibleArgs = {"-d", "-i"};
	
	private boolean caseSensitive = true;				//Setting the default values
	private boolean monotonicallyIncreasing = true;
	
	private IBinarySearchtree<IIdentifier> searchTree = new BinarySearchtree<IIdentifier>();
	
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
	
	public StringBuffer readWord(Scanner in){
		StringBuffer temp = new StringBuffer();	
		while((nextCharIsLetter(in) || nextCharIsDigit(in))){
			char c = nextChar(in);
			if (nextCharIsLetter(in) && !caseSensitive) Character.toLowerCase(c);
			temp.append(nextChar(in));
		}
		return temp;
	}
	
	public void processIdentifier(Identifier identifier) {	// makes sure equals are removed..
		if(searchTree.containsElement(identifier)){		// How to parameterize?
				searchTree.remove(identifier);
			} else {
				searchTree.insert(identifier);
			}
		}
	
	void processWord(Scanner in){
		StringBuffer temp = readWord(in);
		if(Character.isLetter(temp.charAt(0))){
			Identifier i = new Identifier(temp);
			processIdentifier(i);
		}
	}
	
	void processDelimiter(Scanner in){
		while (in.hasNext() && !nextCharIsDigit(in) && !nextCharIsLetter(in)) 
			nextChar(in);
	}
	
	public void readFile(Scanner in) {
		in.useDelimiter("");
		while(in.hasNext()){
			processWord(in);
			processDelimiter(in);
		}
	}
	
	public void printTree() {
		Iterator iterator;								// How to parameterize?? 
		if(monotonicallyIncreasing) 
			iterator = searchTree.ascendingIterator();
		else 
			iterator = searchTree.descendingIterator();
		
		while(iterator.hasNext()) {
			Identifier id = (Identifier)iterator.next();
			System.out.printf("%s\n", id.getString());		// This must become getString()
		}
	}
	
	private boolean isCommandLineOption(String s){
		for (int i = 0; i < possibleArgs.length; i++)
			if (s.equals(possibleArgs[i])) return true;
		return false;
	}
	
	public void parseArgs(String[] args) throws FileNotFoundException{
		int counter = 0;
		for(; counter < args.length; counter++){
			while(isCommandLineOption(args[counter])){
				if (args[counter].equals("-i")){
					caseSensitive = false;
				} else {
					monotonicallyIncreasing = false;
				}
				counter++;
			}
			File file = new File(args[counter]);
			Scanner fileScanner = new Scanner(file);
			readFile(fileScanner);
		}
	}
	
	public void start(String[] args) {
		try {
			parseArgs(args);
		} catch (FileNotFoundException e) {
			System.out.print(e.getMessage());
		}
		printTree();
	}
	
	public static void main(String[] args) {
		new Sort().start(args);
	}

}
