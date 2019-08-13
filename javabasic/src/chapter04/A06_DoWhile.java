/*
 * do {
 * 		반복실행할 문장
 * } while (조건식); 
 */

package chapter04;

public class A06_DoWhile {

	public static void main(String[] args) {
		int num = 1;
		do {
			System.out.println(num);
			num++;
		}while(num <= 5);
		System.out.println("program end....");
	}

}
