package afor255.ms.test.invoice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import afor255.ms.test.invoice.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
