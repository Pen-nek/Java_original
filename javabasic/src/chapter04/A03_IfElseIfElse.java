package chapter04;

public class A03_IfElseIfElse {

	public static void main(String[] args) {
		// 연령에 따른 공원 입장료 계산의 예
		// 10살 이하 1,000원, 11~20살 2,000원, 21세 이상 3,000원
		// 내 정답
//		int age = 10;
//		
//		if(21<=age) {
//			System.out.println("입장료 3,000원");
//		}else if((20>=age) && (11<=age)) {
//			System.out.println("입장료 2,000원");
//		}else {
//			System.out.println("입장료 1,000원");
//		}
		
		// 교수님 정답
		int age = 10;
		int money;
		
		if(age <= 10) {
			money = 1000;
		}else if(age <= 20) {
			money = 2000;
		}else {
			money = 3000;
		}
	}

}
