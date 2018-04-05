package hu.training.oop.concepts.abstraction;

public abstract class ComputerPart {

	private String type;
	private String name;
	private int price;

	public ComputerPart(String _type, String _name, int _price) {
		type = _type;
		name = _name;
		price = _price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String info(){
		return type + ":" + name + ":" + price;
	};

}
