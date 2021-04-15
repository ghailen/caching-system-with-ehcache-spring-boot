package com.ghailene.ehcache.controllers;

import com.ghailene.ehcache.config.CacheConf;
import com.ghailene.ehcache.models.Customer;
import com.ghailene.ehcache.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CacheConf cacheConf;
    private final CustomerService customerService;

    public CustomerController(CacheConf cacheConf, CustomerService customerService) {
        this.cacheConf = cacheConf;
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<Object> getCustomers() throws InterruptedException {
        List<Customer> res = customerService.getCustomers();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(res);
    }

    @PostMapping("/reload")
    public ResponseEntity<Object> reloadCache() {
        try {

            new Thread(() -> {
                try {
                    cacheConf.loadDatatoCach();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
