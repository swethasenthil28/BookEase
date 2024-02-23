package org.bookerbuddies.bookease.meetingroom;

import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class MeetingRoomServiceImpl implements MeetingRoomService{
    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    @Override
    public List<MeetingRoom> getAllMeetingRooms(){
        return this.meetingRoomRepository.findAll();
    }

    @Override
    public MeetingRoom getMeetingRoomById(Integer meetingRoomId) throws MeetingRoomNotFoundException{
        Optional<MeetingRoom> meetingRoom =this.meetingRoomRepository.findById(meetingRoomId);
        if(meetingRoom.isEmpty()){
            throw  new MeetingRoomNotFoundException("Room with id : "+ meetingRoomId+" does not exist");
        }
        return  meetingRoom.get();
    }
    @Override
    public Boolean addBookingInMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomAlreadyExistException {
        if(meetingRoom.getIsAvailable().equals(false)){
            throw new MeetingRoomAlreadyExistException("Meeting room with Id "+meetingRoom.getId()+" already exist");
        }
        meetingRoom.setIsAvailable(false);

        this.meetingRoomRepository.save(meetingRoom);

        return true;

    }

    @Override
    public Boolean updateBookingInMeetingRoom(MeetingRoom meetingRoom) throws MeetingRoomNotFoundException {
        if(meetingRoom.getId()==null){
            throw new MeetingRoomNotFoundException("Meeting Room Not found");
        }
        meetingRoomRepository.save(meetingRoom);
        return true;
    }

    @Override
    public List<MeetingRoom> getAllMeetingRoomsByDateAndType(LocalDate bookingDate, String type) {
        return this.meetingRoomRepository.findByDateAndType(bookingDate,type)
                .stream()
                .filter(meetingRoom -> meetingRoom.getIsAvailable().equals(true))
                .collect(Collectors.toList());
    }
}
