package hu.training.oop.design.principles.clazz.solid.ocp.drawing.good;

/**
 * Implementation of drawing rectangle
 * 
 * @author Janos Pelsoczi
 * 
 */
public class Rectangle extends Shape {
	@Override
	public void draw() {
		System.out.println("Drawing Rectangle");
	}
}
