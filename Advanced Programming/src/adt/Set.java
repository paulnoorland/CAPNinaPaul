package adt;

public class Set implements ISet{
	
	private Identifier[] set;
	private int setLength;
	
	Set () {
		this.set = new Identifier[MAX_AMOUNT_IDENTIFIERS];
		setLength = 0;
	}
	
	Set (Set originalSet) {
		this.set = new Identifier[MAX_AMOUNT_IDENTIFIERS];
		for (int i = 0; i < originalSet.getLength(); i++) {
			addIdentifier(originalSet.getIdentifier());
		}
	}
	
	public void init(){
		Set s1 = new Set();			//Is good?
		set = s1.set;
	}
	
	/** Returns an identifier
	 * @precondition
	 * Set is non-empty
	 * @postcondition
	 * A copy of an identifier from the set is returned
	 * @return Identifier
	 */
	public Identifier getIdentifier(){			//Can you work with indices here or loop?
		
	}
	
	public void addIdentifier(Identifier identifier){
		if (setIsFull() || identifierIsInSet(identifier)) {
			return;
		} else {
			this.set[setLength] = identifier;
			setLength++;
		}
	}
	
	private boolean identifierIsInSet(Identifier identifier) {
		for (int i = 0; i < getLength(); i++) {
			if (set[i].getString().equals(identifier.getString())) {
				return true;
			}
		}
		return false;
	}
	
	private boolean setIsFull() {
		if (setLength >= 10){
			return true;
		} else {
			return false;
		}
	}
	
	public int getLength(){
		return this.setLength;
	}
	
	public boolean isEmpty(){
		if (setLength == 0) {			// Is this save enough or should it be setLength <= 0
			return true;
		} else {
			return false;
		}
	}
	
	/**Removes an identifier from the set
	 * @precondition
	 * Set is not empty
	 * @postcondition
	 * An element identifier has been removed from the set
	 * @param identifier
	 */
	public void removeIdentifier(Identifier identifier){			// Work with indices?
		if (!isEmpty()) {
			return;
		}
		// search for same identifier with equals function in a loop
		// If it is the same move every element after that 1 to the left, make
		// the set[setLength] = null and setLength--;
		
		
		
	}
	
	/** Returns the union of the set and the input set
	 * @precondition										//Is this correct??
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the union of the set and the input set has been returned
	 * FAILURE: The resulting set of the operation is larger than 20 identifiers
	 * @param set
	 * @return
	 * The union of the set and the input set
	 */
	public Set union(Set set) throws Exception{
		
	}
	
	/** Returns the difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * A new set containing the difference between the set and the input set has been returned
	 * @param set
	 * @return
	 * The difference between the set and the input set
	 */
	public Set difference(Set set){
		
	}
	
	/** Returns the intersection of the set and the input set
	 * @precondition										
	 * -
	 * @postcondition
	 * A new set containing the intersection of the set and the input set has been returned
	 * @param set
	 * @return
	 * The intersection of the set and the input set
	 */
	public Set intersection(Set set){
		
	}
	
	/** Returns the symmetric difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the symmetric difference between the set and the input set has been returned
	 * FAILURE: The resulting set of the operation is larger than 20 identifiers
	 * @param set
	 * @return
	 * The symmetric difference between the set and the input set
	 */
	public Set symmetricDifference(Set set) throws Exception{
		
	}

}
