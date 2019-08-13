package chapter04;

import java.util.Scanner;

public class Ex04_SimpleBanking {

	public static void main(String[] args) {
		
		// 문제. 입금 출금 잔고 종료 기능을 가진 잔고관리 프로그램
		
		// 내 대답
		/*
		Scanner sc = new Scanner(System.in);
		int inout=0, balance=0, menu=0;
		
		while (menu != 4) {		// 작업번호가 4가 아닌 경우 반복
			
			System.out.println("1.입금  2.출금  3.잔고  4.종료 \r작업번호를 입력해주세요.");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1 :
				System.out.println("입금할 금액을 입력해주세요.");
				inout = sc.nextInt();
				balance += inout;
				System.out.println(inout + "원이 입금되었습니다.");
				break;
			case 2 :
				System.out.println("출금할 금액을 입력해주세요.");
				inout = sc.nextInt();
					if (inout<=balance) {
						balance -= inout;
						System.out.println(inout + "원이 출금되었습니다.");
					} else {
						System.out.println("출금 불가(잔고 부족)");
					}
				break;
			case 3 :
				System.out.println("현재 잔고 : " + balance + "원");
				break;
			case 4 :
				System.out.println("프로그램 종료");
				break;
			default : System.out.println("작업번호 선택 오류");
			} // switch
			
			System.out.println();
			
		} // while
		*/
		
		// 교수님 대답
		// 1. 필요한 변수 선언
		int jobnumber=0, balance=0, workMoney=0;
		Scanner kbd = new Scanner(System.in);
		
		// 2. 작업번호가 4가 아닌 동안 무한반복
		do {
			// 2.1 선택메뉴 디스플레이
			System.out.println("1.입금 2.출금 3.잔고조회 4.종료");
			// 2.2 작업종류 입력
			System.out.println("선택>>");
			jobnumber = kbd.nextInt();
			// 2.3 작업종류에 따라
			switch(jobnumber) {
			case 1://입금의 경우
				System.out.println("입금액>>");
				workMoney = kbd.nextInt();
				balance += workMoney;
				break;
			case 2:
				System.out.println("출금액>>");
				workMoney = kbd.nextInt();
				if(workMoney <= balance) {balance -= workMoney;}
				else System.out.println("잔고가 부족합니다.");
				break;
			case 3:
				System.out.println("현재 잔고>>" + balance);
				break;
			case 4:
				break;
			default:
				System.out.println("선택을 다시 해주세요.");
			}// switch
		} while(jobnumber != 4);
		
		// 3. 프로그램 종료
		System.out.println("프로그램 종료");
		
	} // main

}
