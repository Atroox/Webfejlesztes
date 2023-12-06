package com.example.webproject.service;

import com.example.webproject.uito.ProductUITO;

import java.util.List;

public interface ProductService {

    List<ProductUITO> getAllProduct();

    ProductUITO getProduct(ProductUITO productUITO);

    ProductUITO saveProduct(ProductUITO productUITO);

    void deleteProduct(ProductUITO productUITO);
}
