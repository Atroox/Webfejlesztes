package com.example.webproject.controller;

import com.example.webproject.service.CustomerService;
import com.example.webproject.service.ProductService;
import com.example.webproject.service.impl.ProductServiceImpl;
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

@Controller("productController")
@SessionScope
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    private String actionLabel;

    private ProductUITO productUITO;

    private List<ProductUITO> productUITOList;

    private List<CustomerUITO> customerUITOList;

    public void saveInfoProduct() {
        //System.out.println("Save for product controller is called");
        productService.saveProduct(this.productUITO);
        getAllProduct();
        this.setProductUITO(new ProductUITO());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Product Details", "Product Details added/Updated Successfully.");
        PrimeFaces.current().dialog().showMessageDynamic(message);
    }

    @PostConstruct
    public void getAllProduct() {
        //System.out.println("getAllProduct for save for product controller is called");
        if(!this.getProductUITOList().isEmpty()) {
            this.getProductUITOList().clear();
            this.getCustomerUITOList().clear();
        }
        this.getProductUITOList().addAll(productService.getAllProduct());
        this.getCustomerUITOList().addAll(customerService.getAllCustomer());
        this.setActionLabel("Add");
    }

    public void deleteProduct(ProductUITO productUITO) {
        //System.out.println("Delete for product controller is called");
        productService.deleteProduct(productUITO);
        getAllProduct();
    }

    public void editProduct(ProductUITO productUITO) {
        //System.out.println("Update for product controller is called");
        this.setActionLabel("Update");
        BeanUtils.copyProperties(productUITO, this.getProductUITO());
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public ProductUITO getProductUITO() {
        if (productUITO == null) {
            productUITO = new ProductUITO();
        }
        return productUITO;
    }

    public void setProductUITO(ProductUITO productUITO) {
        this.productUITO = productUITO;
    }

    public List<ProductUITO> getProductUITOList() {
        if (productUITOList == null) {
            productUITOList = new ArrayList<>();
        }
        return productUITOList;
    }

    public void setProductUITOList(List<ProductUITO> productUITOList) {
        this.productUITOList = productUITOList;
    }

    public List<CustomerUITO> getCustomerUITOList() {
        if (customerUITOList == null) {
            customerUITOList = new ArrayList<>();
        }
        return customerUITOList;
    }

    public void setCustomerUITOList(List<CustomerUITO> customerUITOList) {
        this.customerUITOList = customerUITOList;
    }
}
