package com.customerdetailsapi.service;

import com.customerdetailsapi.entity.CustomerDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@Service
public interface CustomerService{
    public void insertCustomerDetails(CustomerDetails customerDetails) throws Exception;
}
