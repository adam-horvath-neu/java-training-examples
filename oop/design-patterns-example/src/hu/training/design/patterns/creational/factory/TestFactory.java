package hu.training.design.patterns.creational.factory;

public class TestFactory {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();
		Shape circle = factory.getShape(Shapes.CIRCLE);
		Shape rectangle = factory.getShape(Shapes.RECTANGLE);
		Shape square = factory.getShape(Shapes.SQUARE);
		
		circle.draw();
		rectangle.draw();
		square.draw();
	}

}
