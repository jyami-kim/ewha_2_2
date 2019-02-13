package Lab2;

public class Lab2_2 {

	public static void main(String[] args) {
		double x1 = 5/2;
		double x2 = 5.0 / 2;
		double x3 = 5 / 2.0;
		double x4 = 5.0 / 2.0;
		int x5 = (int) 5.0 / 2;
		int x6 = 5 % 2;
		System.out.println(x1); // 2.0
		System.out.println(x2); // 2.5
		System.out.println(x3); // 2.5
		System.out.println(x4); // 2.5
		System.out.println(x5); // 2
		System.out.println(x6); // 1
		
		int y = x6++;
		int z = ++x6;
		System.out.println(y); //1
		System.out.println(z); //3
		
		int x7 = 0X64;
		int x8 = 0X3a;
		System.out.format("%#x And %#x = %#x\n", x7, x8, x7&x8);
		System.out.format("%#x OR %#x = %#x\n", x7, x8, x7|x8);
	}

}
