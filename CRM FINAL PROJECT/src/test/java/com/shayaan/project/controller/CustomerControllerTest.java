package com.shayaan.project.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.shayaan.project.entity.Customer;
import com.shayaan.project.service.CustomerService;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ConcurrentModel;

public class CustomerControllerTest {
    @Test
    public void testListCustomer() {
        CustomerService customerService = mock(CustomerService.class);
        when(customerService.getCustomers()).thenReturn(new ArrayList<Customer>());
        CustomerController customerController = new CustomerController();
        ReflectionTestUtils.setField(customerController, "customerService", customerService);
        assertEquals("list-customers", customerController.ListCustomer(new ConcurrentModel()));
        verify(customerService).getCustomers();
    }

    @Test
    public void testShowFormForAdd() {
        CustomerController customerController = new CustomerController();
        ReflectionTestUtils.setField(customerController, "customerService", mock(CustomerService.class));
        assertEquals("customer-form", customerController.showFormForAdd(new ConcurrentModel()));
    }

    @Test
    public void testSaveCustomer() {
        CustomerService customerService = mock(CustomerService.class);
        doNothing().when(customerService).saveCustomer((Customer) any());
        CustomerController customerController = new CustomerController();
        ReflectionTestUtils.setField(customerController, "customerService", customerService);

        Customer customer = new Customer();
        customer.setEmail("shayaan@gmail.com");
        customer.setId(1);
        customer.setLast_name("Shayaan");
        customer.setFirst_name("Muhammad");
        assertEquals("redirect:/customer/list", customerController.saveCustomer(customer));
//        verify(customerService).saveCustomer((Customer) any());
    }

    @Test
    public void testShowFormForUpdate() {
        Customer customer = new Customer();
        customer.setEmail("shayaan@gmail.com");
        customer.setId(1);
        customer.setLast_name("Shayaan");
        customer.setFirst_name("Muhammad");
        CustomerService customerService = mock(CustomerService.class);
        when(customerService.getCustomer(anyInt())).thenReturn(customer);
        CustomerController customerController = new CustomerController();
        ReflectionTestUtils.setField(customerController, "customerService", customerService);
        assertEquals("customer-form", customerController.showFormForUpdate(1, new ConcurrentModel()));
//        verify(customerService).getCustomer(anyInt());
    }

    @Test
    public void testDelete() {
        CustomerService customerService = mock(CustomerService.class);
        doNothing().when(customerService).delete(anyInt());
        CustomerController customerController = new CustomerController();
        ReflectionTestUtils.setField(customerController, "customerService", customerService);
        assertEquals("redirect:/customer/list", customerController.delete(123));
        verify(customerService).delete(anyInt());
    }
}

