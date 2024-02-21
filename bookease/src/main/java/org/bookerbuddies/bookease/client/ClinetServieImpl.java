package org.bookerbuddies.bookease.client;

import org.bookerbuddies.bookease.account.Account;
import org.bookerbuddies.bookease.account.AccountRepository;
import org.bookerbuddies.bookease.client.dto.Login;
import org.bookerbuddies.bookease.client.dto.RegisterAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinetServieImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Client newRegistration(RegisterAccount registerAccount) throws ClientException{
        Account account = new Account(registerAccount.getAccountId(), registerAccount.getName(), registerAccount.getBalance(), "client");
        account = this.accountRepository.save(account);
        Client client = new Client(registerAccount.getClientId(), registerAccount.getEmail(), registerAccount.getPassword(), registerAccount.getName(), account);
        client = this.clientRepository.save(client);
        account.setClient(client);
        System.out.println("========"+client+"======="+account);
        accountRepository.save(account);
        return client;
    }


    @Override
    public Client loginPage(String email, String password) throws ClientException{
        Client client= this.clientRepository.findByEmailAndPassword(email, password);
        return client;
    }

//    @Override
//    public Client login(String email, String password) throws ClientException
//    {
//        System.out.println(this.clientRepository.findAll());
//        Client client=this.clientRepository.findByEmailAndPassword(email,password);
//        System.out.println("-====-"+client);
//        if(client==null)
//            throw new ClientException("The Account Doesn't exist");
//        if(client.getEmail()==null && client.getPassword()!=null)
//            throw new ClientException("You have not entered the Email Id.");
//        if(client.getEmail()!=null && client.getPassword()==null)
//            throw new ClientException("You have not entered the Password.");
//        return client;
//    }


    @Override
    public Client getClientbyId(Integer clientId) throws ClientException{
        return this.clientRepository.findById(clientId).get();
    }

}
