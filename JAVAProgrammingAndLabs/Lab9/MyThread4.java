package Lab9;

public class MyThread4 extends Thread{
	private String name;
	
	public MyThread4(String name) {
		this.name = name;
	}
	public void run() {
		try {
			for(int j=0; j<10; j++) {
				sleep(500);
				System.out.println("Thread "+name+" : "+j);
			}
		}catch(InterruptedException ex) {
			System.out.println(ex);
		}
		
	}
}
