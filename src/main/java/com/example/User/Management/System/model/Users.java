package com.example.User.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @NotNull
    @Column(name = "user_name")
    private String userName;
    @Column(name = "date_of_birth")
    private String dateOfBirth;
    @Column(name = "email")
    private String Email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "time")
    private LocalTime time;
}
