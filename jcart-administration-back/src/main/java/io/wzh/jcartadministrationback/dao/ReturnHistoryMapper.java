package io.wzh.jcartadministrationback.dao;

import io.wzh.jcartadministrationback.pogo.ReturnHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReturnHistoryMapper {
    int deleteByPrimaryKey(Long returnHistoryId);

    int insert(ReturnHistory record);

    int insertSelective(ReturnHistory record);

    ReturnHistory selectByPrimaryKey(Long returnHistoryId);

    int updateByPrimaryKeySelective(ReturnHistory record);

    int updateByPrimaryKey(ReturnHistory record);
    List<ReturnHistory> selectListByReturnId(@Param("returnId") Integer returnId);
}