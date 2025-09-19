package Model;

import java.util.UUID;

public class Player {
    private UUID id;
    private String username;
    private int highScore;
    private int totalCoins;
    private int totalDistance;

    public Player(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public int getHighScore() {
        return highScore;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void updateHighScore(int score) {
        if (score > this.highScore) {
            this.highScore = score;
        }
    }

    public void addCoins(int coins) {
        this.totalCoins += coins;
    }

    public void addDistance(int distance) {
        this.totalDistance += distance;
    }

    @Override
    public String toString() {
        return username + " (Score: " + highScore + ", Coins: " + totalCoins + ", Distance: " + totalDistance + ")";
    }
}
