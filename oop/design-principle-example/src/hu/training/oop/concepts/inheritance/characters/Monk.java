package hu.training.oop.concepts.inheritance.characters;

import hu.training.oop.concepts.inheritance.Character;

public class Monk extends Character {

	private String[] listSkills() {
		String[] skills = new String[5];
		skills[0] = "Epiphany";
		skills[1] = "Cyclone Strike";
		skills[2] = "Wave of Light";
		skills[3] = "Seven Sided Strike";
		skills[4] = "Exploding Palm";
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
