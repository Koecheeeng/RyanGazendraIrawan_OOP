package com.ryan.frontend;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.ryan.frontend.observers.Observer;
import com.ryan.frontend.observers.ScoreManager;
import com.ryan.frontend.services.BackendService;

public class GameManager {
    private static GameManager instance;

    private ScoreManager scoreManager;
    private boolean gameActive;

    private BackendService backendService;
    private String currentPlayerId = null;
    private int coinsCollected = 0;

    private GameManager() {
        scoreManager = new ScoreManager();
        gameActive = false;

        backendService = new BackendService();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        scoreManager.setScore(0);

        coinsCollected = 0;

        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int distance) {
        if (gameActive) {
            scoreManager.setScore(distance);
        }
    }

    public void registerPlayer(String username) {
        backendService.createPlayer(username, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                try {
                    JsonValue root = new JsonReader().parse(response);

                    currentPlayerId = root.getString("playerId");

                    Gdx.app.log("GameManager", "Player registered successfully. ID: " + currentPlayerId);
                } catch (Exception e) {
                    Gdx.app.error("GameManager", "Failed to parse player registration response", e);
                }
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Failed to register player: " + error);
            }
        });
    }

    public void endGame() {
        gameActive = false;

        if (currentPlayerId == null) {
            Gdx.app.error("GameManager", "Cannot submit score: Player ID is null.");
            return;
        }

        int distanceScore = scoreManager.getScore();

        int finalScore = distanceScore + (coinsCollected * 10);

        backendService.submitScore(currentPlayerId, finalScore, coinsCollected, distanceScore, new BackendService.RequestCallback() {
            @Override
            public void onSuccess(String response) {
                Gdx.app.log("GameManager", "Score submitted successfully. Final Score: " + finalScore);
            }

            @Override
            public void onError(String error) {
                Gdx.app.error("GameManager", "Failed to submit score: " + error);
            }
        });
    }

    public void addCoin() {
        coinsCollected++;

        Gdx.app.log("GameManager", "COIN COLLECTED! Total: " + coinsCollected);
    }

    public int getScore() { return scoreManager.getScore(); }

    public int getCoins() { return coinsCollected; }

    public void addObserver(Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        scoreManager.removeObserver(observer);
    }
}
