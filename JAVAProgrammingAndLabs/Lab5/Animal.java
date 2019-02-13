package Lab5;

public class Animal {
	public static void main(String args[]) {
		Animal animal = new Animal();
		Animal dog  = new Dog();
		animal.print(); // animal
		dog.print(); //dog
	}
	private void print() {
		System.out.println("Superclass Animal");
	}
}
