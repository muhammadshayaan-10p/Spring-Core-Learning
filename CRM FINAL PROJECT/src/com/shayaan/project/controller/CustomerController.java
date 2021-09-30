package com.shayaan.project.controller;

import com.shayaan.project.DAO.CustomerDAO;
import com.shayaan.project.entity.Customer;
import com.shayaan.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // need to inject the DAO in the controller

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String ListCustomer(Model theModel){

        //get the customers from the DAO
        List<Customer> customerList = customerService.getCustomers();

        // add the customers to the spring mvc model

        theModel.addAttribute("customers", customerList);

        return "list-customers";
    }

    @GetMapping("showFormForAdd")
    public  String showFormForAdd(Model model){

        // Create model attribute to bind form data

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("showFormforUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,
                                    Model model){

        // get the customer from the db

        Customer customer = customerService.getCustomer(id);

        // set the customer as a model attribute to pre-populate the form

        model.addAttribute("customer", customer);

        // send it to our form

        return "customer-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int Id){
        customerService.delete(Id);

        return ("redirect:/customer/list");
    }














}
