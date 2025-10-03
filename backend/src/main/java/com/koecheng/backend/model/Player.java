package com.koecheng.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "player_id")
    private UUID playerId;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "high_score")
    private Integer highScore = 0;

    @Column(name = "total_coins")
    private Integer totalCoins = 0;

    @Column(name = "total_distance_travelled")
    private Integer totalDistanceTravelled = 0;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public Player() {}

    public Player(String username) {
        this.username = username;
        this.highScore = 0;
        this.totalCoins = 0;
        this.totalDistanceTravelled = 0;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void setPlayerId(UUID playerId) {
        this.playerId = playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    public Integer getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(Integer totalCoins) {
        this.totalCoins = totalCoins;
    }

    public Integer getTotalDistanceTravelled() {
        return totalDistanceTravelled;
    }

    public void setTotalDistanceTravelled(Integer totalDistanceTravelled) {
        this.totalDistanceTravelled = totalDistanceTravelled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void updateHighScore(Integer newScore) {
        if (newScore != null && (this.highScore == null || newScore > this.highScore)) {
            this.highScore = newScore;
        }
    }

    public void addCoins(Integer coins) {
        if (coins != null) {
            this.totalCoins += coins;
        }
    }

    public void addDistance(Integer distance) {
        if (distance != null) {
            this.totalDistanceTravelled += distance;
        }
    }
}