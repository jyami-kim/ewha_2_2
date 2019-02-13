package Lab6;
import java.util.*;
public class Lab6_4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
		ArrayList<String> arr;
		int num;
		
		System.out.println("How many names? ");
		num = in.nextInt();
		System.out.println("Please enter name & phone #:");
		
		for(int i=0; i<num; i++) {
			String name = in.next();
			String phone = in.next();
			if(map.containsKey(name)) {
				arr = map.get(name);
			}else {
				arr = new ArrayList<String>();
			}
			arr.add(phone);
			map.put(name,arr);
		}
		
		System.out.println("===Results===");
		for(String name : map.keySet()) {
			System.out.print(name+": ");
			for(String phone : map.get(name)) {
				System.out.print(phone+" ");
			}
			System.out.println();
		}
	}

}
