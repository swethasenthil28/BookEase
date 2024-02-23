package org.bookerbuddies.bookease.meetingroom;

import org.bookerbuddies.bookease.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom,Integer> {
    List<MeetingRoom> findByDate(LocalDate date);
    List<MeetingRoom> findByDateAndType(LocalDate date,String type);
}
