package chapter03;

public class A04_LogicalOperator {

	public static void main(String[] args) {
		// 논리 연산자
		// &&(AND) : 두 항 모두가 참일 때 참
		System.out.println((10>5)&&(3>1));
		System.out.println((10<5)&&(3>1));
		
		// ||(OR) : 두 항 중 하나가 참이면 참
		System.out.println((10<5)||(3<1));
		System.out.println((10>5)||(3<1));

		// !(NOT) : 참을 거짓으로, 거짓을 참으로 변경
		System.out.println("!(NOT) : " + !(10>5));
	}

}
