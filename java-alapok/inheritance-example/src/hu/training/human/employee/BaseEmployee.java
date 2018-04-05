package hu.training.human.employee;

import hu.training.human.BaseHuman;

public class BaseEmployee extends BaseHuman {
	
	protected String taxNumber;

	public BaseEmployee(String name, int age, Gender gender) {
		super(name, age, gender);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void eat(String food) {
		// TODO Auto-generated method stub

	}

	@Override
	public String speak(String thought) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long move(long numberOfSteps) {
		// TODO Auto-generated method stub
		return 0;
	}

}
