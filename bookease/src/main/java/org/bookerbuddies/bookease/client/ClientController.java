package org.bookerbuddies.bookease.client;

import org.bookerbuddies.bookease.client.dto.Login;
import org.bookerbuddies.bookease.client.dto.RegisterAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
@Autowired
private ClientService clientService;
@PostMapping("client")
public Client createNewClient(@RequestBody RegisterAccount registerAccount) throws ClientException {
    return this.clientService.newRegistration(registerAccount);
}

//@GetMapping("login/{email}/{password}")
//public Client clientlogin(@PathVariable("email") String email,@PathVariable("password") String password) throws ClientException {
//    return this.clientService.login(email,password);
//}

@PostMapping("client/login")
public Client clientLogin(@RequestBody Login login) throws ClientException {
    return this.clientService.loginPage(login.getEmail(),login.getPassword());
}

@GetMapping("client{id}")
public Client getClientbyId(Integer clientId) throws ClientException {
        return this.clientService.getClientbyId(clientId);

}

}
