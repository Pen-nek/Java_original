//		A04_SwitchCase
//		조건이 많아질 경우 if~else if 구문은 불편
//		조건식의 결과가 정수 또는 문자열이고 그렇게 수행되는 경우 깔끔한 표현 가능
//		switch(값){
//		case 값1: 수행문1;
//				  break;
//		case 값2: 수행문2;
//				  break;
//			 
//		case 값n: 수행문n;
//				  break;
//		default: 수행문d;
//		}

package chapter04;

import java.util.Scanner;

public class A04_SwitchCase {

	public static void main(String[] args) {
	
		//switch문 사용해 홀짝 구분 해보기
		int num1 = 6;
		int remainder;
		remainder = num1 % 2;
		
		switch(remainder) {
			case 0:
				System.out.println("짝수 Even Number");
				break;
			case 1:
				System.out.println("홀수 Odd Number");
				break;
			default:
				break;
		}
		

		
		
		
		
	}

}
