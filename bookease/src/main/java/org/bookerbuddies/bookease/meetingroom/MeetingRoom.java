package org.bookerbuddies.bookease.meetingroom;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.bookerbuddies.bookease.booking.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Getter
@Setter
public class MeetingRoom {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer capacity;
    private Integer floorNumber;
    private String type;//enumerated datatype
    private LocalDate date;
    private Double costOfRoom;
    private Boolean isAvailable;
    @OneToOne
    private Booking  booking;

}
