package com.example.webproject.repository;

import com.example.webproject.entity.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerDTO, Long> {

    CustomerDTO findCustomerDTOByCustomerName(String custName);

}
