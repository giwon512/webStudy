package mybean;
import java.util.*;

public class ParkingBean {
	private ArrayList<CarDto> carList = new ArrayList<>();
	
	public void setEnter(String plateNumber) {
		carList.add(new CarDto(plateNumber, System.currentTimeMillis()));
	}
	
	public void setExit(String plateNumber) {
		for(int i = 0; i < carList.size(); i++) {
			if(carList.get(i).getPlateNumber().equals(plateNumber)) {
				carList.remove(i);
			}
		}
	}
	
	public int getCounter() {
		return carList.size();
	}
	
	public ArrayList<CarDto> getCarInfo() {
		return carList;
	}
}
