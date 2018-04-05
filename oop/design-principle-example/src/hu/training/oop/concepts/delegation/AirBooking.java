package hu.training.oop.concepts.delegation;

public class AirBooking implements TravelBooking {

	@Override
	public void bookTicket() {
		System.out.println("Flight ticket booked");
	}

}
