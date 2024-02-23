package org.bookerbuddies.bookease.booking.exceptions;

import org.bookerbuddies.bookease.meetingroom.exceptions.MeetingRoomAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class BookingNotFoundAdvice {

        @ExceptionHandler(value = {BookingNotFoundException.class})
        public ResponseEntity<String> bookingNotFoundExceptionHandler(BookingNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

}
