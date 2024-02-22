package org.bookerbuddies.bookease.account;

import org.bookerbuddies.bookease.account.exceptions.AccountAlreadyExistException;
import org.bookerbuddies.bookease.account.exceptions.AccountNotFoundException;

public interface AccountService {

    public Account getAccountDetails(Integer id) throws AccountNotFoundException;
    public Boolean deleleAccount(Integer accountId) throws AccountNotFoundException;
    
    public Account createNewAccount(Account newAccount) throws AccountAlreadyExistException;
    
}
