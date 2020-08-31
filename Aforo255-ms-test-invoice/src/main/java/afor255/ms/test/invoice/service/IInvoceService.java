package afor255.ms.test.invoice.service;

import java.util.List;

import afor255.ms.test.invoice.entity.Invoice;

public interface IInvoceService {

	public List<Invoice> findAll();
	public Invoice findById(Integer id) ;
	public Invoice save (Invoice account);
}
