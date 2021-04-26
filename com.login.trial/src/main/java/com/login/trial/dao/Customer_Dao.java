package com.login.trial.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.login.trial.entity.Customer_Entity;



@Transactional
@Repository
public class Customer_Dao implements Customer_Dao_Interface {

	@Autowired
	SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Customer_Entity> getCustomers() {
		
	Session session = sessionFactory.getCurrentSession();
	
	 Query<Customer_Entity> query = session.createQuery("from Customer_Entity", Customer_Entity.class);
	 
	 List<Customer_Entity> list = query.getResultList();
	
	 return list;
	}



	@Override
	public void saveCustomer(Customer_Entity customer_entity) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer_entity);
		
	}



	@Override
	public Customer_Entity getCustomer(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Customer_Entity where id =" +id );
		Customer_Entity customer = (Customer_Entity) query.getSingleResult();
		
		return customer;
	}



	@Override
	public void deleteCustomer(Customer_Entity customer) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
		
	}

}
