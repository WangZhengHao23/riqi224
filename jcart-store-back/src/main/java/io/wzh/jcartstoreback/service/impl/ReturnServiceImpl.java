package io.wzh.jcartstoreback.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.wzh.jcartstoreback.dao.ReturnMapper;
import io.wzh.jcartstoreback.po.Return;
import io.wzh.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;
    @Override
    public Integer create(Return aReturn) {
        returnMapper.insertSelective(aReturn);
        Integer returnid = aReturn.getReturnId();
        return returnid;
    }

    @Override
    public Page<Return> getpageById(Integer customerId, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Return> page = returnMapper.selectPageByCustomerId(customerId);
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }
}
