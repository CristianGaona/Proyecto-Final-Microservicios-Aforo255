package afor255.ms.test.pay.service;

import afor255.ms.test.pay.domain.Transaction;

public interface ITransactionService {
	public Transaction findById(Integer id );
	public Transaction save (Transaction transaction);	
}
