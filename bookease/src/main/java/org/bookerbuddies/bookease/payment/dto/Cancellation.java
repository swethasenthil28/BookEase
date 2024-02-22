package org.bookerbuddies.bookease.payment.dto;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor



public class Cancellation {

    private Integer clientId;
    private Integer ownerId;
    private LocalDate dataOfBooking;
    private LocalDate bookingDate;


    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public LocalDate getDataOfBooking() {
        return dataOfBooking;
    }

    public void setDataOfBooking(LocalDate dataOfBooking) {
        this.dataOfBooking = dataOfBooking;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
}
