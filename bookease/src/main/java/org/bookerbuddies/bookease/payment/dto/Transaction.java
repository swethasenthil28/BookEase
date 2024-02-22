package org.bookerbuddies.bookease.payment.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Transaction {
    private Integer senderId;
    private Integer receiverId;
    private Double amount;

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
