package adt;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {

	Scanner in = new Scanner(System.in);
	PrintStream out = new PrintStream(System.out);

	boolean isAlphanumeric(String string) {
		for (int i = 0; i < string.length(); i++) {
			char temp = string.charAt(i);
			if (!(Character.isDigit(temp) || Character.isLetter(temp)))
				return false;
		}
		return true;
	}

	private boolean checkIdentifierFormat(String string) {
		if (!Character.isLetter(string.charAt(0)) || !isAlphanumeric(string)
				|| !(string.length() > 0))
			return false;
		return true;
	}

	private Identifier createIdentifier(String string) {
		return new Identifier(string);
	}

	private Set createSet(Scanner setScanner) throws Exception {
		setScanner.useDelimiter(" ");
		Set result = new Set();

		while (setScanner.hasNext()) {
			if(result.getLength() >= 10) {
				throw new Exception("Set length is too long. Max 10 identifiers per set.\n");
			}
			String temp = setScanner.next();

			if (checkIdentifierFormat(temp)) {
				Identifier identifier = createIdentifier(temp);
				if (!result.hasIdentifier(identifier))
					result.addIdentifier(identifier);
			} else {
				throw new Exception("Identifier format wrong\n");
			}
		}
		return result;
	}

	void printSet(Set set) {
		while (set.getLength() > 0) {
			Identifier identifier = set.getIdentifier();
			set.removeIdentifier(identifier);
			out.print(identifier.getString() + " ");
		}
		out.print("\n");
	}

	void performOperations(Set set1, Set set2) throws Exception {
		out.print("Difference: ");
		printSet(set1.difference(set2));
		out.print("Intersection: ");
		printSet(set1.intersection(set2));
		out.print("Union:             ");
		printSet(set1.union(set2));
		out.print("Symmetric difference: ");
		printSet(set1.symmetricDifference(set2));
		out.print("\n");
	}

	String formatString(String string) throws Exception {
		if (string.length() == 0)
			throw new Exception("String is empty. \n");
		if (string.charAt(0) != '{')
			throw new Exception("Missing '{'. \n");
		if ((string.charAt(string.length() - 1)) != '}')
			throw new Exception("Missing '}'. \n");
		return string.substring(1, string.length() - 1);
	}

	private Set readSet(String string) {
		Set result;
		while (true) {
			out.println("Give the " + string + " collection: ");
			if (!in.hasNextLine())
				System.exit(0);
			String setString = in.nextLine();

			try {
				Scanner setScanner = new Scanner(formatString(setString));
				result = createSet(setScanner);
				return result;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	void start() {
		while (true) {
			Set set1 = readSet("first");
			Set set2 = readSet("second");

			try {
				performOperations(set1, set2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] argv) {
		new Main().start();
	}
}
