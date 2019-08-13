/*
 * 상수(Constant) : 프로그램에서 변하지 않는 수. 항상 변하지 않는 값
 * 자바에서는 final이라는 키워드를 사용해서 선언
 * 
 * 리터럴 : 프로그램에서 사용하는 모든 숫자, 문자, 논리값(True/False)을 일컫는 말
 * 		   보통은 대입 연산자의 오른쪽에 쓰여지는 값
 */


package chapter02;

import java.util.Scanner;

public class A05_Constant {

	public static void main(String[] args) {
//		final int MAX_NUM = 1000;
		final double PI = 3.141592;
		
//		System.out.println(MAX_NUM);
//		System.out.println(PI);
//		
//		System.out.println(1+MAX_NUM);
		
		
		
		// 예제1. 원의 넓이 구하기
			// 키보드로부터 입력을 받기 위해 스캐너 객체 sc를 생성
		Scanner sc = new Scanner(System.in);
		
			// 입력해달라는 문장 출력
//		System.out.println("반지름을 입력해주세요 : ");
		
			// 변수와 자료형 선언 및 입력받을 창 출력
//		double r = sc.nextDouble();
		
			// 원의 넓이를 서클에어리어 변수로 선언
//		double circleArea = r * r * PI;
		
			// 서클에어리어 변수를 정수로 명시적 형변환하고 결과를 내보냄
//		System.out.println((int)circleArea);

		
		
		// 예제2. 이름 입력받아 출력하기
			// 문자열을 취급하기 위한 데이터 타입
		String name = "Hong GilDong";
		System.out.println(name);
		System.out.println("이름을 입력해주세요 : ");
		name = sc.next();
		System.out.println(name);
		
	}

}
