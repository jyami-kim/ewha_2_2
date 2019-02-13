package Lab2;
import java.util.Scanner;
public class Lab2_3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int math, eng, programming;
		double avg;
		System.out.print("Please enter the Math score : ");
		math = in.nextInt();
		System.out.print("Please enter the English score : ");
		eng = in.nextInt();
		System.out.print("Please enter the Programming score : ");
		programming = in.nextInt();
		
		avg = (math + eng + programming)/3.0; 
		System.out.printf("=> Average score = %.4f", avg);
	}

}
