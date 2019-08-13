/*
 * 클래스의 생성자 constructor
 */

package chapter05;

public class A02_useClass {

	public static void main(String[] args) {
		/*
		Student st1 = new Student();
		Student st2 = new Student("콩이");
		Student st3 = new Student(1, "박하", 4, "컴퓨터과", "상당구");
		
		st1.study();
		st2.study();
		st3.study();
		st3.showInfo();
		 */
		
		/*
		Student st1 = new Student();
		st1.setname("홍길동");	// setname이라는 메소드를 통해 이름 변경
		System.out.println(st1.getname());	// getname이라는 메소드를 통해 이름 변경
		
		st1.showInfo();	// setname
		*/
		
		InfoHiding info = new InfoHiding();
		info.setId(1);
		System.out.println(info.getId());
	}

}
