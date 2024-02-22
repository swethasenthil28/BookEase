package org.bookerbuddies.bookease.account;

import org.bookerbuddies.bookease.account.exceptions.AccountAlreadyExistException;
import org.bookerbuddies.bookease.account.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpementation implements  AccountService{

    @Autowired
    AccountRepository accountRepository;


    @Override
    public Account getAccountDetails(Integer id) throws AccountNotFoundException {
        Account accountDetails  =  accountRepository.findByAccountId(id);
        if(accountDetails == null){
            throw  new AccountNotFoundException("Account not found : "+id);
        }

        return accountDetails;

    }

    @Override
    public Boolean deleleAccount(Integer accountId) throws AccountNotFoundException{

        Optional<Account> userAccount =  accountRepository.findById(accountId);
        if(userAccount.isEmpty()){
            throw new AccountNotFoundException("Account does not exist with id : "+accountId);
        }



        accountRepository.deleteById(accountId);
        return true;
    }

    @Override
    public Account createNewAccount(Account newAccount) throws AccountAlreadyExistException {

        Optional<Account> foundAccount =  accountRepository.findById(newAccount.getAccountId());
        if(foundAccount.isPresent()){
            throw new AccountAlreadyExistException("Account with id : "+ newAccount.getAccountId()+" already exist");
        }

        return null;
    }
}
