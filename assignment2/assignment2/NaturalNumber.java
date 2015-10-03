package assignment2;

public class NaturalNumber<E extends Data<E>> implements INaturalNumber{
	//The append method always adds these characters at the end of the buffer; 
	//the insert method adds the characters at a specified point.
	
	private StringBuffer number;
	
	NaturalNumber(){
		number = new StringBuffer();
	}
	
	public StringBuffer getNumber(){
		return number;
	}
	
	public int getLength() {
		return number.length();
	}
	
	public void addNumber(char c){
		if(number.charAt(0) == 0) {
			number.insert(0, c);
		} else {
			number.append(c);
		}
	}
	
	public boolean isEmpty(){
		return (number.length() == 0);
	}
	
	public NaturalNumber clone(){
		NaturalNumber copy = null;						// Must be initialized..
		try {
			copy = (NaturalNumber)super.clone();
		} catch (CloneNotSupportedException e) {		// Is this the correct way?
			e.printStackTrace();
		}
		copy.number = this.number;
		return copy;
	}
	
	public int compareTo(INaturalNumber input){
		if(number.length() > input.getLength()) {
			return 1;
		} else if(number.length() < input.getLength()) {
			return -1;
		} else if(number.length() == input.getLength()){
			for(int i = 0; i < number.length(); i++){
				if(number.charAt(i) > input.getNumber().charAt(i)) {
					return 1;
				} else if(number.charAt(i) < input.getNumber().charAt(i)) {
					return -1;
				}
			}
		}
		return 0;				//This means they are equal
	}
}
