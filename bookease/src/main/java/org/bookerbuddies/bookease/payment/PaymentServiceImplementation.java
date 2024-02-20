package org.bookerbuddies.bookease.payment;

import jakarta.transaction.Transactional;
import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.account.AccountRepository;
import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImplementation implements PaymentService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PaymentRepository paymentRepository;


//    @Transactional(rollbackOn = { PaymentService.class })
    @Override
    public Double transaction(Integer senderId, Integer receiverId, Double amount) throws PaymentInsufficientBalance{

        Account fromAccount =  accountRepository.findByAccountId(senderId);
       Account toAccount =  accountRepository.findByAccountId(receiverId);

       if(amount > fromAccount.getBalance()){
           throw new PaymentInsufficientBalance("Insufficient Balance");
       }

       fromAccount.setBalance(fromAccount.getBalance() - amount);
       toAccount.setBalance(toAccount.getBalance()+amount);
       accountRepository.save(fromAccount);
       accountRepository.save(toAccount);

       Payment newPayment = new Payment(1, fromAccount.getAccountId(), toAccount.getAccountId(), amount, Boolean.TRUE);
       paymentRepository.save(newPayment);

       return  fromAccount.getBalance();
    }
}
