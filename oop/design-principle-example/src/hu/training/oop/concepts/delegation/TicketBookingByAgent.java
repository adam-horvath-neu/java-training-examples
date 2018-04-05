package hu.training.oop.concepts.delegation;

/**
 * TicketBokkingByAgent provides implementation of TravelBooking. But it
 * delegates actual ticket booking to other class at runtime using Polymorphism.
 * 
 * @author Janos Pelsoczi
 * 
 */
class TicketBookingByAgent implements TravelBooking {

	TravelBooking t;

	public TicketBookingByAgent(TravelBooking t) {
		this.t = t;
	}

	// Delegation --- Here ticket booking responsibility is delegated to other
	// class using polymorphism
	@Override
	public void bookTicket() {
		t.bookTicket();
	}
}
