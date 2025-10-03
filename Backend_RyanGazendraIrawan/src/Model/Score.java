package Model;

import java.util.UUID;

public class Score {
    private UUID id;
    private UUID playerId;
    private int value;
    private int coinsCollected;
    private int distanceTravelled;
    private long createdAt;

    public Score(UUID playerId, int value, int coinsCollected, int distanceTravelled) {
        this.id = UUID.randomUUID();
        this.playerId = playerId;
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distanceTravelled = distanceTravelled;
        this.createdAt = System.currentTimeMillis();
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

    public void setValue(int value) {
        this.value = value;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public void setCoinsCollected(int coinsCollected) {
        this.coinsCollected = coinsCollected;
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", playerId=" + playerId +
                ", value=" + value +
                ", coinsCollected=" + coinsCollected +
                ", distanceTravelled=" + distanceTravelled +
                ", createdAt=" + createdAt +
                '}';
    }
}