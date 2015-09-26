package assignment2;
/** ADT for the class Identifier.
 * 
 * @author Nina Lijzenga & Paul Noorland
 * @elements
 * 		Characters of type char
 * @structure
 * 		lineair
 * @domain
 * 		All sequences begin with a letter, 
 * 		are alphanumeric and have a length of at least 1 character.
 * @constructor		
 * 		Identifier(String string);			
 * 			<dl>
 * 				<dt><b>PRE-condition</b><dd>String is valid identifier
 * 				<dt><b>POST-condition</b><dd>The new Identifier object
 * 				contains a string from the source.
 *			</dl>
 *		<br>
 *		Identifier(Identifier id1);
 *			<dl>
 *				<dt><b>PRE-condition</b><dd>-
 *				<dt><b>POST-condition</b><dd> The new Identifier is a copy of the source identifier</dl>
 *			</dl>
 *		<br>				
 **/

public interface IIdentifier{	
	/**Initializes an identifier
	 * @precondition
	 * -
	 * @postcondition
	 * The new Identifier object contains a string from the source.
	 */
	void init(String string);
	
	/** Returns the string saved in the Identifier
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A string representation of the identifier is returned
	 **/
	String getString();
	
	/** Compares identifier to the input identifier.
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		a boolean has been returned.
	 * 		true:
	 * 			The identifier and the input identifier contain the exact same sequence of characters
	 * 		false:
	 * 			The input identifier and this identifier are not equal.
	 * 
	 * @param identifier
	 * @return boolean
	 **/
	boolean equals(Identifier id);
}
