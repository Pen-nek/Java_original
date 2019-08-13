package chapter04;

import java.util.Scanner;

public class A03_IfElseIfElse2 {

	public static void main(String[] args) {
//		// 문제1. 연령에 따른 공원 입장료 계산의 예
//		// 10살 이하 1,000원, 11~20살 2,000원, 21세 이상 3,000원
//			// 내 답
//			int age = 10;
//			
//			if(21<=age) {
//				System.out.println("입장료 3,000원");
//			}else if((20>=age) && (11<=age)) {
//				System.out.println("입장료 2,000원");
//			}else {
//				System.out.println("입장료 1,000원");
//			}
//			
//			// 빠른 답
//			int age = 10;
//			int money;
//			
//			if(age <= 10) {
//				money = 1000;
//			}else if(age <= 20) {
//				money = 2000;
//			}else {
//				money = 3000;
//			}
		
		// 문제2. 입력된 숫자가 3, 4, 5배수일 때 해당하는 문장 출력. 포함되지 않으면 "그 외의 경우입니다" 출력
		
			// 스캐너 실행
			Scanner sc = new Scanner(System.in);
			
			// 변수 선언
			int num, num3, num4, num5;
			
			// 입력
			System.out.println("3/4/5 배수를 판단할 숫자 입력 : ");
			num = sc.nextInt();
			
			// 계산 및 출력
			if ((num % 3) == 0) {System.out.println("3의 배수");}
			else if ((num % 4) == 0) {System.out.println("4의 배수");}
			else if ((num % 5) == 5) {System.out.println("5의 배수");}
			else {System.out.println("그 외의 경우입니다");}
	}

}
