package com.customerdetailsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author KRISHNA PRASAD YADAV
 */
@RestController
public class Controller {
    
    @GetMapping("/")
    public String hello(){
        return "hello sir";
    }
    
}
