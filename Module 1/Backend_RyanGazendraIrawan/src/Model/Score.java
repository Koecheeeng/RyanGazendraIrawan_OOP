package Model;

import java.util.Date;
import java.util.UUID;

public class Score {
    private UUID id;
    private UUID playerId;
    private int value;
    private int coinsCollected;
    private int distanceTravelled;
    private Date createdAt;

    public Score(UUID playerId, int value, int coinsCollected, int distanceTravelled) {
        this.id = UUID.randomUUID();
        this.playerId = playerId;
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distanceTravelled = distanceTravelled;
        this.createdAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public int getValue() {
        return value;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Score: " + value + ", Coins: " + coinsCollected + ", Distance: " + distanceTravelled;
    }
}
