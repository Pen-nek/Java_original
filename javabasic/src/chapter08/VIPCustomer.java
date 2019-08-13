package chapter08;

public class VIPCustomer extends Customer {
	private int agentID;
	double saleRatio;
	
	public VIPCustomer() {
		// super();	// 프로그래머가 추가하지 않아도 컴파일러가 자동으로 추가하는 코드. 상위 클래스 Customer()가 호출됨
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
	}
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		super(customerID, customerName);	// 디폴트 생성자가 아닌 ID, 이름이 있는 생성자를 불러오기 위해 적어줌
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
	}
	
	public String showVIPInfo() {
		return super.showCustomerInfo() + " 담당 상담원 아이디는 " + agentID + "입니다.";
	}

	@Override
	public int calcPrice(int price) {
		int i = super.getBonusPoint();
		i += price * bonusRatio;
		super.setBonusPoint(i);
		return price - (int)(price * saleRatio);
	}
	
	public String showCustomerInfo() {
		return super.showCustomerInfo() + " 담당 상담원 번호는 " + agentID + "입니다.";
	}
	
	public int getAgentID() {
		return agentID;
	}
	
}
