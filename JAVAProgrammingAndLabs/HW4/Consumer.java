package HW4;

public class Consumer extends Thread {
	private Bakery bakery; // to use synchronize, using one bakery object
	private int number; // consumer id
	private int bread; // in processing, the number of total consuming breads, which is consumed by this consumer object
	public static boolean running = true;//if running false, thread out
	
	public Consumer(Bakery bakery, int number) { //constructor. to initialize
		this.bakery = bakery; //to adjust thread, using one bakery object. (int this homework, the bakery parameter is same)
		this.number = number; // set consumer id
		this.bread = 0; // in init, the number of sum consuming breads must set zero. (because counting)
	}
	
	public int getBread() { //to access the bread element at the bakery class
		return bread; //get bread element
	}

	public void run() { //In the main function, if consumer objects start, execute this method and add thread.
		while(running) {//use infinite loop, but break the loop and process exit, when the satisfy the condition (reach the number of goal consuming breads)
			bread += bakery.get(number, this);//at a time, the number of sum consuming breads increase 5, which is the return value of bakery.get() method.
			try {
				sleep((int)(Math.random()*100)); // if I don't set sleep randomly. the order of processing is same (like : p1 -> p2 -> c1 -> c2)
			}
			catch (InterruptedException ex) { // set exception
				System.out.println(ex); // to know content of exception, use print method.
			}
		}
			
	}
}
