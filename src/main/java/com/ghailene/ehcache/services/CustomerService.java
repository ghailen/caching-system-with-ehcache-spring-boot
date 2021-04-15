package com.ghailene.ehcache.services;

import com.ghailene.ehcache.models.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers() throws InterruptedException;
}
