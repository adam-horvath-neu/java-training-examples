package hu.training.design.patterns.creational.abstractfactory;

abstract class AbstractFactory {
	public abstract Bank getBank(BankType bank);

	public abstract Loan getLoan(LoanType loan);
}
