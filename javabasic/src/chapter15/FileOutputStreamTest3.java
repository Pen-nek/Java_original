package chapter15;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest3 {

	public static void main(String[] args) {
		 
		try(FileOutputStream fos = new FileOutputStream("c:/Users/USER/Desktop/output3.txt"))
		{
		
			byte[] bs = new byte[26];
			byte data = 65;     //'A'의 유니코드
			for(int i = 0; i < bs.length; i++){  // A-Z ���� �迭�� �ֱ�
				bs[i] = data;
				data++;
			}
			fos.write(bs, 2, 10);   // bs배열의 2번째 인덱스부터 10개 바이트 자료만 출력
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력이 완료되었습니다.");
	}
}
