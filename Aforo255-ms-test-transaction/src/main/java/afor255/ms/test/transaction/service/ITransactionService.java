package afor255.ms.test.transaction.service;

import afor255.ms.test.transaction.entity.Transaction;

public interface ITransactionService {
	public Transaction save (Transaction transaction );
	public Iterable<Transaction> findByInvoceId(Integer accountId);
	public Iterable<Transaction>  findAll();

}
