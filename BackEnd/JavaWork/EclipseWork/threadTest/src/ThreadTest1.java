//class ThreadDemo extends Thread {
////	private String name;
//	
//	public ThreadDemo(String name) {
////		this.name= name;
//		super(name);
//	}
//
//	@Override
//	public void run() {
//		int sum = 0;
//		for(int i = 0; i < 5; i++) {
//			try {
//				sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			sum += i;
//			System.out.println(getName() + ": " + sum);
//		}
//	}
//	
//}

class ThreadDemo implements Runnable {
	private String name;
	
	public ThreadDemo(String name) {
		this.name= name;
	}

	@Override
	public void run() {
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum += i;
			System.out.println(name + ": " + sum);
		}
	}
	
}


public class ThreadTest1 {

	public static void main(String[] args) throws InterruptedException {
		ThreadDemo demo1 = new ThreadDemo("first");
		ThreadDemo demo2 = new ThreadDemo("second");
		Thread t1 = new Thread(demo1);
		Thread t2 = new Thread(demo2);
		t1.start();
		t1.join();
		t1.start ();

	}

}
