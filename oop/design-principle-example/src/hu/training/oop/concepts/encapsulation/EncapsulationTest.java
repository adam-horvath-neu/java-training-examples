package hu.training.oop.concepts.encapsulation;

///**
//* Encapsulation = Data hiding mechanism.
//*
//* The process of binding or wrapping the data and the codes that operates on the data into a single entity. This keeps the data safe from 
//* outside interface and misuse. One way to think about encapsulation is as a protective wrapper that prevents code and data from being arbitrarily 
//* accessed by other code defined outside the wrapper. 
//* For example - if a field is declared private, it cannot be accessed by anyone outside the class, thereby hiding the fields within the class. 
//*/

//---------------------------------------
//--- STEP 01 - UNDERSTAND ENCAPSULATION BY EXAMPLE
//---------------------------------------

public class EncapsulationTest {

	public static void main(String[] args) {
		ComputerPart computerPart = new ComputerPart();
		computerPart.setName("Asus H110M-k s1151");
		/*
		 * Note: As id and name are encapsulated in ComputerPart class, those
		 * cannot be accessed directly here. Also there is no way to assign id
		 * in this class. Try to uncomment below code and you would find compile
		 * time error.
		 */
		// computerPart.id = "123";
		// computerPart.name = "this will give compile time error";
		// computerPart.printID(); // You can't access this method, as it is
		// private to ComputerPart

		System.out.println("ComputerPart - " + computerPart.getId() + " : " + computerPart.getName());
	}

}
