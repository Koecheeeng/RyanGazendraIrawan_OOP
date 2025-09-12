package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Player implements ShowDetail {
    private final UUID playerId;
    private final String username;
    private int highScore;
    private int totalDistance;
    private int totalCoins;
    private final LocalDateTime createdAt;

    public Player(String username) {
        this.playerId = UUID.randomUUID();
        this.username = username;
        this.createdAt = LocalDateTime.now();
        this.highScore = 0;
        this.totalCoins = 0;
        this.totalDistance = 0;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public void updateHighScore(int newScore) {
        if (newScore > this.highScore) {
            this.highScore = newScore;
        }
    }

    public void addCoins(int coins) {
        this.totalCoins += coins;
    }

    public void addDistance(int distance) {
        this.totalDistance += distance;
    }

    @Override
    public void showDetail() {
        System.out.print("\nPlayer ID : " + playerId);
        System.out.print("\nUsername : " + username);
        System.out.print("\nHigh Score : " + highScore);
        System.out.print("\nCoins Collected : " + totalCoins);
        System.out.print("\nDistance : " + totalDistance);
        System.out.print("\nCreated At : " + createdAt);
        System.out.print("-   -   -");
    }
}
