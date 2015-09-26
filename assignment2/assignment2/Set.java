package assignment2;

public class Set implements ISet{
	
	private Identifier[] set;
	private int setLength;
	
	Set () {
		this.set = new Identifier[MAX_AMOUNT_IDENTIFIERS];
		setLength = 0;
	}
	
	Set (Set copySet) {
		set = new Identifier[MAX_AMOUNT_IDENTIFIERS];
		setLength = 0;
		for (int i = 0; i < copySet.getLength(); i++){
			addIdentifier(copySet.set[i]);
		}
	}
	
	public void init(){
		this.set = new Identifier[MAX_AMOUNT_IDENTIFIERS];
	}
	
	/** Returns an identifier
	 * @precondition
	 * Set is non-empty
	 * @postcondition
	 * A copy of an identifier from the set is returned
	 * @return Identifier
	 */
	public Identifier getIdentifier(){					
		return set[setLength - 1];		// Always returns the last element of the set
	}
	
	public void addIdentifier(Identifier identifier){
			this.set[setLength] = identifier;
			setLength++;
	}
	
	public boolean hasIdentifier(Identifier identifier) {
		for (int i = 0; i < getLength(); i++) {
			if (set[i].equals(identifier)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean setIsFull() {
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

	public void removeIdentifier(Identifier identifier){
		for (int i = 0; i < setLength; i++) {
			if (set[i].equals(identifier)) {
				set[i] = set[setLength -1];
				setLength -= 1;
			}
		}
	}
	
	/** Returns the union of the set and the input set
	 * @precondition										
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the identifiers of set and the input set without identifiers that occur in both has been returned
	 * FAILURE: The resulting set of the operation is larger than 20 identifiers
	 * @param set
	 * @return
	 * The union of the set and the input set
	 */
	public Set union(Set s2) throws Exception {
		Set union = new Set(this);
		Set copyS2 = new Set(s2);
		while (copyS2.getLength() > 0) {
			Identifier identifier = copyS2.getIdentifier();
			copyS2.removeIdentifier(identifier);
			if (!union.hasIdentifier(identifier)) {
				if(union.getLength() >= MAX_AMOUNT_IDENTIFIERS){
					throw new Exception();
				}
			union.addIdentifier(identifier);
			}
		}
		return union;
	}
	
	/** Returns the difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * A new set containing the identifiers that are only in the set and not in the input set has been returned
	 * @param set
	 * @return
	 * The difference between the set and the input set
	 */	
	public Set difference(Set set2) {
		Set difference = new Set(this);
		for (int i = 0; i < difference.getLength(); i++) {
			Set copyS2 = new Set(set2);
			while (copyS2.getLength() > 0) {
				Identifier identifier = copyS2.getIdentifier();
				copyS2.removeIdentifier(identifier);
				if (identifier.equals(difference.set[i])) {
					difference.removeIdentifier(difference.set[i]);
					i--;
					break;
				}
			}
		}
		return difference;
	}
	
	/** Returns the intersection of the set and the input set
	 * @precondition										
	 * -
	 * @postcondition
	 * A new set containing the identifiers that are both in the set and the input set has been returned
	 * @param set
	 * @return
	 * The intersection of the set and the input set
	 */
	public Set intersection(Set set2){
		Set copySet1 = new Set(this);
		Set intersection = new Set();
		
		for (int i = 0; i < copySet1.setLength; i++) {
			Set copySet2 = new Set(set2);
			while (copySet2.setLength > 0) {
				Identifier identifier = copySet2.getIdentifier();
				copySet2.removeIdentifier(identifier);
				if (identifier.equals(copySet1.set[i])) {
					intersection.addIdentifier(copySet1.set[i]);
				}
			}
		}
		return intersection;
	}
	
	/** Returns the symmetric difference between the set and the input set
	 * @precondition
	 * -
	 * @postcondition
	 * SUCCESS: A new set containing the identifiers that are only in the set and only in the input set has been returned
	 * FAILURE: The resulting set of the operation is larger than 20 identifiers
	 * @param set
	 * @return
	 * The symmetric difference between the set and the input set
	 */
	public Set symmetricDifference(Set set2) throws Exception{
		Set intersection = intersection(set2);
		Set differenceSet1 = difference(intersection);
		Set copySet2 = new Set(set2);
		for (int i = 0; i < copySet2.getLength(); i++) {
			Set copyIntersection = new Set(intersection);
			while (copyIntersection.getLength() > 0) {
				Identifier identifier = copyIntersection.getIdentifier();
				copyIntersection.removeIdentifier(identifier);
				if (copySet2.set[i].equals(identifier)){
					copySet2.removeIdentifier(identifier);
					i--;
					break;
				}
			}
		}
		if (differenceSet1.getLength() + copySet2.getLength() > MAX_AMOUNT_IDENTIFIERS) {
			throw new Exception();
		}
		for (int i = 0; i < copySet2.getLength(); i++) {
			differenceSet1.addIdentifier(copySet2.set[i]);
		}
		return differenceSet1;
	}
}