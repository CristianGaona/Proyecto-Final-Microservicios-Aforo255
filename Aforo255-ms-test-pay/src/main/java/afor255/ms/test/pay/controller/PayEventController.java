package afor255.ms.test.pay.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;

import afor255.ms.test.pay.domain.Transaction;
import afor255.ms.test.pay.producer.PayEventProducer;
import afor255.ms.test.pay.service.ITransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PayEventController {

	private Logger log = LoggerFactory.getLogger(PayEventController.class);
	
	@Autowired
	PayEventProducer payEventProducer;
	
	@Autowired
	private ITransactionService transactionService;
	
	@PostMapping("/v1/payevent")
	public ResponseEntity<Transaction> postDepositEvent (@RequestBody Transaction transactionEvent) throws JsonProcessingException{
		log.info("antes de tranSql");
		Transaction tranSql = transactionService.save(transactionEvent);
		log.info("despues de tranSql");
		log.info("antes  de sendDepositEvent");
		payEventProducer.sendDepositEvent(tranSql);
		log.info("despues  de sendDepositEvent");
		return  ResponseEntity.status(HttpStatus.CREATED).body(tranSql);				
	}
}
