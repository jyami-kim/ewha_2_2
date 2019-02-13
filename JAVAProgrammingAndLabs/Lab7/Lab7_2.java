package Lab7;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
public class Lab7_2 {

	public static void main(String[] args) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		do {
			Scanner in = new Scanner(System.in);
			System.out.print("Please enter a file name: ");
			File infile = new File(in.next());
			
			Scanner input=null;
			try {
				input = new Scanner(infile);
			}catch(FileNotFoundException ex) {
				System.out.println(ex);
				continue;
			}
			
			while(input.hasNext()) { //파일 읽기
				String name = input.next();
				String phone = input.next();
				ArrayList<String> arr;
				if(map.containsKey(name)) {
					arr = map.get(name);
				}else {
					arr= new ArrayList<String>();
				}
				arr.add(phone);
				map.put(name, arr);
			}
			input.close();
			break;
		}while(true);
		System.out.println("Done...");
		
		File outfile = new File("lab7_2_output.txt");

		PrintWriter output = null;
		try {
			output = new PrintWriter(outfile);
		}catch(FileNotFoundException ex) {
			System.out.println(ex);
			System.exit(0);
		}
		output.println("===Result===");
		for(String name: map.keySet()) {
			output.print(name+" : ");
			for(String phone: map.get(name)) {
				output.print(phone + " ");
			}
			output.println();
		}
		output.close();
	}

}
