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
 *		INaturalNumber()
 *		<dl>
 * 				<dt><b>PRE-condition</b><dd>-
 * 				<dt><b>POST-condition</b><dd>A new StringBuffer object has been created
 * 					with the character 0.
 *			</dl>
 *		<br>
 */
public interface INaturalNumber extends Data<INaturalNumber>{
	
	/**
	 * @precondition
	 * -
	 * @postcondition
	 * A copy of INaturalNumber has been returned
	 * @return StringBuffer
	 */
	String getNumber();
	
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
	 * Character is a digit
	 * @postcondition
	 * A char has replaced the char at the first index if that char was a 0 or has been appended to the end
	 * of the NaturalNumber
	 * @param
	 * A character
	 */
	void addNumber(char c);
	
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
	 * <0 is returned when the input NaturalNumber is greater than the local NaturalNumber
	 * 0 is returned when the input NaturalNumber is equal to the local NaturalNumber
	 * >0 is returned when the input NaturalNumber is less than the local NaturalNumber
	 * @return integer
	 */
	int compareTo(INaturalNumber o);
}
