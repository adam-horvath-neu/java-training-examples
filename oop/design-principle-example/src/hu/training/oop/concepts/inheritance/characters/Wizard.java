package hu.training.oop.concepts.inheritance.characters;

import hu.training.oop.concepts.inheritance.Character;

public class Wizard extends Character {

	private String[] listSkills() {
		String[] skills = new String[5];
		skills[0] = "Meteor";
		skills[1] = "Blizzard";
		skills[2] = "Arcane Torrent";
		skills[3] = "Spectral Blade";
		skills[4] = "Teleport";
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
