package hu.training.oop.concepts.polymorphism;

public class CashPayment implements Payment {

	@Override
	public void pay() {
		System.out.println("This is cash payment");
	}

}
