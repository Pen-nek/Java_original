package chapter08;

public class OverridingTest1 {

	public static void main(String[] args) {
		Customer customerLee = new Customer(10010, "이순신");
		customerLee.setBonusPoint(10000);
		
		VIPCustomer customerKim = new VIPCustomer(10020, "김유신", 12345);
		customerKim.setBonusPoint(10000);
		
		int price = 10000;
		System.out.println(customerLee.getCustomerName() + " 님이 지불해야 하는 금액은 " + customerLee.calcPrice(price) + "원입니다.");
		System.out.println(customerKim.getCustomerName() + " 님이 지불해야 하는 금액은 " + customerKim.calcPrice(price) + "원입니다.");

		// 보너스포인트가 적립율에 맞게 적립되는지 확인
		System.out.println(customerLee.getBonusPoint());
		System.out.println(customerKim.getBonusPoint());
	}

}
