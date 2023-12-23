package com.customerdetailsapi.controller;

import com.customerdetailsapi.entity.CustomerDetails;
import com.customerdetailsapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@RestController
@RequestMapping("/api/customerdetils")
public class Controller {
    
    @Autowired
    private CustomerService customerService;
    
//    @GetMapping("/")
//    public String hello(){
//        return "hello sir";
//    }
    
    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDetails customerDetails){
        try{
            customerService.insertCustomerDetails(customerDetails);
            return ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully");
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }  
}
