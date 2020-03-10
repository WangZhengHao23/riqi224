package io.wzh.jcartadministrationback.service.impl;

import io.wzh.jcartadministrationback.dao.ReturnHistoryMapper;
import io.wzh.jcartadministrationback.pogo.Return;
import io.wzh.jcartadministrationback.pogo.ReturnHistory;
import io.wzh.jcartadministrationback.service.ReturnHistoryService;
import io.wzh.jcartadministrationback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {
    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Autowired
    private ReturnService returnService;

    @Override
    public List<ReturnHistory> getistByreturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectListByReturnId(returnId);
        return returnHistories;
    }

    @Override
    @Transactional
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return aReturn = new Return();
        aReturn.setReturnId(returnHistory.getReturnId());
        aReturn.setUpdateTime(new Date());
        returnService.update(aReturn);

        return returnHistoryId;
    }
}
