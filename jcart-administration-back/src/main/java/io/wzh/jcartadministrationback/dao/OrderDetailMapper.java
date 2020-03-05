package io.wzh.jcartadministrationback.dao;

import io.wzh.jcartadministrationback.pogo.OrderDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailMapper {
    int deleteByPrimaryKey(Long orderId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKeyWithBLOBs(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}