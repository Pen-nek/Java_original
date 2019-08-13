package chapter04;

public class A07_ForStmt {

	public static void main(String[] args) {

		// num을 1부터 5까지 하나씩 증가시키면서 출력하는 while문
//		int num = 1;
//		while(num<=5) { 
//			System.out.println(num); num++;
//		}
		
//		// num을 5부터 1까지 하나씩 감소시키면서 출력하는 for반복문
//		
//		int num;
//		for(num=5; num>=1; num--) {
//			System.out.println(num);
//		}
		
		// 구구단 출력 : 중첩된 while 반복문 (nested while loop)
//		int i=1, j=1;
//		while(i <= 9) {
//			System.out.println(i + "dan");
//			j = 1;
//			while(j <= 9) {
//				System.out.println(i + "*" + j + "=" + i*j);
//				j++;
//			} // inner while
//			i++;
//			System.out.println();
//		} // outer while
//		System.out.println("Program terminated");
		
		// 구구단 출력 : 중첩된 for 반복문
//		int i=1, j=1;
//		for(i=1; i<=9; i++) {
//			System.out.println(i + "dan");
//			for(j=1; j<=9; j++) {
//				System.out.println(i + "*" + j + "=" + i*j);
//			}
//			System.out.println();
//		}

		for(int i=1; i<=10; i++) {
			if(i==8) break;
			if((i%2) == 0) continue;
			System.out.println(i);
		}
		System.out.println("terminated");

	} // end of main

}
