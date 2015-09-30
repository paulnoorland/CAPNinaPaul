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
	
	char getNumber();
	
	void addNumber(char c);
	
	void removeNumber(char c);			//Is this the best way or is index better?
	
	NaturalNumber clone();
	
	int compareTo(INaturalNumber o);
}
