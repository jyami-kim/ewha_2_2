package Lab4;
import java.util.Scanner;
public class Lab4_3 {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int create, sel;
		System.out.print("Do you want to create an object of the hyperrectangle(y: 1 or n:2 )?");
		create = in.nextInt();
		if(create == 2) {
			System.exit(0);
		}
		HyperRect obj = new HyperRect();
		System.out.println(" => One object is created!");
		
		do {
			System.out.println("====Menu====");
			System.out.println("1) Get the length (in meter)");
			System.out.println("2) Get the depth (in meter)");
			System.out.println("3) Get the height (in meter)");
			System.out.println("4) Set the length (in meter)");
			System.out.println("5) Set the depth (in meter)");
			System.out.println("6) Set the height (in meter)");
			System.out.println("7) Calculate the volume (in m^3)");
			System.out.println("8) Calculate the surface area (in m^2)");
			System.out.println("9) Calculate the space diagonal (in m)");
			System.out.println("10) Exit)");
			
			System.out.print("? ");
			sel = in.nextInt();
			
			switch(sel) {
			case 1:
				System.out.println("=> The length is "+ obj.length +" m.");
				break;
			case 2:
				System.out.println("=> The depth is "+ obj.depth +" m.");
				break;
			case 3:
				System.out.println("=> The height is "+ obj.height +" m.");
				break;
			case 4:
				System.out.print("Set length :");
				obj.length = in.nextDouble();
				break;
			case 5:
				System.out.print("Set depth :");
				obj.depth = in.nextDouble();
				break;
			case 6:
				System.out.print("Set height :");
				obj.height = in.nextDouble();
				break;
			case 7:
				System.out.println("=> The volume is "+ obj.calVolume() +" m.");
				break;
			case 8:
				System.out.println("=> The volume is "+ obj.calSurfaceArea() +" m.");
				break;
			case 9:
				System.out.println("=> The volume is "+ obj.calSpaceDiagonal() +" m.");
				break;
			case 10:
				System.exit(0);
				break;
			}
			
		}while(sel!=10);
		
	}

}
