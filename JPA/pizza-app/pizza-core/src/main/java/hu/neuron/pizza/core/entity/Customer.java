package hu.neuron.pizza.core.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Customer extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String email;

	private String name;

	private String phone;

	@OneToMany(mappedBy = "customer")
	private List<Order> orders;

	@ManyToMany()
	@JoinTable(name = "customer_shipping_address")
	private List<Address> shippingAddresses;

	@ManyToMany
	@JoinTable(name = "customer_invoice_address")
	private List<Address> invoiceAddresses;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Address> getShippingAddresses() {
		return shippingAddresses;
	}

	public void setShippingAddresses(List<Address> shippingAddresses) {
		this.shippingAddresses = shippingAddresses;
	}

	public List<Address> getInvoiceAddresses() {
		return invoiceAddresses;
	}

	public void setInvoiceAddresses(List<Address> invoiceAddresses) {
		this.invoiceAddresses = invoiceAddresses;
	}

}
