package hu.training.oop.concepts.inheritance.characters;

import hu.training.oop.concepts.inheritance.Character;

public class DemonHunter extends Character {

	private String[] listSkills() {
		String[] skills = new String[5];
		skills[0] = "Vengeance";
		skills[1] = "Multishot";
		skills[2] = "Strafe";
		skills[3] = "Cluster Arrow";
		skills[4] = "Spike Trap";
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
