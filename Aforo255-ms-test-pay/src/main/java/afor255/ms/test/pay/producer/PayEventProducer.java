package afor255.ms.test.pay.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.support.SendResult;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.kafka.clients.producer.ProducerRecord;

import afor255.ms.test.pay.domain.Transaction;
import afor255.ms.test.pay.service.ITransactionService;


import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

@Component
public class PayEventProducer {

	String topic = "transaction-events";
	private Logger log = LoggerFactory.getLogger(PayEventProducer.class);
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	@Autowired
	ObjectMapper objectMapper;

	//@Autowired
	//private ITransactionService service;

	public ListenableFuture<SendResult<Integer, String>> sendDepositEvent(Transaction payEvent)
			throws JsonProcessingException {

		Integer key = payEvent.getId_invoice();
		String value = objectMapper.writeValueAsString(payEvent);

		ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, topic);

		ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(producerRecord);

		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				// TODO Auto-generated method stub
				handleSuccess(key, value, result);
			}

			@Override
			public void onFailure(Throwable ex) {
				// TODO Auto-generated method stub
				handleFailure(key, value, ex);

			}
		});

		return listenableFuture;
	}

	private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {

		// agregando header
		List<Header> recordHeaders = Stream.of(new RecordHeader("pay-event-source", "scanner".getBytes()))
                .collect(Collectors.toList());

		return new ProducerRecord<>(topic, null, key, value, recordHeaders);

	}

	private void handleFailure(Integer key, String value, Throwable ex) {
		log.error("Error Sending the Message and the execpition is {}", ex.getMessage());
		try {
			throw ex;
		} catch (Throwable throwable) {
			log.error("Error in OnFailure : {}", throwable.getMessage());
		}
	}

	private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {

		log.info("Message Sent SuccessFully for the key : {} amd the value is {} , partition is {}", key, value,
				result.getRecordMetadata().partition());

	}

}
