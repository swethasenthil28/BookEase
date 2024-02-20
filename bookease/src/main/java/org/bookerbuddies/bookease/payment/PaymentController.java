package org.bookerbuddies.bookease.payment;


import org.aspectj.lang.annotation.SuppressAjWarnings;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    PaymentService paymentService;


    @PatchMapping("payment/")
    public Double makePayment(@PathVariable Integer senderId,@PathVariable Integer recieverId,@PathVariable Double amount)throws PaymentInsufficientBalance {


        Double senderBalanceAmount = paymentService.transaction(senderId, recieverId, amount);

        return senderBalanceAmount;
    }





}
