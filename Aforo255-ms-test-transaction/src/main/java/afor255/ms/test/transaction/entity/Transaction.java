package afor255.ms.test.transaction.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transaction")
public class Transaction {

	private String id;
    private Integer id_invoice;
    private double amount;
    private String date;
	public String getId_transaccion() {
		return id;
	}
	public void setId_transaccion(String id_transaccion) {
		this.id = id_transaccion;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	

    
    

}
