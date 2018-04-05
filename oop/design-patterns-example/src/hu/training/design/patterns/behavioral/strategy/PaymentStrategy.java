package hu.training.design.patterns.behavioral.strategy;

/**
 * The interface to specify the signature of an algorithm (i.e. a behavior) for the Payment Strategy
 * 
 * @author Janos Pelsoczi
 * 
 */
public interface PaymentStrategy {

	public void pay(int amount);

}
