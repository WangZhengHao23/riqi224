package io.wzh.jcartstoreback.service;

import io.wzh.jcartstoreback.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistory> getByOrderId(Long orderId);

}
