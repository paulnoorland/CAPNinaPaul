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
 *		
 *		INaturalNumber()
 *			- 0
 *
 *		new StringBuffer('0');
 */
public interface INaturalNumber extends Data<INaturalNumber>{			
	//Which functions are needed?
	//looks like identifier except for pre and post condition
	
	char getNumber();
	
	
	void addNumber(char c);
	
	void removeNumber(char c);			//Is this the best way or is index better?
	
	boolean compareTo();
	
	INaturalNumber clone();
}
