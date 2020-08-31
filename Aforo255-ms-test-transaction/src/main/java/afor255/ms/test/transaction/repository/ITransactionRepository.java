package afor255.ms.test.transaction.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import afor255.ms.test.transaction.entity.Transaction;

public interface ITransactionRepository extends MongoRepository<Transaction, String>{
	
	@Query("{'id_invoice':?0}")
	public Iterable<Transaction>  findByInvoiceId(Integer id_invoice);	

}
