package simple;
import java.util.Date;
import java.util.Calendar;


public class CalendarBean {
	private Date today = new Date();
	
	public Date getToday() {
		return today;
	}
	
	public int getYear() {
		return Calendar.YEAR;
	}
	
	public int getMonth() {
		return Calendar.MONTH;
	}
	
	public int getDate() {
		return Calendar.DATE;
	}
	
}
