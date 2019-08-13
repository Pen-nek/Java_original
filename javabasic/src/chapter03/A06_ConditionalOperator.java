package chapter03;

import java.util.Scanner;

public class A06_ConditionalOperator {

	public static void main(String[] args) {
		/*
		 * int result; result = (10<5)? 100:999; 
		 * System.out.println(result);
		 */
		
		//부, 모의 나이를 입력받아 나이 많은 분이 누구인지 출력
		Scanner sc = new Scanner(System.in);
		
		int mAge, dAge;
		String result;
		
		System.out.println("어머니 나이 : ");
		mAge = sc.nextInt();
		System.out.println("아버지 나이 : ");
		dAge = sc.nextInt();
		
		result = (mAge>dAge)? "어머니" : "아버지";

		System.out.println("연장자 : " + result);
		
	}

}
