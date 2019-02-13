package Lab6;
import java.util.Scanner;
import java.util.ArrayList;
public class Lab6_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		System.out.println("How many numbers? ");
		num = in.nextInt();
		System.out.println("Please enter "+num +" integers: ");
		for(int i =0; i<num; i++) {
			arr.add(in.nextInt());
		}
		System.out.print("=> ArrayList : ");
		for(int data : arr) {
			System.out.print(data+" ");
		}
		
	}

}
