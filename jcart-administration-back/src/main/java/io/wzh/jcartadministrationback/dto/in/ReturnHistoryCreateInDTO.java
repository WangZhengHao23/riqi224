package io.wzh.jcartadministrationback.dto.in;

public class ReturnHistoryCreateInDTO {
    private Integer returnId;
    private Byte returnStatus;
    private Boolean customerNotifeid;
    private String comment;
    private  Boolean CustomerNotified;

    public Boolean getCustomerNotified() {
        return CustomerNotified;
    }

    public void setCustomerNotified(Boolean customerNotified) {
        CustomerNotified = customerNotified;
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Byte getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Byte returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Boolean getCustomerNotifeid() {
        return customerNotifeid;
    }

    public void setCustomerNotifeid(Boolean customerNotifeid) {
        this.customerNotifeid = customerNotifeid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
