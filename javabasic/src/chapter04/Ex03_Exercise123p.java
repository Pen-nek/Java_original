package chapter04;

import java.util.Scanner;

public class Ex03_Exercise123p {

	public static void main(String[] args) {
		// 123p 연습문제 1~3 풀기 
		// 문제 1 - if문 (스캐너 사용하면 작동 안 됨)
//			// 변수 선언
//			int num1, num2, result = 0;
//			String oprt;
//			
//			// 스캐너 온
//			Scanner sc = new Scanner(System.in);
//			
//			// 입력 요청
//			System.out.println("연산을 수행할 첫번째 숫자 : ");
//			num1 = sc.nextInt();
//			System.out.println("연산을 수행할 두번째 숫자 : ");
//			num2 = sc.nextInt();
//			System.out.println("연산하고 싶은 기호(ex. +, -, *, /) : ");
//			oprt = sc.next();
//			
//			// 처리
//			if (oprt=="+") {
//				result = (num1+num2);
//			} else if (oprt=="-") {
//				result = (num1-num2);
//			} else if (oprt=="*") {
//				result = (num1*num2);
//			} else if (oprt=="/") {
//				result = (num1/num2);
//			} else {
//				System.out.println("잘못된 기호입니다.");
//			}
//			
//			// 결과 출력
//			System.out.println("연산결과 : " + result);
			
		
		
		// 문제 1 - switch문
//		int num1, num2, result=0;
//		String oprt;
//		
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("연산을 수행할 첫번째 숫자 : ");
//		num1 = sc.nextInt();
//		System.out.println("연산을 수행할 두번째 숫자 : ");
//		num2 = sc.nextInt();
//		System.out.println("연산하고 싶은 기호(ex. +, -, *, /) : ");
//		oprt = sc.next();
//		
//		
//		switch(oprt) {
//			case "+" : result = (num1+num2);
//			break;
//			case "-" : result = (num1-num2);
//			break;
//			case "*" : result = (num1*num2);
//			break;
//			case "/" : result = (num1/num2);
//			break;
//			default : System.out.println("잘못된 기호입니다.");
//		}
//		System.out.println(num1 + oprt + num2 + " = " + result);
		
		
		
		// 문제2 - 구구단을 짝수 단만 출력 (continue문 사용)
		
//		int i, j;
//		
//		for(i=1; i<=9; i++) {
//			
//			if (i%2==1) continue;				// continue : 이건 빼고 계속해
//			System.out.println(i + "단");
//			
//			for(j=1; j<=9; j++) {System.out.println(i + "*" + j + "=" + i*j);}		// 이 for문을 계산해야 할 때마다 j의 값은 초기식에서 초기화됨
//			System.out.println();
//		}
		
		
		
		// 문제3 - 구구단을 단보다 곱하는 수가 작거나 같은 경우까지만 출력
		
//		int i, j=1;
//		
//		for(i=1; i<=9; i++) {
//			System.out.println(i + "단");
//			
//			for(j=1; j<=i; j++) {
//				System.out.println(i + "*" + j + "=" + i*j);
//			}
//			System.out.println();
//		} 
		
		
		
		// 문제3 - 구구단을 단보다 곱하는 수가 작거나 같은 경우까지만 출력 (break문 사용)
		
		int i, j=1;
		
		for(i=1; i<=9; i++) {
			System.out.println(i + "단");
			
			for(j=1; j<=9; j++) {
				if (j<=i) {System.out.println(i + "*" + j + "=" + i*j);}
				else break;
			}
			
			System.out.println();
		} 
	    
		
	} // end of main

}
