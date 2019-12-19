package com.bhanu.ibapsych.model.user;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "player")
public class Player extends User {
    private String psychPhotoURL;

    public Player(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
}