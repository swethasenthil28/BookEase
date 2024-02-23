package org.bookerbuddies.bookease.meetingroom;

import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRoomService {
    public List<MeetingRoom> getAllMeetingRooms();
    public MeetingRoom getMeetingRoomById(Integer meetingRoomId) throws MeetingRoomNotFoundException;
    public Boolean addBookingInMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistException;
    public Boolean updateBookingInMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomNotFoundException;
    public List<MeetingRoom> getAllMeetingRoomsByDateAndType(LocalDate bookingDate,String type);


}
