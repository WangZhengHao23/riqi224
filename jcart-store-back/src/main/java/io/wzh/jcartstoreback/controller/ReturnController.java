package io.wzh.jcartstoreback.controller;

import com.github.pagehelper.Page;
import io.wzh.jcartstoreback.dto.in.ReturnAppLyDTO;
import io.wzh.jcartstoreback.dto.out.PageOutDTO;
import io.wzh.jcartstoreback.dto.out.ReturnHistoryListOutDTO;
import io.wzh.jcartstoreback.dto.out.ReturnListOutDTO;
import io.wzh.jcartstoreback.dto.out.ReturnShowOutDTO;
import io.wzh.jcartstoreback.enumeration.ReturnStatus;
import io.wzh.jcartstoreback.po.Return;
import io.wzh.jcartstoreback.po.ReturnHistory;
import io.wzh.jcartstoreback.service.ReturnHistoryService;
import io.wzh.jcartstoreback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {
    @Autowired
    private ReturnService returnService;

    @Autowired
    private ReturnHistoryService returnHistoryService;
    @PostMapping("/apply")
    public Integer app(@RequestBody ReturnAppLyDTO returnAppLyDTO,
                       @RequestAttribute Integer customerId){
        Return areturn = new Return();
        areturn.setOrderId(returnAppLyDTO.getOrderId());
        areturn.setOrderTime(new Date(returnAppLyDTO.getOrderTimestamp()));
        areturn.setCustomerId(customerId);
        areturn.setCustomerName(returnAppLyDTO.getCustomerName());
        areturn.setMobile(returnAppLyDTO.getMobile());
        areturn.setEmail(returnAppLyDTO.getEmail());
        areturn.setStatus((byte) ReturnStatus.ToGetbackProduct.ordinal());
        areturn.setProductCode(returnAppLyDTO.getProductCode());
        areturn.setProductName(returnAppLyDTO.getProductNmae());
        areturn.setQuantity(returnAppLyDTO.getQuantity());
        areturn.setReason(returnAppLyDTO.getReason());
        areturn.setOpened(returnAppLyDTO.getOpened());
        areturn.setComment(returnAppLyDTO.getComment());
        Date date=new Date();
        areturn.setCreateTime(date);
        areturn.setUpdateTime(date);
        returnService.create(areturn);
        Integer returnId = areturn.getReturnId();
        return returnId;
    }

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam Integer pageNum){
        Page<Return> page = returnService.getpageById(customerId, pageNum);
        List<ReturnListOutDTO> returnListOutDTOS = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            return returnListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(returnListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return aReturn = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();
        returnShowOutDTO.setReturnId(aReturn.getReturnId());
        returnShowOutDTO.setOrderId(aReturn.getOrderId());
        returnShowOutDTO.setOrderTimestamp(aReturn.getOrderTime().getTime());
        returnShowOutDTO.setCustomerName(aReturn.getCustomerName());
        returnShowOutDTO.setMobile(aReturn.getMobile());
        returnShowOutDTO.setEmail(aReturn.getEmail());
        returnShowOutDTO.setStatus(aReturn.getStatus());
        returnShowOutDTO.setAction(aReturn.getAction());
        returnShowOutDTO.setProductCode(aReturn.getProductCode());
        returnShowOutDTO.setProductName(aReturn.getProductName());
        returnShowOutDTO.setQuantity(aReturn.getQuantity());
        returnShowOutDTO.setReason(aReturn.getReason());
        returnShowOutDTO.setComment(aReturn.getComment());
        returnShowOutDTO.setOpened(aReturn.getOpened());
        returnShowOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(aReturn.getUpdateTime().getTime());

        List<ReturnHistory> returnHistories = returnHistoryService.getByReturnId(returnId);
        List<ReturnHistoryListOutDTO> returnHistoryListOutDTOS = returnHistories.stream().map(returnHistory -> {
            ReturnHistoryListOutDTO returnHistoryListOutDTO = new ReturnHistoryListOutDTO();
            returnHistoryListOutDTO.setTimestamp(returnHistory.getTime().getTime());
            returnHistoryListOutDTO.setReturnStatus(returnHistory.getReturnStatus());
            returnHistoryListOutDTO.setComment(returnHistory.getComment());
            return returnHistoryListOutDTO;
        }).collect(Collectors.toList());
        returnShowOutDTO.setReturnHistories(returnHistoryListOutDTOS);

        return returnShowOutDTO;
    }

    @PostMapping("/cancel")
    public void cancel(@RequestBody Integer returnId){

    }

}
