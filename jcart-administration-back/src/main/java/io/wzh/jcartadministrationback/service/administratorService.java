package io.wzh.jcartadministrationback.service;

import com.github.pagehelper.Page;

import io.wzh.jcartadministrationback.pogo.Administrator;
import org.springframework.stereotype.Service;

import java.util.List;

public interface administratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update(Administrator administrator);

}
