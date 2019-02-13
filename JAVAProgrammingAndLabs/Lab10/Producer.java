package Lab10;

public class Producer extends Thread{
	private Bakery bakery;
	private int number;
	
	public Producer(Bakery bakery, int number) {
		this.bakery = bakery;
		this.number = number;
	}
	
	public void run() {
		for (int i=0; i < 10; i++) {
			bakery.put(number, i);
		try {
			sleep((int)(Math.random()*100));
		}
		catch (InterruptedException ex) {
			System.out.println(ex);
			}
		}
	}
}
