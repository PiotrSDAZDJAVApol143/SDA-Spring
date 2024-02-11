package com.example.springrestapp.client;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.pl.PESEL;

@Builder
@Getter
@Setter
public class Client {
    @NotNull(message = "first name cannot be null")
    @Size(min = 2,max = 20)
    private String firstName;
    @NotNull(message = "last name cannot be null")
    @Size(min = 2,max = 25)
    private String lastName;
    @NotNull(message = "email cannot be null")
    @Email
    private String email;
    @NotNull(message = "Phone number cannot be null")
    private String phoneNumber;
    @Range(min = 1900, max =2016)
    private Integer yearOfBirth;
    @PESEL
    private String pesel;
    @AssertTrue(message = "Client is Premium")
    private Boolean isPremium;



}
