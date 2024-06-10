class StopDemo implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.println("Thread is alive...");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("Thread is dead...");
		}
	}
	
}

public class StopTest {

	public static void main(String[] args) throws InterruptedException {
		
		StopDemo demo = new StopDemo();
		Thread t = new Thread(demo);
		t.start();
		
		Thread.sleep(3000);
		
//		t.stop();
		t.interrupt();
	}

}
