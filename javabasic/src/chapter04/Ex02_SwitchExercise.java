/*
 * 프로그램 작성 전, 처리과정 표현 방법
 * 1. 순서도
 * 2. 의사코드 (Pseudo Code) : 일상적인 말로 프로그램 처리과정을 순서대로 기술하는 것. 영어로 해야 함
 */

package chapter04;

import java.util.Scanner;

public class Ex02_SwitchExercise {

	public static void main(String[] args) {
		// 1. 필요한 변수 선언
		int birthYear, age;
		Scanner kbd = new Scanner(System.in);
		
		// 2. 생년을 입력하라는 메시지 출력하고 입력받기
		System.out.println("생년은?");
		birthYear = kbd.nextInt();
		
		// 3. 나이 계산
		age = 2019-birthYear;
		
		// 4. 계산된 나이를 10으로 나누어 몫이
		switch (age/10) {
		//	 	4-1. 0,1의 경우에는 청소년으로 출력
		case 0: case 1:
			System.out.println("청소년");
			break;
		//		4-2. 2,3의 경우에는 청년이라 출력
		case 2: case 3:
			System.out.println("청년");
			break;
		//		4-3. 4,5의 경우에는 중장년이라 출력
		case 4: case 5:
			System.out.println("중장년");
			break;
		//		4-4. 그 외의 경우에는 노년이라 출력
		default:
			System.out.println("노년");
			// default 다음엔 굳이 break를 안 적어도 됨.
		}
	}

}
