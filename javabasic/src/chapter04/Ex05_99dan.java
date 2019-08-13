package chapter04;

import java.util.Scanner;

public class Ex05_99dan {

	public static void main(String[] args) {
		
		// 문제.사용자가 단을 입력하면 해당 단의 구구단을 출력하는 프로그램 작성
		// 단, 0을 입력하면 프로그램 종료
		
		/*
		1. 준비
	 		- 필요한 변수 선언 
	 		- 스캐너 온
	 		
	 	2. 프로그램 무한반복 (0 입력 시까지)
	 		2.1 단 입력받기
	 		2.2 단 출력
	 	
	 	3. 프로그램 종료
		*/
		
		
		
		// 내 대답
		/*
		int dan=9, i;
		Scanner sc = new Scanner(System.in);
		
		while(dan != 0){
			
			System.out.println("구구단을 출력할 단수를 입력해주세요. : ");
			dan = sc.nextInt();

			if (dan != 0) {
				for (i=1; i<=9; i++)
				System.out.println(dan + "*" + i + "=" + dan*i);
			} else {
				System.out.println("프로그램 종료");
				break;
			}		
		
		} // while
		*/
		
		
		
		// 교수님 대답
		int dan=1;
		Scanner sc = new Scanner(System.in);
		
		while(dan != 0){
			
			System.out.println("몇 단? >> ");
			dan = sc.nextInt();
			
			if (dan == 0) break;
			
			for (int i=1; i<=9; i++)
				System.out.println(dan + "*" + i + "=" + dan*i);
		} // while
		
		System.out.println("프로그램 종료");
		
	} // main

}
