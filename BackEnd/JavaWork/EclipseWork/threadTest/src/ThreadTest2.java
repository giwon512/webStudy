class ThreadDemo2 extends Thread{

	@Override
	public void run() {
		System.out.println("start children thread");
		
		int cnt = 0;
		do {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cnt++;
			System.out.print(cnt + " ");
		}while(cnt < 10);
		System.out.println("finish children thread");
	}
	
}


public class ThreadTest2 {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("start main thread");
		
		ThreadDemo2 demo = new ThreadDemo2();
		demo.start();
		
		int cnt = 0;
		do {
			Thread.sleep(500);
			cnt++;
			System.out.print('.');
		}while(cnt < 10);
		
		System.out.println("finish main thread");
	}

}
