package chapter03;

public class A07_BitOperator {

	public static void main(String[] args) {
//		// 10진수 출력 가능
//		double num = 10.123;
//		System.out.println("10진수 : " + num10);
//		
//		// 숫자 2진수 출력 가능
//		// 표기법 : 0b + 숫자
//		int num2 = 0b101;
//		System.out.println("2진수 : " + num2);
//		
//		// 숫자 8진수 출력 가능
//		// 표기법 : 0 + 숫자
//		int num8 = 012;
//		System.out.println("8진수 : " + num8);
//		
//		// 숫자 16진수 출력 가능
//		// 표기법 : 0x + 숫자 또는 영문
//		int num16 = 0xA;
//		System.out.println("16진수 : " + num16);
//		
		// 10진수 숫자를 16진수 형태로 출력
//		System.out.printf("%010.2f", num);
		
//		byte num1 = 0b00001101;
//		byte num2 = 0b00001010;
		
//		int result = num1 & num2; // &(AND) 두 비트값이 모두 1일 때 결과도 1
//		int result = num1 | num2; // |(OR) 두 비트값 중 하나라도 1일 때 결과도 1
//		int result = num1 ^ num2; // ^(헥트) 같은 값이면 0, 다른 값이면 1
//		int result = ~num1; // ~(반전,틸드) 0은 1로, 1은 0으로 반전
//		System.out.println(result);
		
		int num3 = 10;
		int result = num3 >> 3;
		
		System.out.println(result);
		
		
	}

}
