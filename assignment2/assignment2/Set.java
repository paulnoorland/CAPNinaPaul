package assignment2;

public class Set<E extends Data<E>> implements ISet<E>{
	//TODO: must be implemented as a list and not an array
	
	private List<E> set;
	
	Set () {
		set = new List<E>();
	}
	
	public void init(){
		this.set = set.init();
	}
	
	public E getElement(){
		return (E) set.retrieve();					
	}
	
	public boolean hasElement(E element) {
		return set.find(element);
	}
	
	public void addElement(E element) {
		if(!set.find(element))
			set.insert(element);
	}
	
	public int size(){
		return set.size();
	}

	public void removeElement(E element){
		if(set.find(element)) {
			set.remove();
		}
	}
	
	public ISet<E> clone() {
		Set<E> clone = new Set<E>();
		clone.set = (List<E>) set.clone();
		return clone;
	}
	
	public ISet<E> union(ISet<E> set2){
		ISet<E> union = this.clone();
		ISet<E> copySet2 = (Set<E>) set2.clone();
		while(copySet2.size() != 0) {
			E element = copySet2.getElement();
			copySet2.removeElement(element);
			if(!union.hasElement(element)) {
				union.addElement(element);
			}
		}
		return union;
	}
	
	public ISet<E> difference(ISet<E> set2) {
		ISet<E> difference = this.clone();
		ISet<E> copySet2 = set2.clone();
			while (copySet2.size() != 0) {
				E element = copySet2.getElement();
				copySet2.removeElement(element);
				if(difference.hasElement(element)) {
					difference.removeElement(difference.getElement());			
				}
		}
		return difference;
	}
	
	public ISet<E> intersection(ISet<E> set2){
		ISet<E> copySet1 = this.clone();
		ISet<E> copySet2 = (Set<E>) set2.clone();
		ISet<E> intersection = new Set<E>();
		
		while(copySet2.size() != 0){
			E element = copySet2.getElement();
			copySet2.removeElement(element);
			if(copySet1.hasElement(element)) {
				intersection.addElement(element);
			}
		}
		return intersection;
	}
	
	public ISet<E> symmetricDifference(ISet<E> set2){
		ISet<E> intersection = intersection(set2);
		ISet<E> symmetricDifference = difference(intersection);	
		ISet<E> copySet2 = set2.clone();
		
		while(copySet2.size() != 0) {
			E element = copySet2.getElement();
			copySet2.removeElement(element);
			if(!intersection.hasElement(element)) {
				symmetricDifference.addElement(element);
			}
		}
		return symmetricDifference;
	}
}