package assignment2;

public class Identifier implements IIdentifier {
	
	private StringBuffer s;
	
	public Identifier(StringBuffer s){
		this.s = s;
	}
	
	public Identifier(Identifier identifier){
		s = new StringBuffer(identifier.getString()); //String to Stringbuffer 
	}
	
	public void init(String string) {
		StringBuffer temp = new StringBuffer();
		temp.append(string);
		s = temp;	
	}

	@Override
	public String getString() {
		return s.toString();
	}

	@Override
	public IIdentifier clone() {
		IIdentifier result = new Identifier(s); 
		return result;
	}

	@Override
	public int compareTo(IIdentifier o) {
		int length;
		if (o.getString().length() > s.length()) length = s.length();
		else length= o.getString().length();
		
		for(int i = 0; i < length; i++){
			int difference = s.charAt(i) - o.getString().charAt(i);	
			if (difference != 0) return difference;
		}
		return 0;
	}

	@Override
	public void appendChar(char c) {
		s.append(c);
		
	}
}