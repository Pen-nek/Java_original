package chapter08;

public class GoldCustomer extends Customer {
	double saleRatio;
	
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		customerGrade = "GOLD";
		bonusRatio = 0.02;
		saleRatio = 0.1;
	}
	
	@Override
	public int calcPrice(int price) {
		int i = super.getBonusPoint();
		i += price * bonusRatio;
		super.setBonusPoint(i);
		return price - (int)(price * saleRatio);
	}
}
