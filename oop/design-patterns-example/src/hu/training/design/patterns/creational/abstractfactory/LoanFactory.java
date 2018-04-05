package hu.training.design.patterns.creational.abstractfactory;

public class LoanFactory extends AbstractFactory {
	public Bank getBank(BankType bank) {
		return null;
	}

	public Loan getLoan(LoanType loan) {
		if (loan == null) {
			return null;
		}
		switch (loan) {
		case HOME:
			return new HomeLoan();
		case BUSINESS:
			return new BusinessLoan();
		case EDUCATION:
			return new EducationLoan();
		default:
			return null;
		}
	}

}