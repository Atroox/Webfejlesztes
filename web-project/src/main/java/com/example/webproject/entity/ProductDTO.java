package com.example.webproject.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PRODUCT_MASTER")
@NamedQuery(name = "ProductDTO.findAll", query = "SELECT a FROM ProductDTO a")
public class ProductDTO implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "PRODUCT_ID")
private Long productID;

@Column(name = "PRODUCT_NAME")
private String productName;

@Column(name = "ORDER_AMOUNT")
private Integer amount;

@Column(name = "PRICE")
private Integer price;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "CUSTOMER_ID")
private CustomerDTO customerDTO;

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
