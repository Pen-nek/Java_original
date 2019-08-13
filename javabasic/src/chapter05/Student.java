package chapter05;

public class Student{
	int id;
	private String name;	// 해당 클래스 외부에서 바꾸거나 확인하지 못하게 private으로 숨김
	int grade;
	String dept;
	String address;
	
	// 기본 생성자
	public Student() {
		System.out.println("기본 생성자 호출");
	}
	
	// 이름을 패러미터로 가지는 생성자
	public Student(String p_name) {
		name = p_name;
		System.out.println("이름을 가진 생성자 호출");
	}
	
	// 풀 패러미터 생성자
	public Student(int p_id, String p_name, int p_grade, String p_dept, String p_address) {
		id = p_id;
		name = p_name;
		grade = p_grade;
		dept = p_dept;
		address = p_address;
		System.out.println("full parameter 생성자 호출");
	}
	
	public void setname(String pname) {	// name 접근은 private으로 막혀있으므로 메소드를 사용
		name = pname;
	}
	
	public String getname() {
		return name;
	}
	
	public void study() {
		System.out.println(name + "(이)가 " + dept + " 전공을 공부한다.");
	}
	
	public void showInfo() {
		System.out.println(id + ", " + name + ", " + grade + ", " + dept + ", " + address);
	}
	
} // class Student

