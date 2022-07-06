package leon.spring.ormandmvc.customermanagement.service;

import java.util.List;

import leon.spring.ormandmvc.customermanagement.model.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(long customerId);

	public void save(Customer customer);

	public void delete(long customerId);
	
	public boolean isLetters(String str);
	
	
}
