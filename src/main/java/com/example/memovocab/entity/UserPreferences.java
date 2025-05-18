package com.example.memovocab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_preferences", schema="memo-vocab")
public class UserPreferences extends BaseEntity {

    @Id
    private int id;

    @Column(name="user_id")
    private int userId;

    private String email;

    @Column(name="phone_number")
    private String phoneNumber;
}
