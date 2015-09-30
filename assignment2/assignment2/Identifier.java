package assignment2;

public class Identifier implements IIdentifier {
	
	private String string;
	
	public Identifier(String string){
		this.string = string;
	}
	
	public Identifier(Identifier identifier){
		string = identifier.getString();
	}
	
	public void init(String string) {
		this.string = string;		
	}

	@Override
	public String getString() {
		return string;
	}

	@Override
	public boolean equals(Identifier identifier) {
		if (getString().equals(identifier.getString())){
			return true;
		}
		return false;
	}

	@Override
	public IIdentifier clone() {				// Is IIdentifier correct
		
		return null;
	}

	@Override
	public int compareTo(IIdentifier o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}