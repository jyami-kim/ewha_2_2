package Lab10;

public class SimpleThread extends Thread{
	public String name = null;
	
	public SimpleThread(String name) {
		this.name = name;
	}
	public void run() {
		for(int i=0; i<10 ;i++) {
			System.out.println(i+" "+name+ "Priority = "+getPriority());
		}
		System.out.println("Done : "+name);
	}
}
