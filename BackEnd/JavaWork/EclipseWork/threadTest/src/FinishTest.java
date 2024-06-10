class FinishDemo implements Runnable{
	String s;
	
	FinishDemo(String s){
		this.s = s;
	}
	
	@Override
	public void run() {
		System.out.println("자식 스레드 시작");
		int cnt = 0;
		do {
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			cnt++;
			System.out.print(".");
		}while(cnt < 10);
	
		System.out.println("자식 스레드 끝");
	}
}


public class FinishTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("메인 스레드 시작");
		FinishDemo c1 = new FinishDemo("first");
		FinishDemo c2 = new FinishDemo("second");
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		int cnt = 0;
		do {
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			cnt++;
			System.out.print("*");
		}while(cnt < 10);
		
//		t1.join();
//		t2.join();
	
		System.out.println("메인 스레드 끝");
		
	}

}
