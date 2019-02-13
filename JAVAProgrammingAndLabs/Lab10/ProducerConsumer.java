package Lab10;

public class ProducerConsumer {
	public static void main(String[] args) {
		Bakery bObj = new Bakery();
		Producer pObj = new Producer(bObj, 1);
		Consumer cObj = new Consumer(bObj, 1);
		pObj.start();
		cObj.start();
	}
}
