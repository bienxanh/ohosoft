package com.oho.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.oho.dao.model.Customer;
import com.oho.services.CustomerService;

@ManagedBean (name = "customerBean")
@RequestScoped
public class CustomerBean {
    
    @ManagedProperty(value="#{CustomerService}")
    CustomerService customerService;
    
    private List<Customer> customers;
    
    public List<Customer> customerList() {
        return customerService.findAll();
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> getCustomers() {
        if (customers == null) {
            customers = customerList();
        }
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
