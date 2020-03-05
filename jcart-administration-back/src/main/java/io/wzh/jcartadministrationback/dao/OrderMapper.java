package io.wzh.jcartadministrationback.dao;

import com.github.pagehelper.Page;
import io.wzh.jcartadministrationback.dto.out.OrderListOutDTO;
import io.wzh.jcartadministrationback.pogo.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Page<OrderListOutDTO> search(Integer pageNum);

    Order getbyId(Integer orderId);
}