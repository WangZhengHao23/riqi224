package io.wzh.jcartstoreback.service.impl;

import com.github.pagehelper.Page;
import io.wzh.jcartstoreback.dao.OrderHistoryMapper;
import io.wzh.jcartstoreback.dto.in.OrderCheckoutInDTO;
import io.wzh.jcartstoreback.dto.out.OrderShowOutDTO;
import io.wzh.jcartstoreback.po.Order;
import io.wzh.jcartstoreback.po.OrderHistory;
import io.wzh.jcartstoreback.service.OrderHistoryService;
import io.wzh.jcartstoreback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
    @Autowired
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {
        List<OrderHistory> orderHistories = orderHistoryMapper.selectByOrderId(orderId);
        return orderHistories;
    }

}
