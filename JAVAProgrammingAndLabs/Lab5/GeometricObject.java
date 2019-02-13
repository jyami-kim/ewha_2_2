package Lab5;

public class GeometricObject {
	private String color;
	private boolean filled;
	
	public GeometricObject() {
	}
	
	public GeometricObject(String color, boolean filled) {
		this.color = color;
		this.filled = filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public String toString() {
		return "1) color = "+ color + 
				"\n2) filled = " + filled;
	}
	public double getPerimeter() {
		return 0;
	}
	public double getArea() {
		return 0;
	}
}
