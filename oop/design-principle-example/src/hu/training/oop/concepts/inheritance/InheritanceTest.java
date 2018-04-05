package hu.training.oop.concepts.inheritance;

import hu.training.oop.concepts.inheritance.characters.Barbarian;
import hu.training.oop.concepts.inheritance.characters.Crusader;
import hu.training.oop.concepts.inheritance.characters.DemonHunter;
import hu.training.oop.concepts.inheritance.characters.Monk;
import hu.training.oop.concepts.inheritance.characters.WitchDoctor;
import hu.training.oop.concepts.inheritance.characters.Wizard;

//---------------------------------------
//--- STEP 00 - WHAT IS INHERITANCE? 
//---------------------------------------

///**
//* Inheritance = is-a relationship between a superclass and its subclasses. 
//*
//* For example, Dog (subclass) is-a of type Animal (superclass). So Dog can inherit (reuse) members of Animal class; 
//* plus it can have its own new behavior and properties.  
//*/

//---------------------------------------
//--- STEP 01 - UNDERSTAND INHERITANCE BY EXAMPLE
//---------------------------------------

public class InheritanceTest {

	public static void main(String[] args) {

		Barbarian barbarian = new Barbarian();
		barbarian.setId(1); // inherited from super class
		barbarian.setName("Drogo"); // inherited from super class
		//System.out.println(barbarian.characterSkills()); // overrided behavior
															// of super class
		System.out.println(barbarian.info()); // overrided behavior of super
												// class

		Crusader crusader = new Crusader();
		crusader.setId(2); // inherited from super class
		crusader.setName("Paladin"); // inherited from super class
		//System.out.println(crusader.characterSkills()); // overrided behavior of
														// super class
		System.out.println(crusader.info()); // overrided behavior of super
												// class

		DemonHunter demonHunter = new DemonHunter();
		demonHunter.setId(3); // inherited from super class
		demonHunter.setName("Green Arrow"); // inherited from super class
		//System.out.println(demonHunter.characterSkills()); // overrided behavior
															// of super class
		System.out.println(demonHunter.info()); // overrided behavior of super
												// class

		Monk monk = new Monk();
		monk.setId(4); // inherited from super class
		monk.setName("Monk"); // inherited from super class
		//System.out.println(monk.characterSkills()); // overrided behavior of
													// super class
		System.out.println(monk.info()); // overrided behavior of super class

		WitchDoctor witchDoctor = new WitchDoctor();
		witchDoctor.setId(5); // inherited from super class
		witchDoctor.setName("Necro"); // inherited from super class
		//System.out.println(witchDoctor.characterSkills()); // overrided behavior
															// of super class
		System.out.println(witchDoctor.info()); // overrided behavior of super
												// class

		Wizard wizard = new Wizard();
		wizard.setId(6); // inherited from super class
		wizard.setName("Potter"); // inherited from super class
		//System.out.println(wizard.characterSkills()); // overrided behavior of
														// super class
		System.out.println(wizard.info()); // overrided behavior of super class

	}

}
