package hu.training.design.patterns.structural.decorator;

/**
 * Rea Tea is-a type of beverage.
 *
 * @author Janos Pelsoczi
 *
 */
public class RedTea extends Beverage {

	public RedTea() {
		description = "Red Tea";
	}

	public double cost() {
		return 5.00;
	}
}
