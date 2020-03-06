package io.wzh.jcartstoreback.service;

import io.wzh.jcartstoreback.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService
{
    List<ReturnHistory> getByReturnId(Integer returnId);
}
