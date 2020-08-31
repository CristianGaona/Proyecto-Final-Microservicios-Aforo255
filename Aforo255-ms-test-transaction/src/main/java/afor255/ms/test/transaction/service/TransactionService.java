package afor255.ms.test.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afor255.ms.test.transaction.entity.Transaction;
import afor255.ms.test.transaction.repository.ITransactionRepository;

@Service
public class TransactionService implements ITransactionService{

	@Autowired
	ITransactionRepository repository;

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByInvoceId(Integer invoiceId) {
		// TODO Auto-generated method stub
		return repository.findByInvoiceId(invoiceId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	
	
}
