package Lab2;
import java.text.DecimalFormat;

public class Lab2_1 {

	public static void main(String[] args) {
		double radius;
		String area;
		double area1;
		DecimalFormat form = new DecimalFormat("#.00");
		radius = 20;
		
		area = form.format(radius * radius * Math.PI); 
		area1 = radius * radius * Math.PI;
		System.out.println("The area for the circle of radius " + radius + " is " + area);
		System.out.printf("The area for the circle of radius %f is %.2f", radius, area1);
		
	}

}
