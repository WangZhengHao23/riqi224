package io.wzh.jcartadministrationback.controller;

import com.github.pagehelper.Page;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.wzh.jcartadministrationback.dto.in.OrderSearchInDTO;
import io.wzh.jcartadministrationback.dto.out.*;
import io.wzh.jcartadministrationback.dto.out.*;
import io.wzh.jcartadministrationback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin

public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                              @RequestParam(required = false, defaultValue = "1") Integer pageNum) {
        Page<OrderListOutDTO> page = orderService.search(pageNum);
        PageOutDTO<OrderListOutDTO> pageOutDTO=new PageOutDTO<>();
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setList(page);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId) {
        return null;
    }

    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(@RequestParam Long orderId) {
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(@RequestParam Long orderId) {
        return null;
    }

}
