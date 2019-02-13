package Lab7;

import java.text.DecimalFormat;

public class Rectangle extends GeometricObject{
	
	private double width;
	private double height;
	DecimalFormat form = new DecimalFormat("#.00");
	
	Rectangle(){
	}
	
	Rectangle(double width, double height){
		this.width = width;
		this.height = height;
	}
	Rectangle(double width, double height, String color, boolean filled){
		super(color,filled);
		this.width = width;
		this.height= height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getArea() {
		return width*height;
	}
	public double getPerimeter() {
		return 2*(width+height);
	}
	public String toString() {
		return "===Rectangle object===\n"+super.toString()+
				"\n3) Width = "+ width+
				"\n4) Height = "+ height+
				"\n5) Perimeter = "+ form.format(getPerimeter())+
				"\n6) Area = "+form.format(getArea());	
	}
	
}
