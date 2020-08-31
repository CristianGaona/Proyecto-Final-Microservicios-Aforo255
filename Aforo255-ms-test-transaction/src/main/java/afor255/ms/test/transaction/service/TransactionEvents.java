package afor255.ms.test.transaction.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import afor255.ms.test.transaction.entity.Transaction;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;


@Service
public class TransactionEvents {

	@Autowired
	private ITransactionService repository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {
		

		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent: {} ", event.getId_invoice());
		
		repository.save(event);

	}
}
