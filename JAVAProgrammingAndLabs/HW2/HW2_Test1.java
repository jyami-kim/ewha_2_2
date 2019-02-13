package HW2;
import java.util.ArrayList;

//Sample Test class with main method
public class HW2_Test1 {
	public static void main(String[] args) {

		System.out.println("Student ID 1771008: Minjeong Kim"); //information for me
		
		MySet a = new MySet(); // now MySet "a" is {}
		a.Insert(2); // a = {2}
		a.Insert(3); // a = {2, 3}
		
		MySet b = new MySet(a);// now MySet "b" is the same as MySet "a" = {2, 3}
		
		b.Insert(5); // b = {2, 3, 5}
		b.Delete(2); // b = {3, 5}
		a.Insert(10); // a = {2, 3, 10}
		a.Insert(8); // a = {2, 3, 10, 8}
		
		MySet c = a.Intersection(b); // c = {3}
		
		MySet d = a.Union(b); // d = {2, 3, 10, 8, 5}
	
		MySet e = d.Diff(c); // e = {2, 10, 8, 5}
		MySet f = c.Diff(d); // f = {}
		
		MySet g = new MySet(100);// now MySet "g" is {100}
		
		c.Empty(); // c = {}
		
		System.out.println("10 is in e : "+e.IsPresent(10)); // true;
		System.out.println("9 is in e : "+e.IsPresent(9)); // false;
		System.out.println("e is subset of d : "+ d.IsSubset(e));//true;
		System.out.println("d is subset of e : "+ e.IsSubset(d));//false;
		System.out.println("c is equal to f? : "+c.IsEqual(f)); // true;

		System.out.println();
		//check all MySet objects' values and size of set
		a.Print(); // {2, 3, 10, 8}
		System.out.println(" size of set a is "+a.Size()); // 4
		b.Print(); // {3, 5}
		System.out.println(" size of set b is "+b.Size());	// 2
		c.Print(); // {}
		System.out.println(" size of set c is "+c.Size());	// 0
		d.Print(); // {2, 3, 10, 8, 5}
		System.out.println(" size of set d is "+d.Size());	// 5
		e.Print(); // {2, 10, 8, 5}
		System.out.println(" size of set e is "+e.Size());	// 4
		f.Print(); // {}
		System.out.println(" size of set f is "+f.Size());	// 0
		g.Print(); // {}
		System.out.println(" size of set f is "+g.Size());	// 1
		
	}
}