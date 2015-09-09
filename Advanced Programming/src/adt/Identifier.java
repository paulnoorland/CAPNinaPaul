package adt;
/** ADT for the class Element.
 * 
 * @author Nina Lijzenga & Paul Noorland
 * @elements
 * 		String 
 *	
 * @structure
 * 		lineair
 * @domain
 * 		begins with a letter, 
 * 		is alphanumeric and has a length of at least 1 character.
 * @constructor
 * 		
 * 		Element(String string);			
 * 			<d1>
 * 				<dt><b>PRE-condition</b><dd>-
 * 				<dt><b>POST-condition</b><dd>The new Element object
 * 				contains a string from the source.
 *			</d1>
 *		<br>				
 **/

public interface Identifier{	
	/** Returns the string saved in the 
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		returns a copy of the String in the Element
	 **/
	String getString();
	
	/** Checks whether a String is an element
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		returns whether a String is an Element.
	 * 		true: 
	 * 			String begins with a letter, is alphanumeric and non-empty
	 * 		false:
	 * 			String either doesn't begin with a letter, is non-alphanumeric or is empty
	 **/
	boolean isElement(String string);
}
