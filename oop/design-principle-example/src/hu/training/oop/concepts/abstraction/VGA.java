package hu.training.oop.concepts.abstraction;

public class VGA extends ComputerPart {

	private String memorySize;

	public VGA(String _type, String _name, int _price, String _memorySize) {
		super(_type, _name, _price);
		memorySize = _memorySize;
	}

	@Override
	public String info() {
		return this.getClass().getSimpleName() + ":" + super.info() + ":" + memorySize;
	}

	public String getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}

}
