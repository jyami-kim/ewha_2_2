package HW2;
import java.util.ArrayList;

public class MySet {
	
	public static int name_num=65; //for setting the set name, define the variable (I consider the ascii code number)

	private ArrayList<Integer> set; //set = {}
	private int set_length; //the size of the set
	String set_name; //set_name is assigned according to name_num and noascii variable
	
	public void makename() { //for making set name, use this function
		if(name_num<=90) {//since alphabet's ascii code is 65~90, consider this condition
			set_name = Character.toString((char)name_num); //to change integer to asciicode, change name_num's data type.
			name_num++; // A to Z
			}
		else {
			System.out.println("Set is Full"); // since. the set name range is A to Z, if the ascii over the Z(=90) the program is exit
			System.exit(0);
		}
	}
	
	public MySet() { //default constructor; construct an empty set
		set = new ArrayList<Integer>(); //initialize ArrayList
		set_length=0; //initialize set length
		makename(); //for initialize set name, use makename() method
	}
	
	public MySet(int num) { //constructs a set that contains only one element, the num
		set = new ArrayList<Integer>(); //initialize ArrayList
		set.add(num); //for this object contains one element, use add method
		set_length=	1; //initialize set length 1, because this object contains only one element
		makename(); //for initialize set name, use makename() method
	}
	
	
	public MySet(MySet s) {// one more constructor that returns a copy of the set s
		//set = new ArrayList<Integer>(s.set);  //the easy way copy of the set (but it is not homework's condition)
		set = new ArrayList<Integer>(); //initialize ArrayList
		for(int i=0; i<s.set_length; i++) { //because copy the set s, set the s.set's elements to this object by using the loop statement
			set.add(s.set.get(i)); //access the s set's ith element, and insert the this set
		}
		set_length = s.set_length; //Since this set is copyed by s set, the set length is same
		makename(); //for initialize set name, use makename() method
	}

	
	public void Empty() {//discards all the elements of the set
		for(int i=0; i<set_length; i++) {//Since remove all the set elements, using for loop
			set.remove(i); // use remove() method
		}
		set_length = 0; //Since, the remove() method haven't set_length-- code, assign the set_length to zero
	}
	
	public void Insert(int num) {//inserts the num into the set only if it is not in the set
		if(!IsPresent(num)) {//if the num is in set, don't insert the num 
			set.add(num); //use ArrayList's add method
			set_length++; //plus set_length value
		}
	}
	
	public void Delete(int num) {// deletes the num from the set if it is in the set
		for(int i=0; i<set_length; i++) { // Since check the num is in set, use for loop
			if(num ==set.get(i)) { //if set element is equal to num return true
				set.remove(i); //use ArrayList's remove method
				set_length--; //minus set_length value
			}
		}
	}
	
	public boolean IsPresent(int num) { //return true if the element num is present in the set , false otherwise
		for(int i=0; i<set_length; i++) { //Since check the num is in set, use for loop
			if(num == set.get(i)) //if set element is equal to num return true
				return true; // Since satisfy the conditions, return true
		}
		return false; // Since didn't satisfy the condition, return false
	}
	
	public boolean IsSubset(MySet s) { //return true if "s" is a subset of "this"
		if(s.set_length==0) { //{} is subset always
			return true; //return method
		}
		for(int i=0; i<s.set_length; i++) { //use for loop, to check the all the s set element is in this set
			if(!IsPresent(s.set.get(i))) //checking the s set element is in this set
				return false; // if s set element isn't in this set, return false
		}
		return true; // after for loop, we can check all the s set element is in this set
	}
	
	public boolean IsEqual(MySet s) { // return true if two sets "this" and "s" have the same elements
		for(int i=0; i<set_length; i++) { //check all the element using for loop
			if(!(s.IsPresent(set.get(i)))) // consider the case that two sets' all element is equal, but order is not equal. so use Ispresent() method
				return false; //if atleast 1 ispresent() method's return value is existed, it is not equal
		}
		return true; // all the element is equal, so return true
	}

	public int Size() { //return the size of this set
		return set_length; // constructor, Delete(), Insert() methods are considered set_length
	}
	

	public void Print() { // prints the elements in "this" set
		if(set_length==0) { //if set_length==0 (null set), Since the set_length is -1, occure the error. so set if statement
			System.out.print("{}"); // print {}
		}else { //general case
			System.out.print("{"); // for satisfy the print format, print {
			for(int i=0; i<set_length-1; i++) {//to access set's all value use for loop
				System.out.print(set.get(i)+", "); // access set value, and satisfy the printf format
			}
			System.out.print(set.get(set_length-1)+"}"); // for satisfy the print format, last value is not print ','. So I separate with for loop
		}
	}
	
	public MySet Union(MySet s) { //return the union of two sets "this" and "s"
		MySet union = new MySet(this); //initialize new Myset, contents are copy by "this" 
		for(int i=0; i<s.set_length; i++) { //to access set's all value, use for loop
			union.Insert(s.set.get(i)); //Use Insert method, because the method is not overlap elements 
		}
		return union; // return the result MySet type value
	}
	
	public MySet Intersection(MySet s) { // return the intersection of two sets "this" and "s"
		MySet result = new MySet(); //initialize new MySet
		for(int i=0; i<s.set_length; i++) { // to access set's all value, use for loop
			if(IsPresent(s.set.get(i))) { //if Ispresent method result is true, 
				result.Insert(s.set.get(i)); //Since Ispresent conditions is true, insert the value
			}
		}
		return result; // return the result Myset type value
	}
	
	public MySet Diff(MySet s) {// return the difference "this - s", not "s - this"
		MySet result = new MySet(this); //initialize new Myset, contents are copy by "this"
		for(int i=0; i<set_length; i++) { //to access set's all value, use for loop
			if(s.IsPresent(set.get(i))) { //if Ispresent method result is true, its value is intersection value
				result.Delete(set.get(i)); //delete the intersection value 
			}
		}
		return result; // return the result MySet type value
	}
} // end of public class "MySet"
