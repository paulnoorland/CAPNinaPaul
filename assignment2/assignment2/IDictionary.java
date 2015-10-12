package assignment2;

/** ADT for the class Dictionary.
*
* @author Nina Lijzenga & Paul Noorland
* @elements
*	Pairs of keys of type K and values of type V 
* @structure 
*	none
* @domain
*	All elements of type Dictionary including an empty list
*   Unique keys
* @constructor
*	Dictionary();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>The new dictionary contains 0 dictionaryElements.
*	    </dl>
*	<br>
**/
public interface IDictionary<K extends Data<K>, V extends Clonable<V>>  {

	/**Initializes a dictionary
	 * @precondition
	 * -
	 * @postcondition
	 * The dictionary is initialized to an empty dictionary.
	 */
	public void init();
	
	/**Retrieves the value that is linked to the input key in the dictionary
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		A copy of the value that is linked to the input key is returned
	 * @param key
	 * @return value
	 * @exception the key was not in the dictionary
	 */
	public V getValue(K key) throws APException;
	
	/**adds an key-value pair to the dictionary
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		The key-value pair is added to the dictionary
	 * @param key
	 * @param value
	 */
	public void add(K key, V value);
	
	/**Removes the key-value pair that is linked to the input key in the dictionary
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		the key-value pair that was linked to the input key in the dictionary has been removed from the dictionary
	 * @param key
	 * @exception The key was not in the dictionary
	 */
	public void remove(K key) throws APException;	
}
