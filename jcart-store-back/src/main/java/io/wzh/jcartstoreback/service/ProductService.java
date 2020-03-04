package io.wzh.jcartstoreback.service;


import com.github.pagehelper.Page;
import io.wzh.jcartstoreback.dto.out.ProductListOutDTO;
import io.wzh.jcartstoreback.dto.out.ProductShowOutDTO;
import io.wzh.jcartstoreback.po.Product;

public interface ProductService {

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);

    Page<ProductListOutDTO> search(Integer pageNum);


}
