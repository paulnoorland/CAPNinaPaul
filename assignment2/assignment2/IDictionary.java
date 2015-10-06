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
public interface IDictionary<K extends Data<K>, V extends Clonable<V>>  { // clonable

	/**Initializes a dictionary
	 * @precondition
	 * -
	 * @postcondition
	 * The dictionary is initialized to an empty dictionary.
	 */
	public void init();
	
	/**Retrieves the value that is linked to the input key in the dictionary
	 * @precondition
	 * 		The key-value pair is in the dictionary
	 * @postcondition
	 * 		A copy of the value that is linked to the input key is returned
	 * @param key
	 * @return value
	 */
	public V getValue(K key) throws APException;
	
	/**adds an key-value pair to the dictionary
	 * @precondition
	 * 		There is not already a dictionaryElement in the dictionary that contains the input key.
	 * @postcondition
	 * 		The key-value pair is added to the dictionary
	 * @param key
	 * @param value
	 */
	public void add(K key, V value);
	
	/**Removes the key-value pair that is linked to the input key in the dictionary
	 * @precondition
	 * 		the key-value pair is in the dictionary
	 * @postcondition
	 * 		the key-value pair that was linked to the input key in the dictionary has been removed from the dictionary
	 * @param key
	 */
	public void remove(K key) throws APException;
	
	/**Returns whether a key-value pair is in the dictionary
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		TRUE: The key-value pair is in the dictionary.
	 * 		FALSE: The key-value pair is not in the dictionary.
	 * @param key
	 * @return boolean
	 */
	public boolean isInDictionary(K key);

	//Moet hier nog de ADT van dictionaryElement
	
}
