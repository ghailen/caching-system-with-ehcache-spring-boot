package com.ghailene.ehcache.services.impl;

import com.ghailene.ehcache.models.ContactInformation;
import com.ghailene.ehcache.models.Customer;
import com.ghailene.ehcache.services.CustomerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Cacheable(value = "customerList", key = "'customerList'")
    @Override
    public List<Customer> getCustomers() throws InterruptedException {

        Thread.sleep(5000);
        System.out.println("entred in method");
        List<Customer> customersList = Stream.of(new Customer("123", "ghailene", "mark",
                        new ContactInformation("MR", "ghailenemark@gmail.com", "rue ahmec ahwki", "tn", "2222"), new Date(1994 - 07 - 13)),
                new Customer("321", "ghailene2", "mark2",
                        new ContactInformation("MR", "ghailenemark2@gmail.com", "rue ahmec chawki", "tn", "3333"), new Date(1994 - 07 - 13))
        ).collect(Collectors.toList());

        return customersList;
    }
}
