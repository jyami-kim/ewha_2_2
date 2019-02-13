package Lab10;

public class ThreadPriority {

	public static void main(String[] args) {
		Thread t1 = new SimpleThread("Boston");
		t1.setPriority(1);
		Thread t2 = new SimpleThread("New York");
		t2.setPriority(5);
		Thread t3 = new SimpleThread("Seoul");
		t3.setPriority(10);
		System.out.println("(1,1,3)");
		t1.start();
		t2.start();
		t3.start();

	}

}
