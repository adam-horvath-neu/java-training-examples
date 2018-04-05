package hu.training.oop.concepts.polymorphism;

public class CreditCardPayment implements Payment {

	@Override
	public void pay() {
		System.out.println("This is credit card payment");
	}

}
