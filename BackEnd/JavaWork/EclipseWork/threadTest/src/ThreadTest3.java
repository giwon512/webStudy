class ThreadDemo3 extends Thread{
	
	ThreadDemo3(String name){
		super(name);
		start();
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println(getName() + " " + i);
		}
	}
}



public class ThreadTest3 {

	public static void main(String[] args) {
		// TODO 문제
		ThreadDemo3 d1 = new ThreadDemo3("thread1");
		ThreadDemo3 d2 = new ThreadDemo3("thread2");
		ThreadDemo3 d3 = new ThreadDemo3("thread3");
		
	}

}
