package io.wzh.jcartadministrationback.service;

import io.wzh.jcartadministrationback.pogo.OrderHistory;

import java.util.List;

public interface OrderHistoryService {
    List<OrderHistory> getByOrderId(Long orderId);

    Long create(OrderHistory orderHistory);
}
