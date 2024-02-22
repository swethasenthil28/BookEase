package org.bookerbuddies.bookease;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.payment.PaymentService;
import org.bookerbuddies.bookease.payment.PaymentServiceImplementation;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BookeaseApplicationTests {




    PaymentServiceImplementation paymentService = new PaymentServiceImplementation();



//    @Test()
//    public void when_transaction_is_called_with_sender_and_receiver_id_with_amount_then_it_should_debit_amount_from_client_and_add_amount_to_owner(){
//
//
//        Account client = new Account(1, "Jack", 5000.0, "Client");
//        Account owner  = new Account(2, "Aman", 7000.0, "Owner");
//        List<Double> expected = paymentService.transaction(client.getAccountId(), owner.getAccountId(), 1000.0);
//
//
//    }

}
