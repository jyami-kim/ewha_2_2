package Lab3;
import java.util.Scanner;
public class Lab3_2 {

	public static int cal_sum_val(int type, int start, int end) {
		int retval = 0;
		if((type==1 && start%2==0)||(type==2&& start%2==1))
			start++;
		for(int i=start;i<=end;i+=2)
			retval += i;
		
		return retval;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int type, num1, num2;
		System.out.print("Please choose a type (1:odd, 2:even) : ");
		type = in.nextInt();
		System.out.print("Choose two integer numbers: ");
		num1 = in.nextInt();
		num2 = in.nextInt();
		if(num1 > num2) {
			int tmp;
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		System.out.printf("=> Sum of even numbers from %d to %d = %d",num1, num2, cal_sum_val(type, num1, num2));
	}

}
