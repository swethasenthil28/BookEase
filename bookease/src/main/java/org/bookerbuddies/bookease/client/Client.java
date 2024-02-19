package org.bookerbuddies.bookease.client;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.booking.Booking;
import org.bookerbuddies.bookease.payment.Payment;

import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Client {

    private String name;
    @Id
    private Integer id;
    private String email;
    private String password;
    @OneToMany
    List<Booking> bookings = new ArrayList<>();
    @OneToOne
    private Account account;
    @OneToOne
    private Payment payment;

}