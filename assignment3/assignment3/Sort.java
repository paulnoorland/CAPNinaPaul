package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Sort {
	private boolean caseSensitive = true;				//Setting the default values
	private boolean monotonicallyIncreasing = true;
	
	private BinarySearchtree searchTree = new BinarySearchtree();
	// Can you say here that you want to put identifiers in? How?
	
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
	
	public void processIdentifier(Identifier identifier) {	// makes sure equals are removed..
		if(searchTree.containsElement(identifier)){		// How to parameterize?
				searchTree.remove(identifier);
			} else{
				searchTree.insert(identifier);
			}
	}
	
	public void readFile(Scanner fileScanner) {
		//How to deal with the delimiters????
		
		// Reads the files
		// Determines if identifier or non-identifier
		// 
		// if identifier gives the identifier to processIdentifier
		while(fileScanner.hasNext()) {
			String id = fileScanner.next();
			if(!caseSensitive) id = id.toLowerCase();				
			Scanner idScanner = new Scanner(id);
			Identifier identifier = checkIdentifier(idScanner);
			processIdentifier(identifier);
		}
	}
	
	public void printTree() {
		Iterator iterator;								// How to parameterize?? 
		if(monotonicallyIncreasing) {
			iterator = searchTree.ascendingIterator();
		} else {
			iterator = searchTree.descendingIterator();
		}
		while(iterator.hasNext()) {
			Identifier id = (Identifier)iterator.next();
			System.out.printf("%s\n", id.getStringBuffer().toString());		// This must become getString()
		}
	}
	
	public void start(String[] args) {
		for(int i = 0; i < args.length; i++) {
			if(args[i].equals("-i")) { 
				this.caseSensitive = false;
			} else if(args[i].equals("-d")){
				this.monotonicallyIncreasing = false;
				continue;
			} else {
				File file = new File(args[i]);					// How to check on no file included?
				try {
					Scanner fileScanner = new Scanner(file);
					readFile(fileScanner);
				} catch (FileNotFoundException e) {				// Should it be an APException??
					e.printStackTrace();
				}
			}	
		}
		printTree();
	}
	
	public static void main(String[] args) {
		new Sort().start(args);
	}

}
