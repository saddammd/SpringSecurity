package com.login.trial.dao;

import java.util.List;

import com.login.trial.entity.Customer_Entity;

public interface Customer_Dao_Interface {

	public List<Customer_Entity>getCustomers();

	public void saveCustomer(Customer_Entity customer_entity);

	public Customer_Entity getCustomer(Integer id);

	public void deleteCustomer(Customer_Entity customer);
}
