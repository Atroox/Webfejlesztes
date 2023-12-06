package com.example.webproject.service.impl;

import com.example.webproject.entity.CustomerDTO;
import com.example.webproject.entity.ProductDTO;
import com.example.webproject.repository.ProductRepo;
import com.example.webproject.service.ProductService;
import com.example.webproject.uito.CustomerUITO;
import com.example.webproject.uito.ProductUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<ProductUITO> getAllProduct() {
        List<ProductDTO> dtoList = productRepo.findAll();
        List<ProductUITO> uitoList = new ArrayList<>();
        dtoList.forEach(dto -> {
            ProductUITO tempUito = new ProductUITO();
            BeanUtils.copyProperties(dto, tempUito);
            dtoToUito(tempUito, dto);
            uitoList.add(tempUito);
        });
        return uitoList;
    }

    @Override
    public ProductUITO getProduct(ProductUITO productUITO) {
        if(null != productUITO.getProductName()) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productUITO, productDTO);
            productDTO = productRepo.getReferenceById(productDTO.getProductID());
            BeanUtils.copyProperties(productDTO, productUITO);
        }
        return productUITO;
    }

    @Override
    @Transactional(readOnly = false)
    public ProductUITO saveProduct(ProductUITO productUITO) {
        ProductDTO dto = UiToToDto(productUITO);
        dto = productRepo.save(dto);
        BeanUtils.copyProperties(dto, productUITO);
        dtoToUito(productUITO, dto);
        return productUITO;
    }

    @Override
    @Transactional
    public void deleteProduct(ProductUITO productUITO) {
        productRepo.deleteById(productUITO.getProductID());
    }

    private void dtoToUito(ProductUITO productUITO, ProductDTO dto) {
        CustomerUITO uitTO = new CustomerUITO();
        BeanUtils.copyProperties(dto.getCustomerDTO(), uitTO);
        productUITO.setCustomerUITO(uitTO);
    }

    private ProductDTO UiToToDto(ProductUITO productUITO) {
        ProductDTO dto = new ProductDTO();
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(productUITO, dto);
        BeanUtils.copyProperties(productUITO.getCustomerUITO(), customerDTO);
        dto.setCustomerDTO(customerDTO);
        List<ProductDTO> lst = new ArrayList<>();
        lst.add(dto);
        customerDTO.getProductDTOList().addAll(lst);
        return dto;
    }
}
