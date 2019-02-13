package Lab4;

public class HyperRect {
		double length;
		double depth;
		double height;
		
		public HyperRect() {
			length = depth = height =1;
		}
		
		public double calSurfaceArea() {;
			return (length+depth)*2*height;
		}
		
		public double calVolume() {
			return length*depth*height;
		}
		
		public double calSpaceDiagonal() {
			return Math.sqrt(length*length + depth*depth + height*height);
		}
}
