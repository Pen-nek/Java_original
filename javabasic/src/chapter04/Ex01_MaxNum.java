package chapter04;

import java.util.Scanner;

public class Ex01_MaxNum {

	public static void main(String[] args) {
		
		// 변수 선언
		int num1, num2, num3, max;
		
		// 스캐너 시작
		Scanner sc = new Scanner(System.in);
		
		// 입력 받기
		System.out.println("첫번째 숫자 입력 : ");
		num1 = sc.nextInt();
		System.out.println("두번째 숫자 입력 : ");
		num2 = sc.nextInt();
		System.out.println("세번째 숫자 입력 : ");
		num3 = sc.nextInt();
		
		// 계산하기
			// 나의 답
			if (num1>=num2) {
				if (num1>=num3) {
					System.out.println("가장 큰 숫자는 " + num1);
				} else {
					System.out.println("가장 큰 숫자는 " + num3);
				}
			} else if (num2>=num3) {
				System.out.println("가장 큰 숫자는 " + num2);
			} else {
				System.out.println("가장 큰 숫자는 " + num3);
			}
		
//		// 빠른 답
//		max = num1;
//		if(num2 > max) max = num2;
//		if(num3 > max) max = num3;
//		
//		// 최대값 출력하기
//		System.out.println("가장 큰 수는" + max);
		
	}

}
