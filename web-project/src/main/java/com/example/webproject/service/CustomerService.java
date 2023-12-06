package com.example.webproject.service;

import com.example.webproject.uito.CustomerUITO;

import java.util.List;

public interface CustomerService {

    List<CustomerUITO> getAllCustomer();

    CustomerUITO getCustomer(CustomerUITO customerUITO);

    CustomerUITO saveCustomer(CustomerUITO customerUITO);

    void deleteCustomer(CustomerUITO customerUITO);
}
