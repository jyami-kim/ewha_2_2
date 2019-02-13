package Lab9;

public class ThreadTest6 {
	public static void main(String args[]) {
		MyThread4 t1 = new MyThread4("1");
		MyThread4 t2 = new MyThread4("2");
		MyThread3 t3 = new MyThread3("thread");
		t1.start(); t2.start(); t3.start();
	}
}
