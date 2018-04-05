package hu.training.oop.concepts.loosecoupling;

/**
 * This is example of tight coupling. Here to start journey, the BadTraveler
 * class is creating Car object to interact with it using move() method. Hence
 * both are tightly coupled. Now if there is a need to change journey from Car
 * to Bike, then it requires to do changes in BadTraveler class (i.e. replace
 * Car object with Bike object). Hence tight coupling should be avoided.
 * 
 * @author Janos Pelsoczi
 * 
 */
public class BadTraveler {

	Car c = new Car();

	public void startJourney() {
		c.move();
	}
}