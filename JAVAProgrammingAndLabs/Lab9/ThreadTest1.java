package Lab9;

public class ThreadTest1 {
	public static void main(String[] args) { 
		MyThreadA t1 = new MyThreadA();
		MyThreadB t2 = new MyThreadB();
		t1.start();
		t2.start();
	}

}
