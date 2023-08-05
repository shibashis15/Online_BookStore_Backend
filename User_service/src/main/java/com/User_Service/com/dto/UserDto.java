package com.User_Service.com.dto;

import com.User_Service.com.model.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    @NotNull
    private String name;

    @NotNull
    @Email(message = "invalid email address")
    private String email;

    @NotNull
    private int phoneNumber;

    @NotNull
    private Address address;

}

