package chapter06;

public class Student {
	public static int serialNum = 1000;
	public int studentID;
	public String studentName;
	public int grade;
	public int money;
	public String address;
	
	// 이름과 가진 돈을 매개변수(패러미터)로 받는 생성자
	public Student(String studentName, int money) {		// studentName, money는 지역변수 : 이 메소드 안에서만 유효한 이름. 위에 있는 멤버변수와는 다른 것.
		this.studentID = serialNum++;	// ++연산자를 시리얼넘 왼쪽에 써주면 +1 먼저 되고 스튜던트ID에 대입됨
		this.studentName = studentName;
		this.money = money;
	} // Student()
	
	public void takeOnBus(Bus bus) {
		bus.takeOn(1000);
		this.money -= 1000;
	}
	
	public void takeOffBus(Bus bus) {
		bus.takeOff(1000);
	}
	
	public void takeOnSubway(Subway subway) {
		subway.takeOn(1500);
		this.money -= 1500;
	}
	
	public void takeOffSubway(Subway subway) {
		subway.takeOff(1000);
	}
	
	public void showInfo() {
		System.out.println(studentID);
	}
	
	public static void showSerial() {
		System.out.println(serialNum);
	}
	
} // Student class
