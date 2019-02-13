package Lab9;

public class MyThread3 extends Thread{
	private String name;
	public MyThread3(String name) {
		this.name = name;
	}
	public void run() {
		try {
			for(int j=0; j<10; j++) {
				sleep(2000);
				System.out.println("Easy Java: "+j);
			}
		}catch(InterruptedException ex) {
			System.out.println(ex);
		}
	}
}
