/*



- class 이름은 대문자로 시작
- 하나의 java파일에 하나의 클래스가 원칙이나,
- 다수의 클래스가 같이 있는 경우 public 클래스는 단 하나,
- public 클래스와 자바 파일의 이름은 동일
*/
package chapter05;

public class A01_defineClass {

	public static void main(String[] args) {
		Student kong = new Student();
		Student chun = new Student();
		kong.setname("콩이");
		kong.address = "용암동";
		chun.setname("춘이");
		chun.address = "복대동";
		
		kong.study();
		chun.study();
	}

} // public class

