package hu.training.oop.concepts.inheritance.characters;

import hu.training.oop.concepts.inheritance.Character;

public class Crusader extends Character {

	private String[] listSkills() {
		String[] skills = new String[5];
		skills[0] = "Punish";
		skills[1] = "Slash";
		skills[2] = "Blessed Shield";
		skills[3] = "Blessed Hammer";
		skills[4] = "Judgement";
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
