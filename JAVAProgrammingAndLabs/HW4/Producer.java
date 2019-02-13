package HW4;


public class Producer extends Thread {
	private Bakery bakery; //to use synchronize, using one bakery object
	private int number; //producer id
	private int bread; //in processing, producer objects generate/store breads
	public static boolean running= true;//if running false, thread out
	
	public Producer(Bakery bakery, int number) { //constructor. to initialize
		this.bakery = bakery; //to adjust thread, using one bakery object. (in this homework, the bakery parameter is same)
		this.number = number; //set producer id
		this.bread = 0; // in init, the number of generating breads set zero.
	}
	
	public void run() {//In the main function. if producer objects start, execute this method and add thread.
		while(running) { //use infinite loop, but break the loop and process exit, when the satisfy the condition (reach the number of goal consuming breads)
			bread = (int)(Math.random()*10+1); //at a time, the number of generating breads are random, which bound is 1 to 10.
			bakery.put(number, bread); // by using bakery class, I can adjust only one thread at a time (synchronize)
			try {
				sleep((int)(Math.random()*100)); // if I don't set sleep randomly. the order of processing is same (like : p1 -> p2 -> c1 -> c2)
			}
			catch (InterruptedException ex) { // set exception
				System.out.println(ex); // to know content of exception, use print method.
			}
		}
	}	
}
