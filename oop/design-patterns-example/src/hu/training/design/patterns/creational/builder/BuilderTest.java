package hu.training.design.patterns.creational.builder;

public class BuilderTest {

	public static void main(String[] args) {
		User user = new User.UserBuilder("Bela", "Kiss").age(30).address("Debrecen, Fõ út 1.").build();
		System.out.println(user);
	}

}
