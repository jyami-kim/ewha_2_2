package Lab10;

public class Bakery {
	private int contents;
	private boolean available = false;
	
	public synchronized int get(int who) { 
		while(available == false) {
			try {
				wait();
			}catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}
		
		System.out.println("Consumer "+ who + " got: " + contents);
		available = false;
		notifyAll();
		return contents;
	}
	
	public synchronized void put(int who, int value) {
		while(available == true) {
			try {
				wait();
			}catch(InterruptedException ex) {
				System.out.println(ex);
			}
		}
		contents = value;
		available = true;
		System.out.println("Producer "+ who + " put: "+ contents);
		notifyAll();
	}
}