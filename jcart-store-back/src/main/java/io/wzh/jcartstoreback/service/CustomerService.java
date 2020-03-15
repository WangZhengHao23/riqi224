package io.wzh.jcartstoreback.service;

import io.wzh.jcartstoreback.dto.in.CustomerRegisterInDTO;
import io.wzh.jcartstoreback.po.Customer;

public interface CustomerService {

    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    Customer getByEmail(String email);

    void update(Customer customer);

}
