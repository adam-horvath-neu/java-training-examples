package hu.training.oop.design.principles.clazz.solid.ocp.drawing.good;

/**
 * OCP is followed, as to extend functionality this class does not require to
 * change
 * 
 * @author Janos Pelsoczi
 * 
 */
public class GraphicEditor {

	public void drawShape(Shape s) {
		s.draw();
	}
}
