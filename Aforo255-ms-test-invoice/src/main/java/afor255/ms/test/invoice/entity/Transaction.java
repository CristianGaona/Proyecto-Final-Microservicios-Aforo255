package afor255.ms.test.invoice.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.PrePersist;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer id_operation;
	
	private Integer id_invoice;
	private double amount;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@PrePersist
	public void prePersist() {
		date = new Date();
	}

	public Integer getId_operation() {
		return id_operation;
	}

	public void setId_operation(Integer id_operation) {
		this.id_operation = id_operation;
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
