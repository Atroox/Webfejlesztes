package com.example.webproject.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_MASTER")
public class CustomerDTO implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "CUSTOMER_ID")
private Long customerID;

@Column(name = "CUSTOMER_NAME")
private String customerName;

@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "customerDTO")
private List<ProductDTO> productDTOList;

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

    public List<ProductDTO> getProductDTOList() {
        if(null == productDTOList) {
            return productDTOList = new ArrayList<>();
        }
        return productDTOList;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }
}
