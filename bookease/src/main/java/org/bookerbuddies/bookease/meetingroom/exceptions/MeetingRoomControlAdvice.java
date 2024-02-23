package org.bookerbuddies.bookease.meetingroom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MeetingRoomControlAdvice {
        @ExceptionHandler(value = {MeetingRoomAlreadyExistException.class})
        public ResponseEntity<String> meetingRoomExceptionHandler(MeetingRoomAlreadyExistException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


