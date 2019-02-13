package Lab10;

public class ThreadUnsync {

	public static void main(String[] args) {
		Thread t1 = new PrintStringsThread("Hello ","there.");
		t1.setPriority(10);
		Thread t2 = new PrintStringsThread("How are ","you?");
		t2.setPriority(5);
		Thread t3 = new PrintStringsThread("Thank you ","very much!");
		t3.setPriority(1);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
