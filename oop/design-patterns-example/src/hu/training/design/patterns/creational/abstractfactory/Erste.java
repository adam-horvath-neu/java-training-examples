package hu.training.design.patterns.creational.abstractfactory;

public class Erste implements Bank {
	
	private String name;

	public Erste() {
		this.name = "Erste";
	}

	@Override
	public String getBankName() {
		return this.name;
	}

}
