package chapter05;

public class CarTest {

	public static void main(String[] args) {	// void : 리턴값이 있을 수도 없을 수도 있음
		Car kongCar = new Car();	// 클래스이름 인스턴스 = 생성자();
									// 이제 Car클래스에 속하는 인스턴스 하나를 부를 거야. 이름은 KongCar. 생성자는 Car();	
		System.out.println(kongCar);
		
		Car c = kongCar.returnItself();
		System.out.println(c);
	}

}
