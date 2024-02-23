package org.bookerbuddies.bookease.meetingroom;

import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MeetingRoomController {
    @Autowired
    private MeetingRoomService meetingRoomService;
    @GetMapping("meetingrooms")
    public List<MeetingRoom> getAllMeetingRooms(){
        return meetingRoomService.getAllMeetingRooms();
    }


    @GetMapping("meetingroom/{meetingRoomId}")
    public MeetingRoom getMeetingRoomById(@RequestParam Integer meetingRoomId) throws MeetingRoomNotFoundException {
        return meetingRoomService.getMeetingRoomById(meetingRoomId);
    }

    @GetMapping("availableMeetingRoomByDateAndType/{bookingdate}/{type}")
    public List<MeetingRoom> getAvailableMeetingRoomsByDateAndType(@RequestParam LocalDate bookingDate,@RequestParam String type){
        return meetingRoomService.getAllMeetingRoomsByDateAndType(bookingDate,type);
    }
}