package io.wzh.jcartadministrationback.service;

import io.wzh.jcartadministrationback.pogo.Address;

import java.util.List;

public interface AddressService {
    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);
}
