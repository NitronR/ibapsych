package com.bhanu.ibapsych.repository;

import com.bhanu.ibapsych.model.user.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}