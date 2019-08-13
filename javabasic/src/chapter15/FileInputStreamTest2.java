package chapter15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest2 {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("d:/input2.txt");
			int i;
			while((i = fis.read()) != -1) {
				System.out.println((char)i);	// 읽어온 바이트를 문자로 변환하여 출력
			}
			System.out.println("end");
		} catch (FileNotFoundException e) {		// 파일을 찾을 수 없는 오류가 났을 경우
			e.printStackTrace();	// 오류가 발생한 과정을 추적하고 출력해라
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
