package com.shayaan.project.service;

import com.shayaan.project.DAO.CustomerDAO;
import com.shayaan.project.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImplementation implements CustomerService{

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        List<Customer> customers = customerDAO.getCustomers();

        return customers;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        Customer customer = customerDAO.getCustomer(id);
        return customer;
    }

    @Override
    @Transactional
    public void delete(int id) {
        customerDAO.delete(id);
    }
}
