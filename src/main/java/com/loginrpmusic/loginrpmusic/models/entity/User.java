package com.loginrpmusic.loginrpmusic.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(name = "secondName")
    private  String secondName;

    @Column(length = 8, unique = true)
    private Long phoneNumber;

    private String password;

    @Column(unique = true)
    private String email;
}
