package afor255.ms.test.invoice.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="invoice")
public class Invoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_invoice;
	private double amount;
	private Integer state;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", insertable = false, updatable = false)
	@Fetch(FetchMode.JOIN)
	private Customer customer;

	public Integer getId_invoice() {
		return id_invoice;
	}

	public void setId_invoice(Integer id_invoice) {
		this.id_invoice = id_invoice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
