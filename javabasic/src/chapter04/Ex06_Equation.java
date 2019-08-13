/*
 * 문제. 
 * 방정식 4x + 5y = 60의 모든 해를 구하는 프로그램 작성
 * 단 x, y는 10 이하의 자연수로 한정
 * (hint : 다중 for루프 사용)
 *
 * 1. 준비
 * 	- 변수 선언
 *  - 스캐너 온
 *  
 * 2. 계산
 * 	2.1 x가 1부터 10보다 작거나 같은 동안 반복
 * 	 2.1.1 y가 1부터 10보다 작거나 같은 동안 반복
 * 	  2.1.1.1 4x + 5y == 60이면 x, y를 출력 
 *  
 *  조건이 맞을 때 x,y값 출력
 */

package chapter04;

public class Ex06_Equation {

	public static void main(String[] args) {
		
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				if((4*x) + (5*y) == 60) System.out.println("해 x,y : "+ x +","+ y);
			} //inner for(y
		} // outer for(x
		
	}

}
