package chapter02;

import java.util.Scanner;

public class EX02_RecArea {

	public static void main(String[] args) {
		
		// 2. 가로 세로의 길이를 입력받아 사각형의 넓이를 계산해 출력하시오.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("사각형의 가로 길이 : ");
		int wid = sc.nextInt();
		System.out.println("사각형의 세로 길이 : ");
		int hei = sc.nextInt();
		
		System.out.println("사각형의 넓이는 " + wid*hei + "입니다.");
	}

}
