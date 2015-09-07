package adt;

/** ADT for the class Collection.
*
* @author Nina Lijzinga & Paul Noorland
* @elements
*	Identifiers of type Identifier
*	Name of type String
* @structure 
*	None 
* @domain
*	Minimum of 0 and maximum of 10 identifiers per collection.
* @constructor
*	Collection();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new collection contains 0 elements and has room for 10
*	    </dl>
*	<br>
*	Collection(Collection col1, Collection col2);
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new
*		Collection-object contains a combination of the two collections
*	    </dl>
**/

public interface Collection {
	
	/** Returns the identifier corresponding to the index
	 * @precondition
	 * Index is filled with an identifier
	 * @postcondition
	 * A copy of the identifier is returned
	 * @return Identifier
	 */
	Identifier getIdentifier(int index);
	
	/** Adds an identifier to the collection
	 * @precondition
	 * Collection is not full
	 * @postcondition
	 * An identifier has been added at the end of the collection
	 * @param identifier
	 */
	void pushIdentifier(Identifier identifier);
	
	/** Returns the length of the collection
	 * @precondition
	 * -
	 * @postcondition
	 * An integer that corresponds to the length of the collection is returned
	 * @return
	 */
	int getLength();
}
