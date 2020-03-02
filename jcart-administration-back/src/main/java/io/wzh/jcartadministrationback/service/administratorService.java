package io.wzh.jcartadministrationback.service;

import com.github.pagehelper.Page;

import io.wzh.jcartadministrationback.pogo.Administrator;
import org.springframework.stereotype.Service;

import java.util.List;

public interface administratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    Integer create(Administrator administrator);

    void update(Administrator administrator);

    void delete(Integer administratorId);

    void batchDelete(List<Integer> administratorIds);

    Page<Administrator> getList(Integer pageNum);

}
