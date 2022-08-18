package com.customers.restcontrollers;

import com.customers.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public List<String> findAll(){
        try {
            return customerService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
