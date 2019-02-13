package Lab10;

public class PrintStringsThread extends Thread{
	public String str1;
	public String str2;
	
	public PrintStringsThread(String str1, String str2) {
	this.str1 = str1;
	this.str2 = str2;
	}
	
	public void run() {
	print(str1, str2);
	}
	
	public synchronized static void print(String str1, String str2) {
	System.out.print(str1);
	try {
	sleep(500);
	}
	catch (InterruptedException ex) {
	System.out.println(ex);
	}
	System.out.println(str2);
	}
}
