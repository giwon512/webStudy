package mybean;

import java.util.Date;

public class CarDto {
	private String plateNumber;
	private long parkingTime;
	
	public CarDto(String plateNumber, long parkingTime) {
		this.plateNumber = plateNumber;
		this.parkingTime = parkingTime;
	}
	
	public CarDto() {}

	public String getPlateNumber() {
		return plateNumber;
	}

	public Date getParkingTime() {
		return new Date(parkingTime);
	}
	
	
}
