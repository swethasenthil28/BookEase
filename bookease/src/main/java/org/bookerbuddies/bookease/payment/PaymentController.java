package org.bookerbuddies.bookease.payment;


import org.bookerbuddies.bookease.account.exceptions.AccountNotFoundException;
import org.bookerbuddies.bookease.payment.dto.Cancellation;
import org.bookerbuddies.bookease.payment.dto.Transaction;
import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PatchMapping("payment")
    public Double makePayment(@RequestBody Transaction transaction)throws PaymentInsufficientBalanceException, AccountNotFoundException {

        Double senderBalanceAmount = paymentService.transaction(transaction.getSenderId(), transaction.getReceiverId(), transaction.getAmount());
        return senderBalanceAmount;
    }

    @GetMapping("getPayments/{type}/{id}")
    public List<Payment> getAllPlayment(@PathVariable  String type,@PathVariable Integer id){
        return paymentService.payments(type, id);
    }

    @GetMapping("cancellation")
    public Double bookingCancellation(@RequestBody Cancellation cancellation) throws AccountNotFoundException, PaymentInsufficientBalanceException{
        return paymentService.paymentsCancellation(cancellation);

    }

    @DeleteMapping("deleteAccount")
    public Boolean deleteAccount(Integer accountId) throws AccountNotFoundException{
        return paymentService.deleteExistingAccount(accountId);
    }







}
