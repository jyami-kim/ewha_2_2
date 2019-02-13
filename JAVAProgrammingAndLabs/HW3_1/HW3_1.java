package HW3_1;

public class HW3_1 {
	
	public static void main(String[] args) {
		
		//creates a Bakery object
		Bakery bObj = new Bakery(); 
		
		//create Producer objects
		Producer pObj1 = new Producer(bObj, 1); 
		Producer pObj2 = new Producer(bObj, 2);
		//create Consumer objects
		Consumer cObj1 = new Consumer(bObj, 1);
		Consumer cObj2 = new Consumer(bObj, 2);
		
		//start treads!
		pObj1.start();
		pObj2.start();
		cObj1.start();
		cObj2.start();
	}
}

