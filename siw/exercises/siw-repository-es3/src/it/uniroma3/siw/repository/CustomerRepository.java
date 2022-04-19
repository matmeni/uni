package it.uniroma3.siw.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import it.uniroma3.siw.model.Customer;

public class CustomerRepository extends SimpleRepositoryImpl<Customer> {
	
	private static final String SELECT_BY_NAME = "select c from Customer c where name = :name";
	
	public CustomerRepository() {
		super(Customer.class);
	}
	
	public List<Customer> findByName(String name) {
		TypedQuery<Customer> query = null;
		query = this.getEntityManager().createQuery(SELECT_BY_NAME , Customer.class);
		query.setParameter("name", name);
		return query.getResultList();
	}
}