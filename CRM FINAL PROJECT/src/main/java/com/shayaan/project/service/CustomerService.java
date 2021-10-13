package com.shayaan.project.service;

import com.shayaan.project.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void delete(int id);
}
