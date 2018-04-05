package hu.training.oop.concepts.inheritance.characters;

import hu.training.oop.concepts.inheritance.Character;

/**
 * Test class for inheritance behavior - Concrete class is inheriting behavior
 * and properties of Character class and can have its own too.
 * 
 * @author Janos Pelsoczi
 * 
 */

public class Barbarian extends Character {

	private String[] listSkills() {
		String[] skills = new String[5];
		skills[0] = "Whirlwind";
		skills[1] = "Rend";
		skills[2] = "Earthquake";
		skills[3] = "Ground Stomp";
		skills[4] = "Bash";
		return skills;
	}

	@Override
	public String[] characterSkills() {
		return listSkills();
	}

	@Override
	public String info() {
		String[] skills = listSkills();
		return getId() + ":" + getName() + ":" + skills[0] + "," + skills[1] + "," + skills[2] + "," + skills[3] + "," + skills[4];
	}

}
