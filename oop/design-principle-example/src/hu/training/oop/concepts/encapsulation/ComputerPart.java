package hu.training.oop.concepts.encapsulation;

import java.util.Random;


/**
 * 
 * Encapsulation goals of ComputerPart class
 * 
 * (1) The id and name parameters should not be accessible directly outside ComputerPart class - achieved by private declaration
 * 
 * (2) The id value can be assigned in ComputerPart class only and other class should not be able to change - not included setId() method
 * 
 * @author Janos Pelsoczi
 * 
 */
public class ComputerPart {

	private int id;
	private String name;
	
	public ComputerPart(){
		id = new Random().nextInt((100 - 1) + 1) + 1;
		printID();
	}
	
	private void printID(){
		System.out.println("Generated ID : " + getId());
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
