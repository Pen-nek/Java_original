package chapter06;

public class Bus {
	int busNumber;
	int passengerCount;
	int money;
	
	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}
	
	public void takeOn(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void takeOff(int money) {
		this.passengerCount--;
	}
	
	public void showInfo() {
		System.out.println(busNumber + "번 버스 승객은 " + passengerCount + "명이고, 총수입은 " + money + "입니다.");
	}
}
