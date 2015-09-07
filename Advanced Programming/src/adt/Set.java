package adt;

/** ADT for the class Set.
*
* @author Nina Lijzinga & Paul Noorland
* @elements
*	Identifiers of type Identifier
* @structure 
*	None 
* @domain
*	Minimum of 0 and maximum of 20 identifiers per collection.
* @constructor
*	Collection();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new collection contains 0 elements and has room for 10
*	    </dl>
*	<br>
*	Collection(Collection col1);
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>
*		The new collection is a copy of the input collection
*	    </dl>
**/

public interface Set {
	public static int MAX_AMOUNT_IDENTIFIERS = 20;
	
	/**Initializes a set
	 * @precondition
	 * -
	 * @postcondition
	 * The set is initialized to a empty set
	 */
	void init();
	
	/** Returns the identifier corresponding to the index
	 * @precondition
	 * Index is non-empty
	 * @postcondition
	 * A copy of the identifier is returned
	 * @return Identifier
	 */
	Identifier getIdentifier(int index);
	
	/** Adds an identifier to the set
	 * @precondition
	 * Collection is not full
	 * @postcondition
	 * An element identifier is now part of the set
	 * @param identifier
	 */
	void addIdentifier(Identifier identifier);
	
	/** Returns the length of the set
	 * @precondition
	 * -
	 * @postcondition
	 * An integer that corresponds to the length of the set is returned
	 * @return
	 */
	int getLength();
	
	/** Returns whether the set is empty
	 * @precondition
	 * -
	 * @postcondition
	 *	returns true if the set is empty
	 *	returns false if the set is not empty
	 */
	boolean isEmpty();
}