package chapter06;

public class Subway {
	String lineNumber;
	int passengerCount;
	int money;
	
	public Subway(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public void takeOn(int money) {
		this.money += money;
		this.passengerCount++;
	}
	
	public void takeOff(int money) {
		this.passengerCount--;
	}
	
	public void showInfo() {
		System.out.println(lineNumber + "의 승객은" + passengerCount + "명이고, 총수입은 " + money + "입니다.");
	}
}
