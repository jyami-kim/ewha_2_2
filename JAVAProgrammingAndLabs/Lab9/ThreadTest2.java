package Lab9;

public class ThreadTest2 {

	public static void main(String[] args) {
		MyRunnableA r1 = new MyRunnableA();
		MyRunnableB r2 = new MyRunnableB();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}
