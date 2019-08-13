// 교재 221p 나혼자코딩 : 알파벳 소문자를 2글자씩 13줄로 출력하는 프로그램을 이차원 배열로 구현

package chapter07;

public class SmallAlphabet {

	public static void main(String[] args) {
		char[][] arr = new char[13][2];
		int ch=97;
		
		// for문으로 배열에 아스키코드 넣기
		for(int i=0; i<13; i++) {
			for(int j=0; j<2; j++) {
				arr[i][j] = (char)ch;
				ch++;
			}
		}
		
		// for문으로 배열에서 알파벳 출력
		for(int i=0; i<13; i++) {
			for(int j=0; j<2; j++) {
				System.out.printf("%2c", arr[i][j]);
			}// inner loop by j
			System.out.println();
		}// 
	}// main()

}// class
