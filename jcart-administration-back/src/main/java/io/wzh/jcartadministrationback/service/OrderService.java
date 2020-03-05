package io.wzh.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.wzh.jcartadministrationback.dto.out.OrderListOutDTO;
import io.wzh.jcartadministrationback.dto.out.OrderShowOutDTO;
import io.wzh.jcartadministrationback.pogo.Order;


public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getByid(Long orderId);

    void update(Order order);

}
