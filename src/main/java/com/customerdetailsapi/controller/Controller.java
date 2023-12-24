package com.customerdetailsapi.controller;

import com.customerdetailsapi.entity.CustomerDetails;
import com.customerdetailsapi.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    private CustomerService customerService;

    /**
     * This get method is used to fetch all customer details.
     * @return 
     */
    @GetMapping("/get")
    public List<CustomerDetails> getCustomerDetails() {

        return customerService.getDetails();
    }

    /**
     * This method is use to save customer details in database.
     * @param name
     * @param email
     * @param dob
     * @param occupation
     * @return 
     */
    @PostMapping("/post")
    public ResponseEntity<String> addCustomer(@RequestParam String name, @RequestParam String email,
            @RequestParam String dob, @RequestParam String occupation) {
        try {
            customerService.insertCustomerDetails(name, email, dob, occupation);
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
