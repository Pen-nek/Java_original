package chapter08;

public class Sedan1 extends Car1 {
	// field(속성)인 speed와 color가 슈퍼클래스에서 상속됨
	
//	public void setSpeed(int speed) {
//		super.speed = speed;
//	}
	
	public void setColor(String color) {
		super.setColor(color);
	}
	
	public String getColor() {
		return super.getColor();
	}
}
