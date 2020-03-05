package io.wzh.jcartadministrationback.dto.out;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class OrderListOutDTO {
    private Long orderId;
    private Integer customerId;
    private String customerName;
    private Byte status;
    private Double totalPirce;
    private Long createTimestamp;
    private Long updateTimestamp;
    private Integer rewordPoints;
    @JsonIgnore
    private Date createTIme;
    @JsonIgnore
    private Date updateTime;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalPirce() {
        return totalPirce;
    }

    public void setTotalPirce(Double totalPirce) {
        this.totalPirce = totalPirce;
    }

    public Long getCreateTimestamp() {
        return this.createTimestamp==null?null:this.createTIme.getTime();
    }



    public Long getUpdateTimestamp() {
        return this.updateTimestamp==null?null:this.updateTime.getTime();
    }


    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getRewordPoints() {
        return rewordPoints;
    }

    public void setRewordPoints(Integer rewordPoints) {
        this.rewordPoints = rewordPoints;
    }

    public Date getCreateTIme() {
        return createTIme;
    }

    public void setCreateTIme(Date createTIme) {
        this.createTIme = createTIme;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
