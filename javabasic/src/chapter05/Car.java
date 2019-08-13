package chapter05;

public class Car {
	// ## 멤버변수 = 필드 = 속성
	private String color="하얀색";	// 만들어질 때의 기본값을 설정
	private String engine="가솔린";
	private String inner="가죽";
	private int speed;
	
	// 다형성 - 
	public Car() {
		// 기본 생성자
		this("검정색", "디젤", "패브릭");
	}
	
	public Car(String pcolor) {
		// 컬러값을 받는 생성자
		color = pcolor;
	}
	
	public Car(String Color, String Engine, String Inner) {
		this.color = Color;	// this : 뜻은 '이 객체(인스턴스)의'
		this.engine = Engine;
		this.inner = Inner;
	}
	
	Car returnItself() {
		return this;	// 이 클래스로부터 생성된 해당 객체의 시작 주소값을 리턴한다
	}
	
	// ## 멤버메서드 = 메서드 = (함수)
	// 속도를 증가시키는 메서드
	public void upSpeed(int value) {			// 접근제어자 리턴값의타입 메서드이름(패러미터)
		if(speed + value > 300)	speed = 300;	// if 구문의 결과값이 한 줄이라면 {}를 빼도 됨.
		else speed += value;
		
	}// end of upSpeed()
	
	// 속도를 감소시키는 메서드
	public void downSpeed(int value) {
		if(speed - value <= 0)	speed = 0;
		else speed -= value;
	}//end of downSpeed()
	
	public void showInfo() {
		System.out.println("컬러 : " + color + ", 엔진 : " + engine + ", 내부 재료 : " + inner + ", 현재 속도 : " + speed);
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the engine
	 */
	public String getEngine() {
		return engine;
	}

	/**
	 * @param engine the engine to set
	 */
	public void setEngine(String engine) {
		this.engine = engine;
	}

	/**
	 * @return the inner
	 */
	public String getInner() {
		return inner;
	}

	/**
	 * @param inner the inner to set
	 */
	public void setInner(String inner) {
		this.inner = inner;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
}// end of class Car