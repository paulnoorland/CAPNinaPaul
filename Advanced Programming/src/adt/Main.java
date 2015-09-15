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

	private Identifier createIdentifier(String string){
		Scanner sc = new Scanner(string);
		sc.useDelimiter("");
		
		if(string.length() > 0 && nextCharIsLetter(sc)){
			for (int i = 0; i < string.length(); i++){
				if(!nextCharIsLetter(sc) || !nextCharIsDigit(sc)) return null;	//Kijk hier nog even naar volgens mij doe je 2 keer een check op nextCharIsLetter
			}
			Identifier result = new Identifier(string);
			return result;
		} 
		return null;	//throw exception?
	}
	
	private Set createSet(String string) {
		Scanner sc = new Scanner(string);
		
		sc.useDelimiter(" ");
		
		Set result = new Set();
		while (sc.hasNext()) {
			out.print(sc.next());								//Waarom print je hier?
			result.addIdentifier(createIdentifier(sc.next()));
		}
		sc.close();
		return result;
	}
	
	void printSet(Set set){
		for(int i = 0; i < set.getLength(); i++) {
			out.print(set.getIdentifier().getString());
		}			
	}

	void performOperations(Set set1, Set set2) throws Exception {
		out.print("Difference: ");
		printSet(set1.difference(set2));
		out.print("Intersection: ");
		printSet(set1.intersection(set2));
		out.print("Union: ");
		printSet(set1.union(set2));
		out.print("Symmetric difference: ");
	}
		
	String checkFormat(String setString) {
		if(setString.charAt(0) != '{') {
			return "Missing '{'";
		}
		if((setString.charAt(setString.length() -1)) != '}') {
			return "Missing '}'";
		}
		return null;
	}
	
	void start() {
		while (true) {
			out.print("Give the first collection: ");
			String set1String = in.nextLine();
			if (set1String.length() == 0) return;		//Question must be repeated if no input is given
			
			/*TODO:
			 * Meldingen verwerken van checkFormat en een return doen zodat de while loop opnieuw wordt aangeroepen
			 * de { en } uit de string halen zodat de identifiers er makkelijk in kunnen
			 * Testen. Kijk even of het allemaal goed gegaan is met de operations. Als dat niet gaat zal ik ze 
			 * wel testen want het is wat makkelijker om je eigen code te debuggen. Succes!
			 */
			
			set1String = checkFormat(set1String);
			Set set1 = createSet(set1String);
			
			out.print("Give the second collection: ");
			String set2String = in.nextLine();
			Set set2 = createSet(set2String);
				
			try {
				performOperations(set1, set2);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}		
	}
	
	public static void main(String[] argv) {
        new Main().start();
    } 
}

