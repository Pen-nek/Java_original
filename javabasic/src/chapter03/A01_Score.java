package chapter03;

import java.util.Scanner;

public class A01_Score {

	public static void main(String[] args) {
		
		// Scanner 클래스 불러오기
		Scanner sc = new Scanner(System.in);
		
		// 필요한 변수 선언
		String name;
		int kor, eng, math, total;
		double avg;
		
		// 계산에 필요한 값 입력 받기
		System.out.println("이름을 입력하세요. : ");
		name = sc.next();
		System.out.println("국어 점수를 입력하세요. : ");
		kor = sc.nextInt();
		System.out.println("영어 점수를 입력하세요. : ");
		eng = sc.nextInt();
		System.out.println("수학 점수를 입력하세요. : ");
		math = sc.nextInt();
		
		// 계산
		total = kor + eng + math;
		avg = (double)total / 3;
		
		// 계산된 총점과 평균 출력
		System.out.println("이름 " + name + ", 총점은 " + total + "점이고 평균은 " + avg + "점입니다.");
		
	}

}
