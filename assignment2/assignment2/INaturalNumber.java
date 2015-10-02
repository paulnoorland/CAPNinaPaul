package assignment2;

/** ADT for class NaturalNumber
 * @author Nina Lijzenga & Paul Noorland
 * @elements
 * 		digits of type character
  * @structure
 * 		lineair
 * @domain
 * 		All natural numbers including zero
 * @constructor		
 *		//What should be constructed? A stringbuffer?
 *		INaturalNumber()
 *		<dl>
 * 				<dt><b>PRE-condition</b><dd>-
 * 				<dt><b>POST-condition</b><dd>A new StringBuffer object has been created
 * 					with zero characters in it.
 *			</dl>
 *		<br>
 */
public interface INaturalNumber extends Data<INaturalNumber>{			
	//Which functions are needed?
	//looks like identifier except for pre and post condition
	
	/**
	 * @precondition
	 * -
	 * @postcondition
	 * A copy of INaturalNumber has been returned
	 * @return StringBuffer
	 */
	StringBuffer getNumber();		//Is this allowed?
	
	/**
	 * @precondition
	 * -
	 * @postcondition
	 * The length of the number is returned as an integer
	 * @return an integer
	 */
	public int getLength();
	
	/**
	 * @precondition
	 * -
	 * @postcondition
	 * A char has replaced the char at the first index if that char was a 0 or has been appended to the end
	 * of the StringBuffer
	 * @param
	 * A character
	 */
	void addNumber(char c);
	
	/**
	 * @precondition
	 * - 
	 * @postcondition
	 * a boolean has been returned.
	 * 		true:
	 * 			The NaturalNumber has no value and so the function returns true
	 * 		false:
	 * 			The Natural number has a value so the function returns false
	 * @return boolean
	 */
	boolean isEmpty();			//Is this necessary or are you always putting something in the number?
	
	//No remove is needed right?
	
	/**
	 * @precondition
	 * Natural number is cloneable			This is already the case because of the inheritance right? So needed?
	 * @postcondition
	 *  A deep copy of the NaturalNumber has been returned
	 * @return
	 */
	INaturalNumber clone();
	
	/**
	 * @precondition
	 * -
	 * @postcondition
	 * -1 is returned when the input NaturalNumber is greater than the local NaturalNumber
	 * 0 is returned when the input NaturalNumber is equal to the local NaturalNumber
	 * +1 is returned when the input NaturalNumber is less than the local NaturalNumber
	 * @return integer
	 */
	int compareTo(INaturalNumber o);
}
