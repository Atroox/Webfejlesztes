package com.example.webproject.uito;

import java.io.Serializable;
import java.util.List;

public class CustomerUITO implements Serializable {

    private Long customerID;

    private String customerName;

    private List<ProductUITO> productUITOList;

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<ProductUITO> getProductUITOList() {
        return productUITOList;
    }

    public void setProductUITOList(List<ProductUITO> productUITOList) {
        this.productUITOList = productUITOList;
    }
}
