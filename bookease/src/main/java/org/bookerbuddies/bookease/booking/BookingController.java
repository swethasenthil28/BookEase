package org.bookerbuddies.bookease.booking;

import org.bookerbuddies.bookease.booking.exceptions.BookingNotFoundException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomRepository;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;
//
    @PostMapping("addBookingInMeetingRoom/{meetingRoomId}")
    public Boolean addBookingInMeetingRoom(@RequestBody Booking booking,@RequestParam Integer meetingRoomId ) throws MeetingRoomAlreadyExistException, MeetingRoomNotFoundException {
        return bookingService.addBooking(booking, meetingRoomId);
    }
    @GetMapping("bookingsByMeetingRoom/{meetingRoomId}")
    public Booking getBookingByMeetingRoom(@RequestParam Integer meetingRoomId) throws BookingNotFoundException {
        return bookingService.getBookingForMeetingRoom(meetingRoomId);
    }

    @PatchMapping("cancelBookingByMeetingRoomId/{meetingRoomId}")
    public Boolean cancelBooking(@RequestParam Integer meetingRoomId) throws MeetingRoomNotFoundException {
        bookingService.cancelBooking(meetingRoomId);
        return true;
    }
}
