package com.shayaan.project.DAO;

import com.shayaan.project.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void delete(int id);
}
