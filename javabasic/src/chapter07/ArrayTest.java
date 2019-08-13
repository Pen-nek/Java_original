package chapter07;

public class ArrayTest {

	public static void main(String[] args) {
		
		// 배열 선언 방법
		// 1. 자료형[] 배열이름 = new 자료형[개수(길이)];
		// 	ex) int[] studentIDs = new int[10];
		// 2. 자료형 배열이름[] = new 자료형[개수];
		
		int studentIDs[] = new int[] {10,9,8,7,6,5,4,3,2,1};	// 길이를 정해주지 않고 초기값만 넣어주면, 값의 개수에 따라 길이가 정해짐.
		
//		for(int i=0, num=10;   i<10;   i++, num--) {
//			studentIDs[i] = num;
//		}
		
		for(int i=0; i<studentIDs.length; i++) {
			System.out.printf("%3d", studentIDs[i]);
		}
	}
}
