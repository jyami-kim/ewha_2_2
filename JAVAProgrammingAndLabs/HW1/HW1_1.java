package HW;
import java.util.Scanner;
public class HW1_1 {
	public static double sigmaX;
	public static double sigmaXX;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		sigmaX =0; sigmaXX=0;
		int num;
		double input;
		double min=0, max =0;
		
		System.out.print("How many numbers: ");
		num = in.nextInt();
		
		System.out.println("Enter "+num+" numbers");
		for(int i=0; i<num; i++) {
			input = in.nextDouble();
			sigmaX += input;
			sigmaXX += (input*input);
			if(i==0) {
				min = input;
				max = input;
			}else {
				if(i < min)
					min = i;
				if(i > max)
					max = i;
			}
		}
		
		double mean;
		mean = sigmaX / 10;
		double sd;
		sd = Math.sqrt((sigmaXX/num)-mean*mean);
		System.out.println("====Results====");
		System.out.println("Min : "+ min);
		System.out.println("Max : "+ max);
		System.out.println("Mean: "+ mean);
		System.out.println("Standard Deviation : "+sd);
	}
}
