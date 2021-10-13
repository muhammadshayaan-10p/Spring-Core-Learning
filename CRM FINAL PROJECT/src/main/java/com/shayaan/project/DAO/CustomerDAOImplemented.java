package com.shayaan.project.DAO;

import com.shayaan.project.entity.Customer;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImplemented implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        // get the current hibernate session from hibernate factory
        Session session = sessionFactory.getCurrentSession();

        // create a query....sort by last name
        Query<Customer> query = session.createQuery("from Customer order by last_name"
                , Customer.class);

        // execute query and get result list

        List<Customer> customers = query.getResultList();

        // return the results
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

        // we will use saveorupdate method, because hibernate figures out by itself if it is an existing customer or new customer
        session.saveOrUpdate(customer);

    }

    @Override
    public Customer getCustomer(int id) {
        // getting the current hibernate session
        Session session = sessionFactory.getCurrentSession();

        // retrieve costumer from db using primary key
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("delete from Customer c where c.id=id");

    query.executeUpdate();
    }
}
