package com.example.gaswaterusagemonitoring.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name="users")
public class UserDb {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="user")
    private Long userId;

    private Long gas;

    private Long coldwater;

    private Long hotwater;
}
