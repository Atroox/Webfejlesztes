package com.example.webproject.uito;

import java.io.Serializable;

public class ProductUITO implements Serializable {

private Long productID;

private String productName;

private Integer amount;

private Integer price;

private CustomerUITO customerUITO;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public CustomerUITO getCustomerUITO() {
        return customerUITO;
    }

    public void setCustomerUITO(CustomerUITO customerUITO) {
        this.customerUITO = customerUITO;
    }

    @Override
    public String toString() {
        return "ProductUITO [prodId=" + productID + ", prodName=" + productName + ", price=" + price + " customerUITO=" + customerUITO + "]";
    }
}
