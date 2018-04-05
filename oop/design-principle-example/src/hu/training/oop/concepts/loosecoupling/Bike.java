package hu.training.oop.concepts.loosecoupling;

public class Bike implements Vehicle {
	@Override
	public void move() {
		System.out.println("Bike is moving");
	}
}