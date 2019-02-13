package Lab6;
import java.util.Scanner;
public class Lab6_1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num;
		int [] array;
		
		System.out.println("How many numbers?");
		num = in.nextInt();
		array = new int[num];
		System.out.println("Please enter "+num+" integer");
		for(int i=0; i<num; i++) {
			array[i] = in.nextInt();
		}
		
		System.out.print("=> Array : ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}

}
