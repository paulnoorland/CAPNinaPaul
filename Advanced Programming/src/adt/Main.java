package adt;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	Scanner in = new Scanner(System.in);
	//Empty constructor
	
	private ISet createSet() {
		//Create scanner
		//Create a new collection object
		while (in.hasNext()) {
			//Scanner reads line, checks if the input is correct and parses the identifiers
			//Create for each identifier a new identifier object
			// Check if identifier is already in the set 
			//Put the identifier object into the collection
		}
		//return collection
	}
	
	void writeCollection(ISet set){
		System.out.print(set.getName() + "/t = ");	//I created this in the collection class
		for(int i = 0; i < set.getLength(); i++) {
			System.out.print(set.getIdentifier(i).getString());
		}			
	}

	void performOperations(ISet col1, ISet col2) {		//Better name? What are the operations combined called?
		//create a new collection with the difference (class)
		//write collection
		//create a new collection with the intersection (class)
		//write collection
		//create a new collection with the union (class)
		//write collection
		//create a new collection with the symmetric difference (class)
		//write collection
	}
		
	void start() {
		
		while (in.hasNextLine()) {
			Scanner a2 = new Scanner(in.nextLine());
		//Print the text
		//Take in the line and create collection 1 --> createCollection
		//Take in the other line and create collection 2 --> createCollection
		//Calculate the difference, intersection, union and symmetric difference and print them --> performOperations
		}		
	}
	
	public static void main(String[] argv) {
        new Main().start();
    } 
}

