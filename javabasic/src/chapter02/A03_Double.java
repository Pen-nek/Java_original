package chapter02;

public class A03_Double {

   public static void main(String[] args) {
      double dnum = 3.14;
      float fnum = 3.14f; //값 뒤에 f 를 붙여줘야함//
      /* java에서 실수형은 기본적으로 double 으로 지정. 
       * float은 지정값 뒤에 f 를 붙여줘야지 float 타입으로 인식함 */
      System.out.println(dnum);
      System.out.println(fnum);
      
      
      // 실수를 부동소수점으로 표현하면 생기는 문제
      double dval = 1;
      System.out.println(dval);
      
      for (int i = 0; i < 10000; i++) {
    	  dval = dval + 0.1;
      }
      // 답은 1001이어야 하는데 오류가 생김
      
      System.out.println(dval);
      
      
	}

}
