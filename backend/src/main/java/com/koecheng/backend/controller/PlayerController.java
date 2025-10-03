package com.koecheng.backend.controller;


import com.koecheng.backend.model.Player;
import com.koecheng.backend.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/players")

public class PlayerController {

    @Autowired
    private PlayerService playerService();

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayerById() {
        if (player.isPresent) {
            return ResponseEntity.ok(player.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/username/{username}")
    public Optional<Player> getPlayerByUsername(UUID username) {
        return playerRepository.findByUsername(username);
    }

    @GetMapping
    public checkUsername(playerService.isUsernameExists(username)) {
        return checkUsername(PlayerService.isUsernameExists(username));
    }
}
