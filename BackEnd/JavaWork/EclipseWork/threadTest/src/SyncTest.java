class Toilet {
	public synchronized void openDoor(String name) {
		System.out.println(name + "가 화장실에 들어왔습니다.");
		
		for(int i = 0; i < 10000; i++) {
			if(i == 5000) {
				System.out.println(name);
			}
		}
		
		System.out.println(name + "가 화장실에서 나갔습니다.");
	}
}

class Family extends Thread{
	Toilet toilet;
	String who;
	
	Family(Toilet t, String w){
		toilet = t;
		who = w;
	}
	
	@Override
	public void run() {
		toilet.openDoor(who);
	}
}

public class SyncTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Toilet t = new Toilet();
		Family dad = new Family(t, "dad");
		Family mom = new Family(t, "mom");
		Family son = new Family(t, "son");
		
		dad.start();
		mom.start();
		son.start();

	}

}
