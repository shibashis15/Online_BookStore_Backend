package com.User_Service.com.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotNull
    @Column(name = "user_name")
    private String username;

    @NotNull
    @Email(message = "Invalid Email! ")
    @Column(name = "user_email")
    private String email;

    @NotNull
    @Column(name = "user_password")
    private String password;

    @NotNull
    @Column(name = "user_phoneNumber")
    private int phoneNumber;

    @Embedded
    @Column(name = "user_address")
    private Address address;

}
