package hu.training.oop.design.principles.clazz.solid.ocp.drawing.good;

/**
 * Implementation of drawing editor
 * 
 * @author Janos Pelsoczi
 * 
 */
public class GraphicEditorTestDrive {

	public static void main(String[] args) {
		GraphicEditor ge = new GraphicEditor();

		Shape s = new Rectangle();
		ge.drawShape(s);

		s = new Circle();
		ge.drawShape(s);
	}

}
