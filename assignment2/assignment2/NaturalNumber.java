package assignment2;

public class NaturalNumber implements INaturalNumber{
	//The append method always adds these characters at the end of the buffer; 
	//the insert method adds the characters at a specified point.
	
	private StringBuffer number;
	
	NaturalNumber(){
		number = new StringBuffer();
	}
	
	public char getNumber(){
		
		return 'a';
	}
	
	public void addNumber(char c){
		if(number.charAt(0) == 0) {
			number.insert(0, c);
		} else {
			number.append(c);
		}
	}
	
	public void removeNumber(char c){	//Is this the best way or is index better?
		
	}
	
	public NaturalNumber clone(){
		
		return this;
	}

	@Override
	public int compareTo(INaturalNumber o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
