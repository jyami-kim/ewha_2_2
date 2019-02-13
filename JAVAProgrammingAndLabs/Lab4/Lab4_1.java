package Lab4;

public class Lab4_1 {

	public static void main(String[] args) {
		Baby baby1 = new Baby("David");
		Baby baby2 = new Baby("David");
		
		int x1 = 10;
		int x2 = 10;
		
		String str1 = new String("Claudio");
		String str2 = new String("Claudio");
		
		String str3 = "Claudio";
		String str4 = "Claudio";
		
		System.out.println("[1] baby1 == baby2: " +(baby1 == baby2)); // false
		System.out.println("[2] x1 == x2: " + (x1 == x2)); //true
		System.out.println("[3] str1 == str2: " + (str1 == str2)); //false
		System.out.println("[4] str3 == str4: " + (str3 == str4)); //true
		System.out.println("[5] str1 == str3: " + (str1 == str3)); //false
	}

}
