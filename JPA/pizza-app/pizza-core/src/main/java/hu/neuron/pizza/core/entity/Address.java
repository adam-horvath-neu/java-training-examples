package hu.neuron.pizza.core.entity;

import javax.persistence.Entity;

@Entity
public class Address extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String zip;

	private String settlement;

	private String addressDetails;

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getSettlement() {
		return settlement;
	}

	public void setSettlement(String settlement) {
		this.settlement = settlement;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}

}
