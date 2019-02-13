package Lab9;

public class ThreadTest4 {

	public static void main(String[] args) {
		MyThread2 t1 = new MyThread2("thread1");
		MyThread2 t2 = new MyThread2("thread2");
		t1.start();
		t2.start();
	}

}
