package HW;
import java.util.Scanner;
public class HW1_2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int max, red, or;
		System.out.println("Choose maximum integer n:");
		max = in.nextInt();
		System.out.println("Redundancy is allowed (y:1 n:2)");
		red = in.nextInt();
		System.out.println("Order is considered (y:1 n:2)");
		or = in.nextInt();
		
		int cal;
		cal = red*2 + or;
		
		switch(cal) {
		case 3: // re o or o
			for(int i=1; i<=max;i++) {
				for(int j=1; j<=max;j++) {
					System.out.println(i+" "+j);
				}
			}
			break;
		case 4: //red o or x
			for(int i=1; i<=max; i++) {
				for(int j=i; j<=max;j++) {
					System.out.println(i+" "+j);
				}
			}
			break;
		case 5: //red x or o
			for(int i=1; i<=max; i++) {
				for(int j= 1; j<=max;j++) {
					if( j==i)
						continue;
					System.out.println(i+" "+j);
				}
			}
			break;
		case 6: //red x or x
			for(int i=1; i<=max; i++) {
				for(int j=i+1; j<=max; j++) {
					System.out.println(i+" "+j);
				}
			}
			break;
		}
		
		
	}

}
