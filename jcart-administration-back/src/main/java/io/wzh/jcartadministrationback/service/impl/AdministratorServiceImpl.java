package io.wzh.jcartadministrationback.service.impl;

import com.github.pagehelper.Page;
import io.wzh.jcartadministrationback.dao.AdministratorMapper;
import io.wzh.jcartadministrationback.dto.in.ProductCreateInDTO;
import io.wzh.jcartadministrationback.dto.in.ProductUpdateInDTO;
import io.wzh.jcartadministrationback.dto.out.ProductListOutDTO;
import io.wzh.jcartadministrationback.dto.out.ProductShowOutDTO;
import io.wzh.jcartadministrationback.pogo.Administrator;
import io.wzh.jcartadministrationback.service.administratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements administratorService {
    @Autowired
    private AdministratorMapper administratorMapper;
    @Override
    public Administrator getById(Integer administratorId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        return administrator;
    }

    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

}
