package chapter04;

import java.util.Scanner;

public class A05_WhileStmt {

	public static void main(String[] args) {
		// 1~10까지의 합계를 구하는 프로그램을 while문을 이용해 작성
		// 
		/*int num = 1;
		
		
		 * System.out.println(num); num++; System.out.println(num); num++;
		 * System.out.println(num); num++; System.out.println(num); num++;
		 * System.out.println(num);
		 */
		
		// 위 프로그램을 반복문을 사용해 작성
//		int num = 1;
//		while(num<=10000) {
//			System.out.println(num);
//			num++;
			
		// 1~100 숫자 중에 홀수는 홀끼리 짝수는 짝끼리 더하기
//		int num=1, sum1=0, sum2=0;
//		
//		while (num<=100) {
//			if (num%2==1) {sum1 += num;}
//			else {sum2 += num;}
//			num++;
//		} // end of while
//		System.out.println("홀수의 합 : " + sum1);
//		System.out.println("짝수의 합 : " + sum2);
		
		// 시작 숫자, 끝 숫자를 유저에게서 받아서 그 안의 모든 숫자를 더해 출력하기
		int num, start, end, sum=0;
		
		Scanner kbd = new Scanner(System.in);
		
		System.out.println("시작하는 숫자 입력 : ");
		start = kbd.nextInt();
		System.out.println("끝나는 숫자 입력 : ");
		end = kbd.nextInt();
		
		num = start; // sum에 더할 숫자
		
		while(num<=end) {
			sum += num;
			num++;
		}
		
		// 시작 수와 끝 수 사이에서 3과 5의 공배수를 찾아 출력
//			if (((num % 3) == 0) && ((num % 5) == 0))System.out.println(num);
//			num++;
		
		System.out.println(start + "부터 " + end + "까지 더한 값 : " + sum);
			
	} // end of main
}

