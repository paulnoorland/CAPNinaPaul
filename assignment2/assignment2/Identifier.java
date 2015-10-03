package assignment2;

public class Identifier implements IIdentifier {
	
	private StringBuffer s;
	
	public Identifier(String string){
		StringBuffer temp = new StringBuffer();
		temp.append(string);
		s = temp;
	}
	
	public Identifier(Identifier identifier){
		s = identifier.getStringBuffer();
	}
	
	public void init(String string) {
		StringBuffer temp = new StringBuffer();
		temp.append(string);
		s = temp;	
	}

	@Override
	public StringBuffer getStringBuffer() {
		return s;
	}

	@Override
	public IIdentifier clone() {
		IIdentifier result = new Identifier(s.substring(0)); 
		return result;
	}

	@Override
	public int compareTo(IIdentifier o) {
		if (s.equals(o.getStringBuffer())) return 0;
		return 1;	//moet er ook een <0 gereturned worden hier? Hoe is een string groter/kleiner dan een andere string?
	}

	@Override
	public void appendChar(char c) {
		s.append(c);
		
	}

}