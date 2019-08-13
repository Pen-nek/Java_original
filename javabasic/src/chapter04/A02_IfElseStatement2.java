package chapter04;

import java.util.Scanner;

public class A02_IfElseStatement2 {

	public static void main(String[] args) {
//		if(10>5) {
//			System.out.println("조건이 참일 때 실행"); 
//		} else {
//			System.out.println("조건이 거짓일 때 실행");
//		}
//		System.out.println("조건과 상관없이 실행");
		
		
		// 키보드로부터 숫자를 입력받아 홀수 짝수를 판단하여 출력
			// 스캐너 실행
			Scanner sc = new Scanner(System.in);
			
			// 필요한 변수
			int num, result;
			
			// 입력 요청
			System.out.println("홀짝을 구분할 숫자를 입력하세요. : ");
			num = sc.nextInt();
			
			// 계산 및 출력
			result = num % 2;
			
			if(result == 1) {
				System.out.println("홀수");
			}else {
				System.out.println("짝수");
			}
		
	}

}
