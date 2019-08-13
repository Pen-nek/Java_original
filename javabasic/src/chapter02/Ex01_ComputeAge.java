package chapter02;

import java.util.Scanner;

public class Ex01_ComputeAge {

	public static void main(String[] args) {
		
		// 1. 이름과 생년을 입력받아 ~님, 나이는 ~세입니다. 를 출력하시오.
		Scanner sc = new Scanner(System.in);

		System.out.println("이름을 입력해주세요 : ");
		String name = sc.next();
		System.out.println("나이를 입력해주세요 : ");
		int age = sc.nextInt();
		System.out.println(name + "님, 나이는 " + age + "세입니다.");
		
	}

}
