package Lab6;
import java.util.Scanner;
import java.util.HashMap;
public class Lab6_3 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		System.out.println("How may name?");
		num = in.nextInt();
		System.out.println("Please enter "+num+" names: ");
		
		for(int i=0; i<num; i++) {
			String name = in.next();
			int count =1;
			if(map.containsKey(name)) {
				count += map.get(name);
			}
			map.put(name, count);
		}
		
		System.out.println("===Results===");
		for(String name: map.keySet()) {
			System.out.println(name + ": "+map.get(name));
		}
		
	}
}
