package io.wzh.jcartstoreback.service;


import com.github.pagehelper.Page;
import io.wzh.jcartstoreback.po.Return;

public interface ReturnService {

    Integer create(Return aReturn);

    Page<Return> getpageById(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);
}
