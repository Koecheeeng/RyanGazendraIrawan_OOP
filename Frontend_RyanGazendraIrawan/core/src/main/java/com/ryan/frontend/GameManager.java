package com.ryan.frontend;
import com.ryan.frontend.observers.ScoreManager;

public class GameManager {
    private static GameManager instance;

    private ScoreManager scoreManager;
    private boolean gameActive;

    private GameManager() {
        scoreManager = new ScoreManager();
        gameActive = false;
        int backendService;
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void startGame() {
        scoreManager.setScore(0);
        gameActive = true;
        System.out.println("Game Started!");
    }

    public void setScore(int newScore) {
        if (gameActive) {
            scoreManager.setScore(newScore);
        }
    }

    // Getters
    public int getScore() { return scoreManager.getScore(); }

    // Delegate observer methods to ScoreManager
    public void addObserver(com.ryan.frontend.observers.Observer observer) {
        scoreManager.addObserver(observer);
    }

    public void removeObserver(com.ryan.frontend.observers.Observer observer) {
        scoreManager.removeObserver(observer);
    }

    private void backendService;
    private String currentPlayerId null;
    private int coinsCollected = 0;

    public registerPlayer(String username) {
    }

    backendService.createPlayer (String username);
    backendService.BackendService.RequestCallback();
}
