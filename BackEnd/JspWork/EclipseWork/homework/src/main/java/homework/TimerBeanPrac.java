package homework;
import java.util.Date;


public class TimerBeanPrac {
	private long currTime = new Date().getTime();
	private long startTime = new Date().getTime();
	
	
	public void setRestart(String restart) {
		if(Boolean.parseBoolean(restart)) {
			currTime = new Date().getTime();
		}
	}
	
	public long getElapsedTime() {
		return (new Date().getTime() - currTime) / 1000;
	}
	
	public long getElapsedTimeAfterInst() {
		return (new Date().getTime() - startTime) / 1000;
	}
	
	public long getElapsedTimeAfterLastAccess() {
		return (new Date().getTime() - new Date().getTime());
	}
}
