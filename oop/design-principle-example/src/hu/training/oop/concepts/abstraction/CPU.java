package hu.training.oop.concepts.abstraction;

public class CPU extends ComputerPart {

	private String speed;

	public CPU(String _type, String _name, int _price, String _speed) {
		super(_type, _name, _price);
		speed = _speed;
	}

	@Override
	public String info() {
		return this.getClass().getSimpleName() + ":" + super.info() + ":" + speed;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

}
