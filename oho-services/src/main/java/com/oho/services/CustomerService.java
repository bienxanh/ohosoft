package com.oho.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oho.dao.impl.CustomerDAOImpl;
import com.oho.dao.model.Customer;

@Service("CustomerService")
@Transactional(readOnly = true)
public class CustomerService {

    @Autowired
    CustomerDAOImpl customerDAO;
    
    public List<Customer> findAll() {
        String sql = "FROM Customer c";
        List<Customer> customers = customerDAO.getByQuery(sql, new Object[] {});
        return customers;
    }
    

    public CustomerDAOImpl getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAOImpl customerDAO) {
        this.customerDAO = customerDAO;
    }

}
