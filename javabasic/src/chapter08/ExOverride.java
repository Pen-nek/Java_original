/*
 * 메서드 오버라이드 사용 예
 * 
 * 오버라이드의 의미를 파악했다면....
 * 왜 굳이 @Override 라는 annotation을 적을까? 안적으면 안될까?
 * => 컴파일러에게 오버라이딩 하겠다는 걸 알려줌
 * => 오버라이딩을 하려다가 실수로 메소드 이름을 잘못 적는 등의 오류를 방지하기 위함
 * 
 * Annotation의 종류는 다양 (ex.Test 등)
 */
package chapter08;

public class ExOverride {

	public static void main(String[] args) {
		Student orgStudent = new Student();
		StudentElement eleStudent = new StudentElement();
		StudentMiddle midStudent = new StudentMiddle();
		
		orgStudent.study();
		eleStudent.study();
		midStudent.study();
	}
}