package com.customerdetailsapi.controller;

import com.customerdetailsapi.entity.CustomerDetails;
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
    
    @GetMapping("/")
    public String hello(){
        return "hello sir";
    }
    
    @PostMapping("/")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDetails customerDetails){
        return null;
    }
    
}
