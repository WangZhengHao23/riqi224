package io.wzh.jcartadministrationback.service;

import com.github.pagehelper.Page;
import io.wzh.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.wzh.jcartadministrationback.pogo.Return;

public interface ReturnService {
    //分页查询
    Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum);
    //根据getId查找
    Return getById(Integer returnId);
    //修改
    void update(Return aReturn);
}
