package hu.training.design.patterns.creational.abstractfactory;

public class OTP implements Bank {
	
	private String name;

	public OTP() {
		this.name = "OTP";
	}

	@Override
	public String getBankName() {
		return this.name;
	}

}
