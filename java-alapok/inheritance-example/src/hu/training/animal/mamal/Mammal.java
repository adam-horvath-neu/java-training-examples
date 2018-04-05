package hu.training.animal.mamal;

import hu.training.animal.Animal;

public interface Mammal extends Animal {

	@Override
	Mammal reproduce();
}
