package adt;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	Scanner in = new Scanner(System.in);
	PrintStream out = new PrintStream(System.out);
	
	
	boolean isAlphanumeric(String string){
		for(int i = 0; i<string.length(); i++){
			char temp = string.charAt(i);
			if(!(Character.isDigit(temp) || Character.isLetter(temp))) return false;
		}
		return true;
	}
	
	private boolean checkIdentifierFormat(String string){
		if(!Character.isLetter(string.charAt(0)) || !isAlphanumeric(string) || !(string.length() > 0)) return false;
		return true;
	}
	
	private Identifier createIdentifier(String string){ //overbodig?
		return new Identifier(string);
	}
	
	private Set createSet(Scanner setScanner) {
		setScanner.useDelimiter(" ");
		Set result = new Set();
		
		while (setScanner.hasNext()) {
			String temp = setScanner.next();		
			
			if(checkIdentifierFormat(temp)) result.addIdentifier(createIdentifier(temp));
			else out.println("Identifier format wrong"); //Should return to asking for first collection..
		}
		return result;
	}
	
	void printSet(Set set){
		System.out.println(set.getLength());
		for(int i = 0; i < set.getLength(); i++) {
			out.print(set.getIdentifier().getString());
		}			
	}

	void performOperations(Set set1, Set set2) throws Exception {
		//out.println("Difference: ");
		//printSet(set1.difference(set2));
		//out.println("Intersection: ");
		//printSet(set1.intersection(set2));
		out.println("Union: ");
		printSet(set1.union(set2));
		//out.println("Symmetric difference: ");
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
	
	String formatString(String string){	//overbodig?
		return string.substring(1, string.length() - 1 );
	}
	
	void start() {
		//Sebastian had het erover dat while(in.hasNextLine()) beter is geloof ik..
		while (true) {
			out.println("Give the first collection: ");
			String set1String = in.nextLine();
			
			/*TODO:
			 * Kijk even of het allemaal goed gegaan is met de operations. Als dat niet gaat zal ik ze 
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

