package com.plyzwa.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.plyzwa.entity.Customer;

@Repository
public class CustomerDAOimpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {

		Session ses = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = ses.createQuery("from Customer order by firstName", Customer.class);
		
		List<Customer> customerList = theQuery.getResultList();
		
		return customerList;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session ses = sessionFactory.getCurrentSession();
		
		ses.saveOrUpdate(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		Session ses = sessionFactory.getCurrentSession();
		
		Customer tmpCustomer = ses.get(Customer.class, theId);
		
		return tmpCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		Session ses = sessionFactory.getCurrentSession();
		
		Query<Customer> theQuery = 
				ses.createQuery("DELETE from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		
		theQuery.executeUpdate();
	}
	
	

}
