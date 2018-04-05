package hu.training.oop.design.principles.clazz.solid.ocp.drawing.good;

/**
 * Implementation of drawing circle
 * 
 * @author Janos Pelsoczi
 * 
 */
public class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Drawing circle");
	}
}