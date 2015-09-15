package adt;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	Scanner in = new Scanner(System.in);
	PrintStream out = new PrintStream(System.out);
	
	Main(){
		
	}
	
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
				if(!nextCharIsLetter(sc) || !nextCharIsDigit(sc)) return null;
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
			out.print(sc.next());
			result.addIdentifier(createIdentifier(sc.next()));
		}
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
		
	void start() {
		while (in.hasNextLine()) {
			Scanner a2 = new Scanner(in.nextLine());
			//Still have to do the scanners
			Set set1 = createSet(in.nextLine());
			Set set2 = createSet(in.nextLine());
				
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

