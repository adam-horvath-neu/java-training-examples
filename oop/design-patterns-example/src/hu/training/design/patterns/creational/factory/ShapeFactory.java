package hu.training.design.patterns.creational.factory;

public class ShapeFactory {

	Shape getShape(Shapes shape) {
		switch (shape) {
		case CIRCLE:
			return new Circle();
		case RECTANGLE:
			return new Rectangle();
		case SQUARE:
			return new Square();
		default:
			throw new IllegalArgumentException();
		}
	}

}
