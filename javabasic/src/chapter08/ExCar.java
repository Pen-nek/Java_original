package chapter08;

public class ExCar {
	
	// 생성자 호출 관계 확인
	
	// 디폴트 생성자 Default constructor
	public ExCar() {
		System.out.println("Car 클래스 생성자 호출!!");
	}
	
	// 생성자 오버로딩 - 자바에 다형성이 있기 때문에 가능
	public ExCar(String name) {
		System.out.println("Car 클래스 생성자 호출 with" + name);
	}
}// end of class Car