package HW3_1;

public class Bakery { //actually, the bakery class controls threads
	public static int contents; // on bakery have one total breads num. so, I using class value, which have one data in one class
	private boolean available = false; 
	//when available true, the time that consumer's can consume.
	//when available false, the time that consumer's can't consume.
	
	public synchronized int get(int who, Consumer con) {  //consumer
		while(available == false) { //when available false, it is the time that consumer's can't consume breads
			try {
				wait(); //because it is the time consumer's can't consume breads , the consumer object's thread must be wait. 
				        //to doing this i use the get method's, since wait method must execute in synchronize 
			}catch(InterruptedException ex) {//exception
				System.out.println(ex);//print exception content
			}
		}
		//available is true = the time that consumer's can consume
		contents -= 5; //consumer consuming 5 breads at a time. to update the total number of breads, assign the contents variable.
		System.out.println("Consumer "+ who + " got: " + 5 + " (Total # of Breads = " + contents + ")"); //print the console to satisfy the output format
		if(contents>=5) { //if the contents is greater or equal than 5, consumer could consuming the bread.
			available = true; //when available true, it is the time that consumer can consume breads
		}else { //if the contents is not greater than 5, consumer couldn't consuming the bread. 
			available = false; //when available false, it is the time that consumer can consume breads.
		}
		if(con.getBread() + 5 == 20) { //since the getBread's return value is the number of consuming breads, before this get method executing. so set this condition.
			System.out.println("\n:Done"); //print the console to satisfy the output format.
			System.out.println("=> Consumer " + who + " won the game! (first ate 20 breads)"); //print the console to satisfy the output format. 
			System.exit(0); //the process end condition is satisfied, the program exit.
		}else { //the case that consumer dosen't satisfy the number of the consuming breads
			notifyAll(); //because this tread is ended, this request lock and one of the other thread start
		}
		return 5; //to update the con object's breads number. return 5 (consuming breads at a time)
	}
	
	public synchronized void put(int who, int value) { //producer
		contents += value; //producer generate value(random) at a time. to update the total number of breads, assign the contents variable
		if(contents>=5) { //if the contents is greater or equal than 5, consumer could consuming the bread.
			available = true; //when available true, it is the time that consumer can consume breads
		}else { //if the contents is not greater than 5, consumer couldn't consuming the bread. 
			available = false; //when available false, it is the time that consumer can consume breads.
		}
		System.out.println("Producer "+ who + " put: "+ value + " (Total # of Breads = " + contents + ")");//print the console to satisfy the output format
		notifyAll(); //because this thread is ended, this request lock and one of the other thread start
	}
}
