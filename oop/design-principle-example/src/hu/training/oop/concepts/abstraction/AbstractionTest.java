package hu.training.oop.concepts.abstraction;


///** 
//* Abstraction = Looking only at the information that is relevant at the time. 
//*
//* Abstraction is the process or result of generalization by reducing the information content of a concept or an observable phenomenon, 
//* typically in order to retain only information which is relevant for a particular purpose. It is starting point of design.
//* Functional abstraction - means that a function can be used without taking into account how the function is implemented. 
//* Data Abstraction - means that data can be used without taking into account how the data are stored.
//*/

public class AbstractionTest {

	public static void main(String[] args) {
		/* Following is not allowed and would raise error */
		// ComputerPart e = new ComputerPart("Part", "PartName", 1000);
		
		ComputerPart motherBoard1 = new MotherBoard("ASUS", "H110M-K", 21000, "s1151");
		ComputerPart vga1 = new VGA("Sapphire", "HD7950", 55000, "3GB");
		ComputerPart cpu1 = new CPU("Intel", "i3 6300", 37000, "3.8 Ghz");

		MotherBoard motherBoard2 = new MotherBoard("ASUS", "H110M-K", 21000, "s1151");
		VGA vga2 = new VGA("Sapphire", "HD7950", 55000, "3GB");
		CPU cpu2 = new CPU("Intel", "i3 6300", 37000, "3.8 Ghz");
				
		System.out.println(motherBoard1.info());
		System.out.println(vga1.info());
		System.out.println(cpu1.info());

		System.out.println(motherBoard2.info());
		System.out.println(vga2.info());
		System.out.println(cpu2.info());
		
	}

}
