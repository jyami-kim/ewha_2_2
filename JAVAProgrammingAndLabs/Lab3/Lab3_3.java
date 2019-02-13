package Lab3;
import java.util.Scanner;
public class Lab3_3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num, fact=1;
		double div, e=1;
		System.out.print("Please choose i:");
		num = in.nextInt();
		
		for(int i=1; i<=num;i++) {
			fact *= i;
			div = 1.0 / fact;
			e += div;
		}
		
		System.out.println("=> The approximate e value is "+ e + " (for i = "+num+")");
		System.out.printf("=> The approximate e value is %.4f (for i = %d)", e, num);
	}
}
