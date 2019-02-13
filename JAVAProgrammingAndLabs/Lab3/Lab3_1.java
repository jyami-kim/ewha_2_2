package Lab3;
import java.util.Scanner;
public class Lab3_1 {

	public static void main(String[] args) {
		int type, a, b, sum =0, start;
		Scanner in = new Scanner(System.in);
		System.out.print("Please choose a type (1:odd, 2:even): ");
		type = in.nextInt();
		System.out.print("Choose two integer numbers: ");
		a = in.nextInt();
		b = in.nextInt();
		if(a>b) {
			int tmp;
			tmp =a;
			a=b;
			b=tmp;
		}
		if((type ==1 && a%2==0)||(type ==2 && a%2==1))
			start = a+1;
		else
			start = a;
		for(int i=start;i<=b;i+=2) {
			sum += i;
		}
		System.out.println("The sum of "+(type ==1 ? "odd ": "even ") + "from " + a + " to "+ b +" = "+sum);
	}

}
