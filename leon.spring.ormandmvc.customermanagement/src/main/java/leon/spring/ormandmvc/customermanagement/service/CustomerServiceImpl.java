package leon.spring.ormandmvc.customermanagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import leon.spring.ormandmvc.customermanagement.model.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public CustomerServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		try {
			this.session = this.sessionFactory.getCurrentSession();
		} catch (HibernateException exptn) {
			this.session = this.sessionFactory.openSession();
		}
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customers = this.session.createQuery("from Customer").list();
		return customers;
	}

	@Override
	public Customer findById(long customerId) {
		Customer customer = this.session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	@Transactional
	public void save(Customer customer) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(customer);
		tx.commit();
	}

	@Override
	@Transactional
	public void delete(long customerId) {
		Transaction tx = this.session.beginTransaction();
		Customer customer = this.session.get(Customer.class, customerId);
		this.session.delete(customer);
		tx.commit();
	}

	@Override
	public boolean isLetters(String str) {
		String regex="[a-zA-Z]+";
		return str.matches(regex);
	}

}
