package hu.training.design.patterns.structural.decorator;

/**
 * This is abstract class for decorators. It extends Beverage, because we need
 * to be interchangeable with a Beverage.
 * 
 * @author Janos Pelsoczi
 * 
 */
public abstract class CondimentDecorator extends Beverage {

	// enforce to implement getDescription method in the condiments sub classes
	public abstract String getDescription();

}
