package Lab5;
import java.text.DecimalFormat;
public class Lab5_3 {

	public static void main(String[] args) {
		DecimalFormat form = new DecimalFormat("#.00");
		GeometricObject obj1 = new Rectangle(1.2, 3.6, "blue", true);
		GeometricObject obj2 = new Circle(3.5, "red", false);
		System.out.println(form.format(obj1.getArea()) + " " + form.format(obj1.getPerimeter()));
		System.out.println(form.format(obj2.getArea()) + " " + form.format(obj2.getPerimeter()));
		System.out.println(obj1);
		System.out.println(obj2);
	}

}
