package chapter03;

import java.util.Scanner;

public class A03_RelationalOperator {

	public static void main(String[] args) {
		// 예제_생년을 입력받아 성년(19세 이상) 여부를 판단하라.
		// Scanner 돌리기
		Scanner sc = new Scanner(System.in);
		
		// 필요한 변수 선언
		int birth, age;
		boolean adultOr;
		
		// 생년 입력 요구 메시지 출력
		System.out.println
		("성인 여부를 판단합니다. 태어난 연도를 적어주세요.(ex.1993) : ");
		
		// 생년 입력 받음
		birth = sc.nextInt();
		
		// 나이 계산
		age = 2019 - birth;
		
		// 성년 여부 판단
		adultOr = age >= 19;
		
		// 성년 여부 출력
		System.out.println("성인 여부 : " + adultOr);
	}

}
