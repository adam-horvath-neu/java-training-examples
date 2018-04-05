package hu.training.oop.concepts.loosecoupling;

/**
 * This is example of loose coupling. In this class, it is not tightly coupled
 * with Car or Bike implementation. Instead by applying dependency injection
 * mechanism, the loose coupling implementation is achieved to allow start
 * journey with any class which has implemented Vehicle interface.
 * 
 * @author Janos Pelsoczi
 * 
 */
public class GoodTraveler {
	
	private Vehicle v;

	public Vehicle getV() {
		return v;
	}

	public void setV(Vehicle v) {
		this.v = v;
	}

	public void startJourney() {
		v.move();
	}
}
