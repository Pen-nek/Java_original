package chapter06;

public class Company {
	private static Company instance = new Company();
	// private 생성자를 만든다.
	private Company() {}
	
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
}// class Company