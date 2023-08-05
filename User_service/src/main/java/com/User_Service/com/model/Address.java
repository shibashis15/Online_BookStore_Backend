package com.User_Service.com.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    private String line1;
    private String line2;
    private String city;
    private String state;
    private int pincode;
}
