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
        this.highScore = 0;
        this.totalCoins = 0;
        this.totalDistance = 0;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(int totalCoins) {
        this.totalCoins = totalCoins;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", highScore=" + highScore +
                ", totalCoins=" + totalCoins +
                ", totalDistance=" + totalDistance +
                '}';
    }
}