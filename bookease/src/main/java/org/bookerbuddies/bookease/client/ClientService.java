package org.bookerbuddies.bookease.client;

import org.bookerbuddies.bookease.client.dto.Login;
import org.bookerbuddies.bookease.client.dto.RegisterAccount;

public interface ClientService {
    Client newRegistration(RegisterAccount registerAccount) throws ClientException;
//    Client login(String email, String password) throws ClientException;

    Client loginPage(String email, String password) throws ClientException;

    Client getClientbyId(Integer clientId)throws ClientException;

}
