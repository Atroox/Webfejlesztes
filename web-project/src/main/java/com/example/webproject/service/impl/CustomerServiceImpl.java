package com.example.webproject.service.impl;

import com.example.webproject.entity.CustomerDTO;
import com.example.webproject.repository.CustomerRepo;
import com.example.webproject.service.CustomerService;
import com.example.webproject.uito.CustomerUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public List<CustomerUITO> getAllCustomer() {
        List<CustomerUITO> customerUITOList = new ArrayList<>();
        List<CustomerDTO> customerDTOList = customerRepo.findAll();

        customerDTOList.forEach(dto -> {
            CustomerUITO tempUITO = new CustomerUITO();

            BeanUtils.copyProperties(dto, tempUITO);
            customerUITOList.add(tempUITO);
        });

        return customerUITOList;
    }

    @Override
    public CustomerUITO getCustomer(CustomerUITO customerUITO) {
        CustomerDTO dto = customerRepo.findCustomerDTOByCustomerName(customerUITO.getCustomerName());
        CustomerUITO uito = new CustomerUITO();

        BeanUtils.copyProperties(dto, uito);
        return uito;
    }

    @Override
    public CustomerUITO saveCustomer(CustomerUITO customerUITO) {
        CustomerDTO dto = new CustomerDTO();
        dto.setCustomerID(customerUITO.getCustomerID());
        dto.setCustomerName(customerUITO.getCustomerName());
        if(customerUITO.getCustomerID() == null) {
            customerRepo.save(dto);
        } else {
            Optional<CustomerDTO> dbDto = customerRepo.findById(customerUITO.getCustomerID());
            CustomerDTO db = dbDto.get();
            db.setCustomerName(customerUITO.getCustomerName());
            customerRepo.save(db);
        }
        CustomerDTO dto2 = customerRepo.findCustomerDTOByCustomerName(customerUITO.getCustomerName());
        CustomerUITO uito = new CustomerUITO();

        BeanUtils.copyProperties(dto2, uito);
        return uito;

    }

    @Override
    public void deleteCustomer(CustomerUITO customerUITO) {
        customerRepo.deleteById(customerUITO.getCustomerID());
    }
}
