package hu.training.design.patterns.behavioral.strategy;

/**
 * A concrete implementation of payment strategy algorithm for payment by credit card
 * 
 * @author Janos Pelsoczi
 * 
 */
public class PayByCreditCard implements PaymentStrategy {

	@Override
	public void pay(int amount) {
		System.out.println("Amount paid by credit card = " + amount);
	}

}
