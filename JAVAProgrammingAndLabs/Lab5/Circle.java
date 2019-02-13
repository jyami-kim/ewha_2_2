package Lab5;
import java.text.DecimalFormat;
public class Circle extends GeometricObject{
	private double radius;
	
	DecimalFormat form = new DecimalFormat("#.00");
	
	public Circle() {}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
		//this.setColor(color);
		//this.setFilled(filled);
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius*radius*Math.PI;
	}
	
	public double getPerimeter() {
		return radius*2*Math.PI;
	}
	
	public double getDiameter() {
		return radius*2;
	}
	public String toString() {
		return "===Circle object===\n"+super.toString()+
				"\n3) Radius = "+ radius+
				"\n4) Perimeter = "+ form.format(getPerimeter())+
				"\n5) Area = "+form.format(getArea());
		
	}
}
