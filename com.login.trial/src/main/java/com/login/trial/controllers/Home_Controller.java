package com.login.trial.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.login.trial.dao.Customer_Dao_Interface;
import com.login.trial.entity.Customer_Entity;

@Controller
public class Home_Controller {
	
	@Autowired
	Customer_Dao_Interface customer_dao;

	@GetMapping("/")
	public String home(Model model) {
		
		List<Customer_Entity> list = customer_dao.getCustomers();
		
		model.addAttribute("customerList", list);
		
		return "home";
	}
	@GetMapping("/addCustomer")
	public String addNewCustomer(@ModelAttribute("customer_entity") Customer_Entity customer_entity)
	{
		
		return "addCustomer";
	}
	
	@PostMapping("/processAddCustomer")
	public String processAddCustomer(@ModelAttribute("customer_entity") Customer_Entity customer_entity) {
		
		customer_dao.saveCustomer(customer_entity);
		
		return "redirect:/ ";
	}
	
	@GetMapping("/update")
	public String updateCustomer(@RequestParam("param") Integer id, Model model) {
		
		Customer_Entity cust = customer_dao.getCustomer(id);
		model.addAttribute("customer", cust);
		
		return "updateCustomer";
	}
	
	@PostMapping("/processUpdateCustomer")
	public String processUpdateCustomer(Customer_Entity customerEntity) {
		
		
		customer_dao.saveCustomer(customerEntity);
		
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("del") Integer id) {
		
		Customer_Entity customer = customer_dao.getCustomer(id);
		customer_dao.deleteCustomer(customer);
		
		return "redirect:/";
	}
}
