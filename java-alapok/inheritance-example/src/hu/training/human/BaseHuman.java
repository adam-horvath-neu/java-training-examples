package hu.training.human;

public abstract class BaseHuman implements Human {
	protected String name;
	protected int age;
	protected Gender gender;
	protected int weight;
	protected int height;
	

	public BaseHuman(String name, int age, Gender gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.weight = Gender.MALE == gender ? 75 : 55;
		this.height = Gender.MALE == gender ? 175 : 160;
	}

	public BaseHuman(String name, int age, int weight, int height) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public static enum Gender {
		MALE, FEMALE
	}

}
