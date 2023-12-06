package com.example.webproject.utils;

import com.example.webproject.service.CustomerService;
import com.example.webproject.uito.CustomerUITO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Service
public class CustomerConverter implements Converter {

    @Autowired
    private CustomerService customerService;

    private static final Logger LOG = LoggerFactory.getLogger(CustomerConverter.class.getName());

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        LOG.info("getAsObject: " + customerService);
        CustomerUITO customerUITO = new CustomerUITO();
        customerUITO.setCustomerName(s);
        customerUITO = customerService.getCustomer(customerUITO);
        System.out.println(customerUITO.toString());
        return customerUITO;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        LOG.info("getAsString obj class: " + o.getClass().getName());
        if (o instanceof CustomerUITO) {
            CustomerUITO dept = (CustomerUITO) o;
            LOG.info("getAsString def name: " + dept.getCustomerName());
            return dept.getCustomerName();
        } else {
            throw new ClassCastException("The object of class " + o.getClass().getName() + " is not of CustomerUITO");
        }
    }
}
