package org.bookerbuddies.bookease.client.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterAccount {
    private Integer accountId;
    private String name;
    private Double balance;

    private Integer clientId;
    private String email;
    private String password;
}
