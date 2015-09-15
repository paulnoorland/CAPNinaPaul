package adt;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	Scanner in = new Scanner(System.in);
	PrintStream out = new PrintStream(System.out);
	
	boolean nextCharIsLetter (Scanner in) {
		return in.hasNext("[a-zA-Z]");
		}
	
	boolean nextCharIsDigit (Scanner in) {
		return in.hasNext("[0-9]");
		}
	
	private boolean checkIdentifierFormat(Scanner temp){
		out.println(temp.next());
		if(!nextCharIsLetter(temp)) return false;
		while(temp.hasNext()){
			if(!(nextCharIsLetter(temp) || nextCharIsDigit(temp))) return false;
			//temp.next(); //nextCharIsLetter and nextChar is digit don't read in characters
						 //not sure if this works, otherwise for statement with string.length and charAt(i)
		}	
		return true;
	}
	
	//overbodig?
	private Identifier createIdentifier(String string){
		Identifier result = new Identifier(string);
		return result;
	}
	
	private Set createSet(Scanner setScanner) {
		setScanner.useDelimiter(" ");
		Set result = new Set();
		
		while (setScanner.hasNext()) {
			String temp = setScanner.next();
			
			Scanner tempScanner = new Scanner(temp);
			if(checkIdentifierFormat(tempScanner)) result.addIdentifier(createIdentifier(temp));
			else out.print("Identifier format wrong");
		}
		return result;
	}
	
	void printSet(Set set){
		for(int i = 0; i < set.getLength(); i++) {
			out.print(set.getIdentifier().getString());
		}			
	}

	void performOperations(Set set1, Set set2) throws Exception {
		out.println("Difference: ");
		printSet(set1.difference(set2));
		out.println("Intersection: ");
		printSet(set1.intersection(set2));
		out.println("Union: ");
		printSet(set1.union(set2));
		out.println("Symmetric difference: ");
	}
		
	Boolean checkSetFormat(String string) {
		if(string.length() == 0){
			return false;
		}
		if(string.charAt(0) != '{') {
			out.println("Missing '{'. ");
			return false;
		}
		if((string.charAt(string.length() -1)) != '}') {
			out.println("Missing '}'. ");
			return false;
		}
		return true;
	}
	
	String formatString(String string){
		return string.substring(1, string.length() - 1 );  //-2 misschien?
	}
	
	void start() {
		//Sebastian had het erover dat while(in.hasNextLine()) beter is geloof ik..

		while (true) {
			out.println("Give the first collection: ");
			String set1String = in.nextLine();
			
			/*TODO:
			 * Meldingen verwerken van checkFormat en een return doen zodat de while loop opnieuw wordt aangeroepen
			 * de { en } uit de string halen zodat de identifiers er makkelijk in kunnen
			 * Testen. Kijk even of het allemaal goed gegaan is met de operations. Als dat niet gaat zal ik ze 
			 * wel testen want het is wat makkelijker om je eigen code te debuggen. Succes!
			 */
			
			if(checkSetFormat(set1String)){
				Scanner setScanner = new Scanner(formatString(set1String));
				Set set1 = createSet(setScanner);
				
				out.println("Give the second collection: ");
				String set2String = in.nextLine();
				
				if(checkSetFormat(set2String)){
					setScanner = new Scanner(formatString(set2String));
					Set set2 = createSet(setScanner);
					
					if(set2.isEmpty()) out.println("Set is empty mate");
					else out.print("test" + set2.getIdentifier().getString());
					
					try {
						performOperations(set1, set2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
			}
		}		
	}
	
	public static void main(String[] argv) {
        new Main().start();
    } 
}

