package afor255.ms.test.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import afor255.ms.test.pay.dao.TransactionDao;
import afor255.ms.test.pay.domain.Transaction;

@Service
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	private TransactionDao transactionDao;
	
	@Override
	public Transaction findById(Integer id) {
		// TODO Auto-generated method stub
		return transactionDao.findById(id).orElse(null);
	}

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return transactionDao.save(transaction);
	}

}
