package hu.training.dog;

import java.io.Serializable;

public class Dog implements Serializable, Comparable<Dog> {

	private static final long serialVersionUID = 5961278352774610663L;
	
	private String name;
	private String color;
	private Type type;

	public Dog(String name, String color, Type type) {
		super();
		this.name = name;
		this.color = color;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public enum Type {
		GERMAN_SHEPHARD, GOLDER_RETRIEVER, VIZSLA
	}

	@Override
	public int compareTo(Dog o) {
		return this.name.compareTo(o.name);
	}

}
