package assignment2;

public class List<E extends Data<E>> implements ListInterface<E>  {

	//TODO: What happens with elements with a key that's already in the list?????
	Node currentElement;
	Node head;				// points to first element of the list
	Node tail;				// points to last element of the list
	
	private int size;
	
	List(){
		init();
	}
	
	public List<E> init(){
		head = null;
		tail = null;
		currentElement = null;
		size = 0;
		return this;
	}

	public int size(){
		return size;
	}

	private void placeNode(Node newNode, Node before, Node after) {
		newNode.prior = before;
		newNode.next = after;
		if(after != null) after.prior = newNode;
		if(before != null) before.next = newNode;
	}

	public ListInterface<E> insert(E d){			//What has to be current element?
		if(size == 0) {													// EMPTY LIST
			currentElement = head = tail = new Node(d.clone(), null, null);		// Watch for reference errors
		} else {
			goToFirst();
			Node newNode = new Node(d.clone(), null, null);
			if(newNode.data.compareTo(currentElement.data) < 0) {		// Add in front
				placeNode(newNode, null, currentElement);
				head = newNode;
			} else {
				int j;
				for(j = 1; j < size; j++) {							// Add in the middle
					if(currentElement.data.compareTo(newNode.data) < 0) {
						goToNext();
					} else {
						placeNode(newNode, currentElement.prior, currentElement);
						break;
					}
				}
				if (j == size) {											// Better solution please Sebas
					placeNode(newNode, currentElement, null); 				// Add to end //Check if this works because of null.prior
					tail = newNode;
				}
			}
			currentElement = newNode;		//too dirty? Was needed for the go to next...
		}
		size++;
		return this;
	}

	public E retrieve(){
		return currentElement.data.clone();
	}

	public ListInterface<E> remove(){
		if(size == 1) {												//Remove the only element
			head = tail = currentElement = null;
		} else if(currentElement == head) {							//Remove first element
			head = currentElement.next;
			head.prior = null;
			currentElement = head;
		} else if(currentElement == tail) {							//Remove last element
			tail = currentElement.prior;
			currentElement = tail;
			currentElement.next = null;
		} else {													//Remove element in middle
			currentElement.prior.next = currentElement.next;
			currentElement.next.prior = currentElement.prior;
			currentElement = currentElement.next;
		}
		size--;
		return this;
	}

	public boolean find(E d){				
		goToFirst();						
		for(int i = 0; i < size; i++) {
			if (currentElement.data.compareTo(d) == 0) {			
				return true;
			}
			goToNext();
		}
		return false;
	}

	public boolean goToFirst(){
		if(size != 0) {
			currentElement = head;
			return true;
		} else {
			return false;
		}	
	}

	public boolean goToLast(){
		if(size != 0) {
			currentElement = tail;
			return true;
		} else {
			return false;
		}
	}

	public boolean goToNext(){
		if(size == 0 || currentElement == tail) {
			return false;
		} else {
			currentElement = currentElement.next;
			return true;
		}
	}

	public boolean goToPrevious(){
		if(size != 0 || currentElement == head) {
			return false;
		} else {
			currentElement = currentElement.prior;
			return true;
		}
	}

	public ListInterface<E> clone(){
		List<E> clone = new List<E>();
		if (currentElement == null) return clone;
		E currentElementClone = currentElement.data.clone();
		goToFirst();
		for (int i = 0; i < size; i++) {
			clone.insert(currentElement.data.clone());
			goToNext();
		}
		clone.find(currentElementClone);		//This causes the currentElement to equal the parameter
		return clone;
	}

	private class Node {
	    E data;
	    Node prior, next;

	    public Node(E d) {
	        this(d, null, null);
	    }

	    public Node(E data, Node prior, Node next) {
	        this.data = data == null ? null : data;
	        this.prior = prior;
	        this.next = next;
	    }
	}
}
