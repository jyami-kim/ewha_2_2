package Lab9;

public class MyThread extends Thread{
	private String name;
	public MyThread(String name) {
		this.name = name;
	}
	public void run() {
		for(;;) {
			System.out.println(name+":hello world");
		}
	}
}
