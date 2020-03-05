package io.wzh.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.wzh.jcartadministrationback.dto.in.CustomerSetStatusInDTO;
import io.wzh.jcartadministrationback.pogo.Customer;

public interface CustomerService {
    Page<Customer> search(Integer pageNum);

    Customer getById(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);
}
