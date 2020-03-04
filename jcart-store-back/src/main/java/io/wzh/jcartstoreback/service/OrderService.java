package io.wzh.jcartstoreback.service;

import com.github.pagehelper.Page;
import io.wzh.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.wzh.jcartstoreback.dto.out.OrderShowOutDTO;
import io.wzh.jcartstoreback.po.Order;

public interface OrderService {


    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,
                  Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOutDTO getById(Long orderId);
}
