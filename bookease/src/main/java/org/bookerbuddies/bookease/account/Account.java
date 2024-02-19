package org.bookerbuddies.bookease.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookerbuddies.bookease.client.Client;
import org.bookerbuddies.bookease.owner.Owner;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private Integer accountId;
    private String name;
    private Double balance;
    private String role;
    @OneToOne
    private Owner owner;
    @OneToOne
    private Client client;

}
