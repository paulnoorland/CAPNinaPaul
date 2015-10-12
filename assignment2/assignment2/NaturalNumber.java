package assignment2;

public class NaturalNumber<E extends Data<E>> implements INaturalNumber{
	
	private StringBuffer number;
	
	NaturalNumber(){
		number = new StringBuffer('0');
	}
	
	public int getLength() {
		return number.length();
	}
	
	public void addNumber(char c){
		if(getLength() == 0 || !(number.charAt(0) == '0')) {
			number.append(c);
		} else {
			number.deleteCharAt(0);
			number.append(c);
		}
	}
	
	public INaturalNumber clone(){
		NaturalNumber copy = null;						// Must be initialized..
		try {
			copy = (NaturalNumber)super.clone();
		} catch (CloneNotSupportedException e) {		
			e.printStackTrace();
		}
		copy.number = new StringBuffer(this.number);
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
		return 0;
	}

	@Override
	public String getNumber() {
		return number.toString();
	}
}
