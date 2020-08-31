package afor255.ms.test.invoice.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import afor255.ms.test.invoice.entity.Invoice;
import afor255.ms.test.invoice.entity.Transaction;

@Service
public class TransactionEvents {
	
	//private Integer aux = 0;
	@Autowired
	private IInvoceService repository;
	
	@Autowired
	ObjectMapper objectMapper;
	
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {
		double newAmount = 0;
		Invoice invoice = new Invoice();

		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("transactionEvent: {} ", event.getId_invoice());
		invoice = repository.findById(event.getId_invoice());

		if(event.getAmount() == invoice.getAmount() ) {
			newAmount = invoice.getAmount() - event.getAmount();
			invoice.setState(1);//Factura cancelada
			log.info("Factura cancelada correctamente, su deuda es de: " + newAmount);
		}else if (event.getAmount()< invoice.getAmount()) {
			newAmount = invoice.getAmount() - event.getAmount();
			invoice.setState(2);//Factura no cancelada en su totolidad
			log.info("Factura con saldo pendiente, su deuda es de: " + newAmount);
		}else if (event.getAmount()> invoice.getAmount()) {
			newAmount =event.getAmount() - invoice.getAmount() ;
			invoice.setState(3); //Factura cancelda, pero paga mas de lo que debe
			log.info("Factura cancelada correctamente, tiene un abono adicional de: " + newAmount);
		}
		
		invoice.setAmount(newAmount);
		log.info("Actualizando estado de factura con ID = " + event.getId_invoice());
		log.info("El estado actual de la factura es  = " + invoice.getState());
		repository.save(invoice);

	}
}
