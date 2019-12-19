package com.bhanu.ibapsych.controller;

import java.util.List;

import com.bhanu.ibapsych.form.FieldError;
import com.bhanu.ibapsych.form.PlayerRegForm;
import com.bhanu.ibapsych.form.exception.FieldDoNotExistException;
import com.bhanu.ibapsych.form.exception.FieldExistsException;
import com.bhanu.ibapsych.model.user.Player;
import com.bhanu.ibapsych.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @PostMapping("/register")
    List<FieldError> register(@RequestParam(value = "email") String email,
            @RequestParam(value = "username") String username, @RequestParam(value = "password") String password)
            throws FieldExistsException, FieldDoNotExistException {
        // Create player from from request body values
        PlayerRegForm form = new PlayerRegForm(email, username, password);

        // TODO encapsulate into transaction as read and write from players table
        List<FieldError> errors = form.validate();

        // No errors
        if (errors.size() == 0) {
            // create user
            // TODO hash password for protection
            playerRepository.save(form.createPlayer());
        }

        return errors;
    }
}