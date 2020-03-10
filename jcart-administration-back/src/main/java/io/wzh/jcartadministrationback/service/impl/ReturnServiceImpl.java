package io.wzh.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.wzh.jcartadministrationback.dao.ReturnMapper;
import io.wzh.jcartadministrationback.dto.in.ReturnSearchInDTO;
import io.wzh.jcartadministrationback.pogo.Return;
import io.wzh.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    private ReturnMapper returnMapper;


    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Return> page = returnMapper.search(returnSearchInDTO.getReturnId(),
                        returnSearchInDTO.getOrderId(),
                        returnSearchInDTO.getStartTimestamp() == null ? null : new Date(returnSearchInDTO.getStartTimestamp()),
                        returnSearchInDTO.getEndTimestamp() == null ? null : new Date(returnSearchInDTO.getEndTimestamp()),
                        returnSearchInDTO.getStatus(),
                        returnSearchInDTO.getProductCode(),
                        returnSearchInDTO.getCustomerName(),
                        returnSearchInDTO.getProductName());
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        return null;
    }

    @Override
    public void update(Return aReturn) {

    }


}
