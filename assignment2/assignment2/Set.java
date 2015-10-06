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
		set.insert(element);
	}
	
	public int getLength(){
		return set.size();
	}
	
	public boolean isEmpty(){
		return set.isEmpty();
	}

	public void removeElement(E element){
		set.find(element);
		set.remove();
	}
	
	public Set<E> clone() {
		Set<E> clone = new Set<E>();
		clone.set = (List<E>) set.clone();
		return clone;
	}
	
	public ISet<E> union(ISet<E> set2){
		Set<E> union = this.clone();
		Set<E> copySet2 = (Set<E>) set2.clone();
		while(!copySet2.isEmpty()) {
			E element = copySet2.getElement();
			copySet2.removeElement(element);
			if(!union.hasElement(element)) {
				union.addElement(element);
			}
		}
		return union;
	}
	
	public ISet<E> difference(ISet<E> set2) {
		Set<E> difference = this.clone();
		difference.set.goToFirst();
		for (int i = 0; i < difference.getLength(); i++) {
			Set<E> copySet2 = (Set<E>) set2.clone();
			while (!copySet2.isEmpty()) {
				E element = copySet2.getElement();
				copySet2.removeElement(element);
				if(element.compareTo(difference.getElement()) == 0) {		//compareTo in natural number gives 0 if they are equal
					difference.removeElement(difference.getElement());
					i--;
					break;
				}
			}
			difference.set.goToNext();
		}
		return difference;
	}
	
	public ISet<E> intersection(ISet<E> set2){
		Set<E> copySet1 = this.clone();
		Set<E> intersection = new Set<E>();
		copySet1.set.goToFirst();
		for (int i = 0; i < copySet1.getLength(); i++) {
			Set<E> copySet2 = (Set<E>) set2.clone();
			while(!copySet2.isEmpty()){
				E element = copySet2.getElement();
				copySet2.removeElement(element);
				if(element.compareTo(copySet1.getElement()) == 0) {
					intersection.addElement(copySet1.getElement());
				}
			}
			copySet1.set.goToNext();
		}
		return intersection;
	}
	
	public ISet<E> symmetricDifference(ISet<E> set2){
		Set<E> intersection = (Set<E>) intersection(set2);
		Set<E> differenceSet1 = (Set<E>) difference(intersection);
		Set<E> copySet2 = (Set<E>) set2.clone();
		copySet2.set.goToFirst();
		
		for(int i = 0; i < copySet2.getLength(); i++) {
			Set<E> copyIntersection = intersection.clone();
			while(!copyIntersection.isEmpty()) {
				E element = copyIntersection.getElement();
				copyIntersection.removeElement(element);
				if(element.compareTo(copySet2.getElement()) == 0) {
					copySet2.removeElement(copySet2.getElement());
					i--;
					break;
				}
			}
			copySet2.set.goToNext();
		}
		copySet2.set.goToFirst();
		for(int i = 0; i < copySet2.getLength(); i++) {
			differenceSet1.addElement(copySet2.getElement());
			copySet2.set.goToNext();
		}
		return differenceSet1;
	}
}