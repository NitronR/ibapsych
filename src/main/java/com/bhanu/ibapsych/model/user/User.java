package com.bhanu.ibapsych.model.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue
    protected Long Id;

    @NotBlank
    protected String email;

    @NotBlank
    protected String username;

    @NotBlank
    protected String password;
}