package com.customerdetailsapi.service;

import com.customerdetailsapi.entity.CustomerDetails;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@Service
public interface CustomerService {

    /**
     * This method is use to save the new customer details.
     * @param name
     * @param email
     * @param dob
     * @param occupation
     * @throws Exception 
     */
    public void insertCustomerDetails(String name, String email, String dob, String occupation) throws Exception;

    /**
     * This method is used to fetch details of existing customer.
     * @return 
     */
    public List<CustomerDetails> getDetails();
}
