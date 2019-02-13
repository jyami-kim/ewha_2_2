package Lab4;

public class Lab4_2 {

	public static double x;
	public static void printx() {
		System.out.println("x = "+ x);
	}
	
	public double y;
	public void printy() {
		System.out.println("y = "+ y);
	}
	
	public static void main(String[] args) {
		x = 5.34;
		printx();
		
		Lab4_2 a = new Lab4_2();
		a.y = 9.67;
		a.printy();
	}

}
