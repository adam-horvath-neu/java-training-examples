package hu.training.oop.concepts.abstraction;

public class MotherBoard extends ComputerPart {

	private String socket;

	public MotherBoard(String _type, String _name, int _price, String _socket) {
		super(_type, _name, _price);
		socket = _socket;
	}

	@Override
	public String info() {
		return this.getClass().getSimpleName() + ":" + super.info() + ":" + socket;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

}
