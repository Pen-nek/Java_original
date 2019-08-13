package chapter08;

public class ExSedan extends ExCar {
	
	// 생성자 호출 관계 확인
	
	// 디폴트 생성자 Default constructor
	public ExSedan() {
		System.out.println("Sedan 클래스 생성자 호출!!");
	}
	
	// 생성자 오버로딩 - 자바에 다형성이 있기 때문에 가능
	public ExSedan(String name) {
		super("여기요~");		// super클래스에서 현재 sub클래스와 같은 패러미터가 있는 생성자 호출
		System.out.println("Sedan 클래스 생성자 호출 with " + name);
	}
	
}
