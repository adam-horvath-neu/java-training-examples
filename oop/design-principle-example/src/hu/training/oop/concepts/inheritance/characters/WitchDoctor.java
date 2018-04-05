package hu.training.oop.concepts.inheritance.characters;

import hu.training.oop.concepts.inheritance.Character;

public class WitchDoctor extends Character {

	private String[] listSkills() {
		String[] skills = new String[5];
		skills[0] = "Locust Swarm";
		skills[1] = "Pestilence";
		skills[2] = "Haunt";
		skills[3] = "Spirit Walk";
		skills[4] = "Wall of Death";
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
