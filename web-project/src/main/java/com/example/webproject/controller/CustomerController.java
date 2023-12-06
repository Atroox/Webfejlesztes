package com.example.webproject.controller;

import com.example.webproject.service.CustomerService;
import com.example.webproject.service.ProductService;
import com.example.webproject.uito.CustomerUITO;
import com.example.webproject.uito.ProductUITO;
import org.primefaces.PrimeFaces;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import java.util.ArrayList;
import java.util.List;

@Controller("customerController")
@SessionScope
public class CustomerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    private String actionLabel;

    private ProductUITO productUITO;

    private CustomerUITO customerUITO;

    private List<ProductUITO> productUITOList;

    private List<CustomerUITO> customerUITOList;

    public void saveInfoCustomer() {
        customerService.saveCustomer(this.customerUITO);
        getAllCustomer();
        this.setCustomerUITO(new CustomerUITO());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Customer Details", "Customer Details added/Updated Successfully.");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    @PostConstruct
    public void getAllCustomer() {
        if(!this.getProductUITOList().isEmpty()) {
                this.getProductUITOList().clear();
                this.getCustomerUITOList().clear();
        }
        this.getProductUITOList().addAll(productService.getAllProduct());
        this.getCustomerUITOList().addAll(customerService.getAllCustomer());
        this.setActionLabel("Add");
    }

    public void deleteCustomer(CustomerUITO customerUITO) {
            customerService.deleteCustomer(customerUITO);
            getAllCustomer();
    }

    public void editCustomer(CustomerUITO customerUITO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(customerUITO, this.getCustomerUITO());
        System.out.println(this.getCustomerUITO());
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public ProductUITO getProductUITO() {
        if(productUITO == null) {
            productUITO = new ProductUITO();
        }
        return productUITO;
    }

    public void setProductUITO(ProductUITO productUITO) {
        this.productUITO = productUITO;
    }

    public CustomerUITO getCustomerUITO() {
        if(customerUITO == null) {
            customerUITO = new CustomerUITO();
        }
        return customerUITO;
    }

    public void setCustomerUITO(CustomerUITO customerUITO) {
        this.customerUITO = customerUITO;
    }

    public List<ProductUITO> getProductUITOList() {
        if(productUITOList == null) {
            productUITOList = new ArrayList<>();
        }
        return productUITOList;
    }

    public void setProductUITOList(List<ProductUITO> productUITOList) {
        this.productUITOList = productUITOList;
    }

    public List<CustomerUITO> getCustomerUITOList() {
        if(customerUITOList == null ) {
            customerUITOList = new ArrayList<>();
        }
        return customerUITOList;
    }

    public void setCustomerUITOList(List<CustomerUITO> customerUITOList) {
        this.customerUITOList = customerUITOList;
    }
}
