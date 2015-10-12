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
 * 		Identifier(StringBuffer s);			
 * 			<dl>
 * 				<dt><b>PRE-condition</b><dd>StringBuffer is valid element
 * 				<dt><b>POST-condition</b><dd>The new element object
 * 				contains a stringBuffer equal to the source stringbuffer.
 *			</dl>
 *		<br>
 *		Identifier(Identifier id1);
 *			<dl>
 *				<dt><b>PRE-condition</b><dd>-
 *				<dt><b>POST-condition</b><dd> The new element is a copy of the source element</dl>
 *			</dl>
 *		<br>				
 **/


public interface IIdentifier extends Data<IIdentifier>{	
	/**Initializes an element
	 * @precondition
	 * String is valid element
	 * @postcondition
	 * The new element object contains a string from the source.
	 */
	void init(String string);
	

	/** Adds an character to the end of the StringBuffer
	 * @precondition
	 * 		The character is alphanumeric and follows the rules of an element
	 * @postcondition
	 * 		The input character is appended to the end of the StringBuffer
	 * @param Character of type char
	 */
	public void appendChar(char c);
	
	/** Returns the stringBuffer saved in the Element
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A stringBuffer representation of the element is returned
	 **/
	
	String getString();
	
	/** Compares element to the input element.
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		an integer has been returned
	 * 		0:
	 * 			The element and the input element contain the exact same sequence of characters
	 * 		1:
	 * 			The input element and this element are not exactly the same.
	 * 
	 * @param IIdentifier
	 * @return integer
	 **/
	public int compareTo(IIdentifier i);
	
	
	/** Creates a deep clone of the IIdentifier
	 * @precondition
	 * 		The IIdentifier is clonable 		//Is dit altijd zo bij een IIdentifier?
	 * @postcondition
	 * 		a copy of this Identifier has been returned
	 * @return IIdentifier
	 */
	public IIdentifier clone();

	
}
