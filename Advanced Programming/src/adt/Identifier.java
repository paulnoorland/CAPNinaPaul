package adt;
/** ADT for the class Identifier.
 * 
 * @author Nina Lijzenga & Paul Noorland
 * @elements
 * 		String 
 * 	
 * @structure
 * 		lineair
 * @domain
 * 		all rows begin with a letter, 
 * 		is alphanumeric and has a length of at least 1 character.
 * @constructor
 * 		
 * 		Identifier(String string);			
 * 			<dl>
 * 				<dt><b>PRE-condition</b><dd>-
 * 				<dt><b>POST-condition</b><dd>The new Element object
 * 				contains a string from the source.
 *			</dl>
 *		<br>
 *		Identifier(Identifier id1);
 *			<dl>
 *				<dt><b>PRE-condition</b><dd>-
 *				<dt><b>POST-condtition</b><dd> The new Identifier is a copy of the source identifier</dl>
 *			</dl>
 *		<br>				
 **/

public interface Identifier{	
	/**Initializes an identifier
	 * @precondition
	 * -
	 * @postcondition
	 * The identifier is initialized to an empty identifier.
	 */
	void init();
	/** Returns the string saved in the 
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		Copy of the identifier has been initialized.
	 **/
	String getString();
	
	/** Compares identifier to the input identifier.
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		a boolean has been returned.
	 * 		true:
	 * 			The input identifier and this identifier are equal.
	 * 		false:
	 * 			The input identifier and this identifier are not equal.
	 * 
	 * @param identifier
	 * @return boolean
	 **/
	boolean equals(Identifier id);
	
}
