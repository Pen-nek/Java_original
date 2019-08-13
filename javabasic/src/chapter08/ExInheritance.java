package chapter08;

public class ExInheritance {

	public static void main(String[] args) {
		// 상속 관계에 있는 클래스들의 생성자 호출 관계를 확인하자 
		ExSedan sedan1 = new ExSedan();		// 실행하면 Car생성자와 Sedan생성자가 함께 호출됨. Sedan의 실행을 위해선 상속하는 Car도 생성돼야 하기 때문.
		System.out.println("=================================");
		ExSedan sedan2 = new ExSedan("Lee");	// 실행하면 역시 Car의 디폴트 생성자가 새로운 Sedan과 같이 호출됨. 기본 생성자
		
	}

}
