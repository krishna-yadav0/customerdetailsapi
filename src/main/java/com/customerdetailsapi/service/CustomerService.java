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

    public void insertCustomerDetails(String name, String email, String dob, String occupation) throws Exception;

    public List<CustomerDetails> getDetails();
}
