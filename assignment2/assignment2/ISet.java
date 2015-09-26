package assignment2;

/** ADT for the class Set.
*
* @author Nina Lijzinga & Paul Noorland
* @elements
*	Identifiers of type Identifier
* @structure 
*	None 
* @domain
*	Minimum of 0 and maximum of 20 identifiers per set.
* @constructor
*	Set();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new set contains 0 identifiers and has room for 20
*	    </dl>
*	<br>
*	Set(Set set);
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>
*		The new set is a copy of the input set
*	    </dl>
**/

public interface ISet {
	public static int MAX_AMOUNT_IDENTIFIERS = 20;
	
	/**Initializes a set
	 * @precondition
	 * -
	 * @postcondition
	 * The set is initialized to a empty set
	 */
	void init();
	
	/** Returns an identifier
	 * @precondition
	 * Set is non-empty
	 * @postcondition
	 * A copy of an identifier from the set is returned
	 * @return Identifier
	 */
	Identifier getIdentifier();
	
	/** Adds an identifier to the set
	 * @precondition
	 * Set is not full or identifier is already part of the set
	 * @postcondition
	 * The input identifier is now part of the set
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
	
	/**Removes an identifier from the set
	 * @precondition
	 * Set is not empty
	 * @postcondition
	 * An element identifier has been removed from the set
	 * @param identifier
	 */
	void removeIdentifier(Identifier identifier);
	
	/** Returns the union of the set and the input set
	 * @precondition										
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the identifiers of the set and the input set has been returned
	 * FAILURE: The resulting set of the operation is larger than 20 identifiers
	 * @param set
	 * @return
	 * The union of the set and the input set
	 */
	Set union(Set set) throws Exception;
	
	// Descibe the operations
	
	/** Returns the difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * A new set containing the identifiers that are only in the first set and not in the second has been returned
	 * @param set
	 * @return
	 * The difference between the set and the input set
	 */
	Set difference(Set set);
	
	/** Returns the intersection of the set and the input set
	 * @precondition										
	 * -
	 * @postcondition
	 * A new set containing the identifiers that are both in the set and in input set
	 * @param set
	 * @return
	 * The intersection of the set and the input set
	 */
	Set intersection(Set set);
	
	/** Returns the symmetric difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the identifiers of the set and the input set which are not in the intersection has been returned
	 * FAILURE: The resulting set of the operation is larger than 20 identifiers
	 * @param set
	 * @return
	 * The symmetric difference between the set and the input set
	 */
	Set symmetricDifference(Set set) throws Exception;
}