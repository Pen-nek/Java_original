package chapter06;

public class StudentText {

	public static void main(String[] args) {
		/*
		Student studentKim = new Student("kim", 10000);
		studentKim.showInfo();
		Student studentLee = new Student("Lee", 10000);
		studentLee.showInfo();
		*/
		
		//객체를 생성하지 않은 상태에서 클래스 변수값을 확인하고 싶다! : static변수는 가능
		// System.out.println(Student.grade);
		Student.showSerial();
	}

}
