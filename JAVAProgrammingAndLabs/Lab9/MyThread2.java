package Lab9;

public class MyThread2 extends Thread{
	private String name;
	public MyThread2(String name) {
		this.name = name;
	}
	public void run() {
		for(;;) {
			System.out.println(name+":hello world");
			yield();
		}
	}
}
