package adt;

public interface Operation {
	/**
	 * precondition:
	 * 		Two separate collections
	 * postcondition:
	 * 		One collection with the output of the operation. (Union/Intersection/difference/symmetricdifference)
	 **/
	Collection performOperation(Collection collection1, Collection collection2);
	
	
}