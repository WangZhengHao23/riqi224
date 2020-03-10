package io.wzh.jcartadministrationback.service;

import io.wzh.jcartadministrationback.pogo.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {
    List<ReturnHistory> getistByreturnId(Integer returnId);

    Long create(ReturnHistory returnHistory);
}
