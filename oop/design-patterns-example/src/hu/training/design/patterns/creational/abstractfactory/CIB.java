package hu.training.design.patterns.creational.abstractfactory;

public class CIB implements Bank {
	
	private String name;

	public CIB() {
		this.name = "CIB";
	}

	@Override
	public String getBankName() {
		return this.name;
	}

}
