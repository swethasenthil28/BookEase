package org.bookerbuddies.bookease.booking;

import jakarta.persistence.*;
import lombok.*;
import org.bookerbuddies.bookease.feedback.FeedBack;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.payment.Payment;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDate bookingDate;
    private LocalDate bookedDate;
    private Boolean status;
    private String eventDescription;

    @OneToOne
    private Payment payment;
    @OneToOne
    private FeedBack feedBack;
   }
