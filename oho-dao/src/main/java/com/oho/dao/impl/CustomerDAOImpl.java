package com.oho.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.oho.dao.CustomerDAO;
import com.oho.dao.model.Customer;

@Repository("customerDAO")
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerDAOImpl extends BaseDAOImpl<Customer> implements CustomerDAO {

}
