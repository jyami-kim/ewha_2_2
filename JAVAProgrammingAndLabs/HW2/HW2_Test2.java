package HW2;
import java.util.Scanner;
import java.util.ArrayList;

public class HW2_Test2 {
	
	public static ArrayList<MySet> a = new ArrayList<MySet>(); //array of sets
	
	public static void stateprint() { // each iteration, print all sets
		System.out.println("\n[Current Status]");
		System.out.print("=> "); // for satisfy the print format, print =>
		if(a.size() ==0 )
			System.out.println("None");
		else {
			for(int i=0; i<a.size();i++) { // access each element's of array
				System.out.print(a.get(i).set_name+" = "); // print set name of element
				a.get(i).Print(); // print set elements
				if(i!=a.size()-1) { // at next the last elements dosen't require ,
					System.out.print(", "); // to separate elements print ,
				}	
			}
		}
		System.out.println(); //satisfy output format
	}
	
	static Scanner in = new Scanner(System.in); //scanner. to use in static method, set static type
	
	public static MySet finding(String name) { //finding the set by set name
		for(int i=0; i<a.size();i++) { //to fine the set name, access each element's of array
			if(a.get(i).set_name.equals(name)) { //if accessed set name is equal to name the condition is satisfied
				return a.get(i); //return the MySet value, name is correct
			}
		}
		System.out.println("Wrong Input! program exit!"); //if the correct value is not exist, exit program.
		System.exit(0); // program exit.
		return null; //default return value
	}
	
	public static void CreateEmptySet() { //case1 : new empty set
		MySet new_set = new MySet(); //make new MySet type value by using default constructor
		a.add(new_set); //insert new_set in array, consisted of sets
		System.out.println("=> Set "+new_set.set_name+" is created"); //for satisfying the output, print the state
	}
	
	public static void CreateExistingSet() { // case2 : new empty set that is equal to existing set
		System.out.print("-From which set?: "); //question about what is copy set
		String str = in.next(); // input user's answer
		MySet a1 = finding(str); //by using finding method, find and assign the MySet that the name is equal to str
		MySet new_set = new MySet(a1); //make new MySet type value by using constructor that argument exist.
		a.add(new_set); // insert new_set in array, consisted of sets
		System.out.println("=> Set "+new_set.set_name+" is created"); //for satisfying the output, print the state
	}

	public static void InsertNum() {// case3 : insert number
		System.out.print("-Type a number: "); // question about what is number to type
		int num = in.nextInt(); // input user's answer
		System.out.print("-Which set? "); // question about what is set to insert element
		String str = in.next(); // input user's answer
		MySet new_set = finding(str); // assign the finding value in new_set. the finding method return the MySet that the name is equal to str
		new_set.Insert(num); //insert number in new_set set. by using insert method we can access to plus the set_length
		System.out.println("=> Set "+str+" is updated"); //for satisfying the output, print the state	
	}

	public static void DeleteNum() {// case4 : delete number
		System.out.print("-Type a number: "); // question about what is number to type
		int num4 = in.nextInt();// input user's answer
		System.out.print("-Which set? "); // question about what is set to delete element
		String str = in.next(); // input user's answer
		MySet new_set = finding(str);// assign the finding value in new_set. the finding method return the MySet that the name is equal to str
		new_set.Delete(num4); //Delete number in new_set set. by using delete method we can access to minus the set_length
		System.out.println("=> Set "+str+" is updated"); //for satisfying the output, print the state
		
	}

	public static void UnionSets() { // case 5 : union of two sets
		System.out.print("-Specify two sets: "); // question about what are sets to union
		String str_1 = in.next(); // input user's answer
		String str_2 = in.next(); // input user's answer
		MySet new_set_1 = finding(str_1); // assign the finding value in new_set_1. the finding method return the MySet that the name is equal to str_1
		MySet new_set_2 = finding(str_2); // assign the finding value in new_set_1. the finding method return the MySet that the name is equal to str_2
		System.out.print("=> "+str_1+" ¡ú "+str_2+" = "); //for satisfying the output, print the state
		(new_set_1.Union(new_set_2)).Print(); //Since the return value of union is MySet type, so it can use print method by combining with MySet type.
		System.out.println(); // satisfy output format
		
	}

	public static void IntersectionSets() {// case 6 : intersection of two sets
		System.out.print("-Specify two sets: "); // question about what are sets to union
		String str_1 = in.next();  // input user's answer
		String str_2 = in.next();  // input user's answer
		MySet new_set_1 = finding(str_1); // assign the finding value in new_set_1. the finding method return the MySet that the name is equal to str_1
		MySet new_set_2 = finding(str_2); // assign the finding value in new_set_2. the finding method return the MySet that the name is equal to str_2
		System.out.print("=> "+str_1+" ¡û "+str_2+" = "); //for satisfying the output, print the state
		(new_set_1.Intersection(new_set_2)).Print(); //Since the return value of intersection is MySet type, so it can use print method by combining with MySet type. 
		System.out.println(); // satisfy output format
		
	}
	
	public static void DifferenceSets() {// case7 : difference of two sets
		System.out.print("-Specify two sets: ");// question about what are sets to union
		String str_1 = in.next(); // input user's answer
		String str_2 = in.next(); // input user's answer
		MySet new_set_1 = finding(str_1); // assign the finding value in new_set_1. the finding method return the MySet that the name is equal to str_1
		MySet new_set_2 = finding(str_2);// assign the finding value in new_set_2. the finding method return the MySet that the name is equal to str_2
		System.out.print("=> "+str_1+" - "+str_2+" = "); //for satisfying the output, print the state
		(new_set_1.Diff(new_set_2)).Print();//Since the return value of difference is MySet type, so it can use print method by combining with MySet type.
		System.out.println(); // satisfy output format
	}
	
	public static void SizeOfSet() {//case 8: size of set
		System.out.print("-Which set? "); //question about what is set to find size
		String str = in.next(); // input user's answer
		MySet new_set = finding(str); // assign the finding value in new_set. the finding method return the MySet that the name is equal to str
		System.out.println("=> Size of Set "+str+" is "+new_set.Size()); //for satisfying the output, print the state //use size() method find the number of set elements
	}
	
	public static void PrintSet() {//case 9: print set's all element
		System.out.print("-Which set? "); //question about what is set to find size
		String str = in.next(); // input user's answer
		MySet new_set = finding(str); // assign the finding value in new_set. the finding method return the MySet that the name is equal to str
		System.out.print("=> "+str+" = "); //for satisfying the output, print the state
		new_set.Print(); //use print method by combining with MySet type.
		System.out.println(); //satisfy output format
	}
	
	
	public static void main(String[] args) {
		System.out.println("[HW #2]"); //it is Homework 2
		System.out.println("Student Id 1771008: Minjeong Kim"); //information for me
		
 
		int input; // the variable to save the case number
		
		stateprint(); // in the starting point, print set state.
		
		do { //if input number is not 10, print the case of input (menu)
			System.out.println("==== Menu ===="); //set operation case menu print
			System.out.println("1) Create a new empty set"); //it is explanation of case 1
			System.out.println("2) Create a new set from an existing set"); //it is explanation of case 2
			System.out.println("3) Insert number to a set"); //it is explanation of case 3
			System.out.println("4) Delete number from a set"); //it is explanation of case 4
			System.out.println("5) Query the union of two sets"); //it is explanation of case 5
			System.out.println("6) Query the intersection of two sets"); //it is explanation of case 6
			System.out.println("7) Query the difference of two sets"); //it is explanation of case 7
			System.out.println("8) Query the size of a set"); //it is explanation of case 8
			System.out.println("9) Print all the elements in a set"); //it is explanation of case 9
			System.out.println("10) Exit"); //it is explanation of case 10
			System.out.println("--------------------------------------------------"); //divide menu print and user's input
			System.out.print("? "); // in the next, user select the menu
			input = in.nextInt(); //save the selected menu number in input variable
			switch(input) { // classify the case
			case 1://case1 : new empty set
				CreateEmptySet(); //link method : create empty set
				break;//case end
				
			case 2:// case2 : new empty set that is equal to existing set
				CreateExistingSet(); //link method : create set that equal to existing set
				break;//case end
				
			case 3:// case3 : insert number
				InsertNum(); //link method : insert the num to set 
				break;//case end
				
			case 4:// case4 : delete number
				DeleteNum(); //link method : delete the num to set
				break;//case end
				
			case 5:// case 5 : union of two sets
				UnionSets(); //link method : show union of two sets
				break;//case end
				
			case 6:// case 6 : intersection of two sets
				IntersectionSets(); //link method : show intersection of two sets
				break;//case end
				
			case 7:// case7 : difference of two sets
				DifferenceSets(); //link method : show difference of two sets
				break;//case end
				
			case 8://case 8: size of set
				SizeOfSet(); //link method : show size of set
				 break;//case end
				 
			case 9://case 9: print set's all element
				PrintSet(); //link method : show print set's elements
				break;//case end
				
			case 10://case 10 : exit program
				System.exit(0); // exit program
				break;//case end
			}
			stateprint(); // in every looping, print current set state.
		}while(true); // first, i set the condition of input != 10. but it dosen't need, since the case 10 exit program, 

	}
}
