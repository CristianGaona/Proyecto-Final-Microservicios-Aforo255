package afor255.ms.test.transaction.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import afor255.ms.test.transaction.service.TransactionEvents;

@Component
public class TransactionEventsConsumerListener {

	@Autowired
	TransactionEvents events;
	
	private Logger log = LoggerFactory.getLogger(TransactionEventsConsumerListener.class);
	
	@KafkaListener(topics = {"transaction-events"})
	public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {

		log.info("ConsumerRecord :{}", consumerRecord.value());
		events.processTransactionEvent(consumerRecord);
	}
}
