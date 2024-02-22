package org.bookerbuddies.bookease.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AccountControlAdvice {
    @ExceptionHandler(value = {AccountNotFoundException.class})
    public ResponseEntity<String> accountExceptionHandler(AccountNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {AccountAlreadyExistException.class})
    public ResponseEntity<String> accountExceptionHandler(AccountAlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }



}
