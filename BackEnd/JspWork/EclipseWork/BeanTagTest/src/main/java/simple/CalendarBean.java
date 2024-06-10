package simple;
import java.util.Date;
import java.util.Calendar;


public class CalendarBean {
	private Date today = new Date();
	private Calendar cal = Calendar.getInstance();
	private String greeting = null;
	
	public Date getToday() {
		return today;
	}
	
	public int getYear() {
		return cal.get(Calendar.YEAR);
	}
	
	public int getMonth() {
		return cal.get(Calendar.MONTH) + 1;
	}
	
	public int getDate() {
		return cal.get(Calendar.DATE);
	}
	
	public void setGreeting(String str) {
		this.greeting = str;
	}
	
	public String getGreeting() {
		return greeting;
	}
	
	
}
