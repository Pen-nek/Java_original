package chapter07;

public class TwoDimension {

	public static void main(String[] args) {
		// 2차원 배열 선언
		// int[][] arr = new int[2][3]; => 2행 3열
		int[][] arr = {{1, 2, 3}, {4, 5, 6}};
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {	// arr[i].length : arr라는 다차원배열에서 i열의 길이를 가져옴
				System.out.printf("%3d", arr[i][j]);
			}// inner loop by j
			System.out.println();
		}// outer loop by i
	}

}
