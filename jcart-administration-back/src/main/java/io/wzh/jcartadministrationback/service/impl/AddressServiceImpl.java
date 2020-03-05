package io.wzh.jcartadministrationback.service.impl;

import io.wzh.jcartadministrationback.dao.AddressMapper;
import io.wzh.jcartadministrationback.pogo.Address;
import io.wzh.jcartadministrationback.pogo.Address;
import io.wzh.jcartadministrationback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public Address getById(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }

    @Override
    public List<Address> getByCustomerId(Integer customerId) {
        List<Address> addresses = addressMapper.selectByCustomerId(customerId);
        return addresses;
    }
}
