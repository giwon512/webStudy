package scope;

public class CounterBean {
	private int counter = 0;
	
	public void setNewVisit(int count) {
		this.counter += count;
	}
	
	public void setRestart(boolean b) {
		this.counter = 0;
	}
	
	public int getVisitCount() {
		return this.counter;
	}
}
