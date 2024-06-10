package scope;
import java.util.Random;


public class DiceBean {
	private int minNumber;
	private int maxNumber;
	private int counter = 0;
	
	public void setMinNumber(String minNumber) {
		this.minNumber = Integer.parseInt(minNumber);
	}
	
	public void setMaxNumber(String maxNumber) {
		this.maxNumber = Integer.parseInt(maxNumber);
	}
	
	public String getRandomNumber() {
		Random rand = new Random();
		return Integer.toString(rand.nextInt(minNumber, maxNumber + 1));
	}
	
	public int getCounter() {
		return ++counter;
	}
}
