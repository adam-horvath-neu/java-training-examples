package hu.training.design.patterns.creational.abstractfactory;

class BankFactory extends AbstractFactory {
	
	public Bank getBank(BankType bank) {
		if (bank == null) {
			return null;
		}
		switch (bank) {
		case OTP:
			return new OTP();
		case ERSTE:
			return new Erste();
		case CIB:
			return new CIB();
		default:
			return null;
		}
	}

	public Loan getLoan(LoanType loan) {
		return null;
	}
}
