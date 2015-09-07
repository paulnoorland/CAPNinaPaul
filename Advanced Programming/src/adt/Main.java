package adt;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	
	Scanner in = new Scanner(System.in);
	//Empty constructor
	
	private Collection createCollection(){
		//Create scanner
		//Create a new collection object
		while (in.hasNext()) {
			//Scanner reads line, checks if the input is correct and parses the identifiers
			//Create for each identifier a new identifier object
			//Put the identifier object into the collection
		}
		//return collection
	}
	
	void writeCollection(Collection collection){
		System.out.print(collection.getName() + "/t = ");	//I created this in the collection class
		for(int i = 0; i < collection.getLength(); i++) {
			System.out.print(collection.getIdentifier(i).getString());
		}			
	}

	void performOperations(Collection col1, Collection col2) {		//Better name? What are the operations combined called?
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
		while (true) {
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

