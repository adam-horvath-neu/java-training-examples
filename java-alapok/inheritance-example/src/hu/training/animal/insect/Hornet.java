package hu.training.animal.insect;

import hu.training.animal.Flyable;

public class Hornet extends BaseInsect implements Flyable {
	
	

	@Override
	public void eat() {
		System.out.println("");
	}

	@Override
	public Hornet reproduce() {
		return new Hornet();
	}

	@Override
	public long fly() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void bite() {
		// TODO Auto-generated method stub
		super.bite();
	}

}
