package Model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Score implements ShowDetail {
    private final UUID scoreId;
    private final UUID playerId;
    private String player;
    private int value;
    private int coinsCollected;
    private int distance;
    private final LocalDateTime createdAt;

    public Score(UUID playerId, int value, int coinsCollected, int distance) {
        this.scoreId = UUID.randomUUID();
        this.playerId = playerId;
        this.value = value;
        this.coinsCollected = coinsCollected;
        this.distance = distance;
        this.createdAt = LocalDateTime.now();
    }

    public int getValue() {
        return value;
    }

    public int getCoinsCollected() {
        return coinsCollected;
    }

    public int getDistance() {
        return distance;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    @Override
    public void showDetail() {
        System.out.print("\nScore ID : " + scoreId);
        System.out.print("\nPlayer ID : " + playerId);
        System.out.print("\nCoins Collected : " + coinsCollected);
        System.out.print("\nDistance : " + distance);
        System.out.print("\nCreated At : " + createdAt);
        System.out.print("\n-   -   -");
    }
}