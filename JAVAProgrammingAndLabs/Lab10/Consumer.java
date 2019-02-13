package Lab10;

public class Consumer extends Thread {
	private Bakery bakery;
	private int number;
	
	public Consumer(Bakery bakery, int number) {
		this.bakery = bakery;
		this.number = number;
	}
	
	public void run() {
		int value = 0;
		for (int i=0; i < 10; i++) {
			value = bakery.get(number);
		}
	}
}