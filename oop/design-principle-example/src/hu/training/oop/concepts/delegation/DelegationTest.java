package hu.training.oop.concepts.delegation;


//---------------------------------------
//--- STEP 00 - WHAT IS DELEGATION? 
//---------------------------------------

///**
//* Delegation = hand over the responsibility for a particular task to another class or method. 
//*
//* If you need to use functionality in another class but you do not want to change that functionality then use delegation instead of inheritance.
//*/

//---------------------------------------
//--- STEP 01 - UNDERSTAND DELEGATION (ALONG WITH POLYMORPHISM) BY EXAMPLE
//---------------------------------------

public class DelegationTest {
	public static void main(String[] args) {
		// Here TicketBookingByAgent class is internally delegating train ticket
		// booking responsibility to other class
		TicketBookingByAgent agent = new TicketBookingByAgent(new TrainBooking());
		agent.bookTicket();

		// Here TicketBookingByAgent class is internally delegating airline
		// ticket booking responsibility to other class
		agent = new TicketBookingByAgent(new AirBooking());
		agent.bookTicket();
	}
}
