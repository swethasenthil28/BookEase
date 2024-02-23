package org.bookerbuddies.bookease.booking;

import org.bookerbuddies.bookease.booking.exceptions.BookingNotFoundException;
import org.bookerbuddies.bookease.meetingroom.MeetingRoom;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomController;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomRepository;
import org.bookerbuddies.bookease.meetingroom.MeetingRoomService;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private MeetingRoomService meetingRoomService;


    @Override
    public Boolean addBooking(Booking booking,Integer meetingRoomId) throws MeetingRoomAlreadyExistException, MeetingRoomNotFoundException {
        this.bookingRepository.save(booking);
        MeetingRoom  meetingRoom=meetingRoomService.getMeetingRoomById(meetingRoomId);
        meetingRoom.setBooking(booking);
        Boolean meetingRoomStatus = meetingRoomService.addBookingInMeetingRoom(meetingRoom);
        if(meetingRoomStatus.equals(false)){
            return false;
        }
        return true;

    }
    @Override
    public Booking getBookingForMeetingRoom(Integer meetingRoomId) throws BookingNotFoundException {
        Optional<Booking> booking = this.bookingRepository.findById(meetingRoomId);
        if(booking.isEmpty()){
           throw new BookingNotFoundException("Booking not found for the meeting room with Id "+meetingRoomId);
        }
        return  booking.get();


    }

    @Override
    public Boolean cancelBooking(Integer meetingRoomId)  throws MeetingRoomNotFoundException {
         MeetingRoom meetingRoom =meetingRoomService.getMeetingRoomById(meetingRoomId);
         meetingRoom.setBooking(null);
         meetingRoom.setIsAvailable(true);
         meetingRoomService.updateBookingInMeetingRoom(meetingRoom);
         return true;

    }


}
