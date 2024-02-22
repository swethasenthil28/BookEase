package org.bookerbuddies.bookease.payment;

import org.bookerbuddies.bookease.account.exceptions.AccountNotFoundException;
import org.bookerbuddies.bookease.payment.dto.Cancellation;
import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalanceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {

    Double transaction(Integer senderId, Integer receiverId, Double amount) throws PaymentInsufficientBalanceException, AccountNotFoundException;

    List<Payment> payments(String typeOfPerson, Integer id );


    Double paymentsCancellation(Cancellation cancellation) throws AccountNotFoundException, PaymentInsufficientBalanceException;


    Boolean deleteExistingAccount(Integer accountId) throws AccountNotFoundException;
}