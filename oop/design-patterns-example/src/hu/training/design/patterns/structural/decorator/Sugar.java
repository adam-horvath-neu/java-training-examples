package hu.training.design.patterns.structural.decorator;

/**
 * Sugar is-a type of condiment, which is example of the concrete decorator class.
 *
 * @author Janos Pelsoczi
 *
 */
public class Sugar extends CondimentDecorator {

	// An instance variable to hold the beverage we are wrapping
	Beverage beverage;

	// A way to set this instance variable to the object we are wrapping
	public Sugar(Beverage beverage) {
		this.beverage = beverage;
	}

	// First delegate to the object we are decorating get its description, and then append description for this condiment
	public String getDescription() {
		return beverage.getDescription() + ", Sugar";
	}

	// First we delegate the call to the object we're decorating, so that it can compute the cost, and then add the cost of this condiment to the result
	public double cost() {
		return beverage.cost() + 1.00;
	}
}
