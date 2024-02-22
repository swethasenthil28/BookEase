package org.bookerbuddies.bookease.payment;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.account.AccountRepository;
import org.bookerbuddies.bookease.account.AccountService;
import org.bookerbuddies.bookease.account.exceptions.AccountNotFoundException;
import org.bookerbuddies.bookease.payment.dto.Cancellation;
import org.bookerbuddies.bookease.payment.exception.PaymentInsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public  class PaymentServiceImplementation implements PaymentService {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    AccountService accountService;



//    @Transactional(rollbackOn = { PaymentService.class })
    @Override
    public Double transaction(Integer senderId, Integer receiverId, Double amount) throws PaymentInsufficientBalanceException, AccountNotFoundException {


       Account fromAccount =  accountService.getAccountDetails(senderId);
       Account toAccount =  accountService.getAccountDetails(receiverId);

       if(amount > fromAccount.getBalance()){
           throw new PaymentInsufficientBalanceException("Insufficient Balance for account id : "+ fromAccount.getBalance());
       }

       fromAccount.setBalance(fromAccount.getBalance() - amount);
       toAccount.setBalance(toAccount.getBalance()+amount);
       accountRepository.save(fromAccount);
       accountRepository.save(toAccount);
       Payment newPayment = new Payment(1, fromAccount.getAccountId(), toAccount.getAccountId(),amount, Boolean.TRUE, "client");
       paymentRepository.save(newPayment);

       return  fromAccount.getBalance();

    }

    @Override
    public List<Payment> payments(String typeOfPerson, Integer id) {
        return paymentRepository.findByAccountTypeAndSenderId(typeOfPerson, id);
    }

    @Override
    public Double paymentsCancellation(Cancellation cancellation) throws AccountNotFoundException, PaymentInsufficientBalanceException {

        LocalDate bookingDate = cancellation.getBookingDate();
        LocalDate dateOfBooking = cancellation.getDataOfBooking();

        Integer dataOfDifference = dateOfBooking.compareTo(bookingDate);
        Double currentDate =  (double) LocalDate.now().getDayOfMonth();

        Double interest = currentDate/ dataOfDifference ;

        Payment paymentDetails = paymentRepository.findBySenderid(cancellation.getClientId());

        Double amount =   paymentDetails.getAmount();

        Double refundAmount = amount*interest;

        Account clientAccount =  accountService.getAccountDetails(cancellation.getClientId());
        Account ownerAccount = accountService.getAccountDetails(cancellation.getOwnerId());

        if(ownerAccount.getBalance() < refundAmount){
            throw new PaymentInsufficientBalanceException("Insufficient Balance for account id : "+ownerAccount.getBalance());
        }

        clientAccount.setBalance(clientAccount.getBalance() + refundAmount);
        ownerAccount.setBalance(ownerAccount.getBalance() - refundAmount);

        accountRepository.save(clientAccount);
        accountRepository.save(ownerAccount);


        return refundAmount;
    }

    @Override
    public Boolean deleteExistingAccount(Integer accountId) throws AccountNotFoundException{
        return accountService.deleleAccount(accountId);
    }

}
