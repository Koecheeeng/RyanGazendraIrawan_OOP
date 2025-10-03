package Service;

import Model.Player;
import Repository.PlayerRepository;

import java.util.*;

public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public boolean existsByUsername(String username) {
        return playerRepository.existsByUsername(username);
    }

    public Player createPlayer(Player player) {
        if (existsByUsername(player.getUsername())) {
            throw new RuntimeException("Username already registered");
        }
        playerRepository.save(player);
        return player;
    }

    public Player getPlayerById(UUID playerId) {
        return playerRepository.findById(playerId).orElse(null);
    }

    public Player getPlayerByUsername(String username) {
        return playerRepository.findByUsername(username).orElse(null);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player updatePlayer(UUID playerId, Player updatedPlayer) {
        Player existing = getPlayerById(playerId);
        if (existing == null) {
            throw new RuntimeException("Player not found");
        }
        if (!existing.getUsername().equals(updatedPlayer.getUsername())
                && existsByUsername(updatedPlayer.getUsername())) {
            throw new RuntimeException("Username already taken");
        }
        existing.setUsername(updatedPlayer.getUsername());
        existing.setHighScore(updatedPlayer.getHighScore());
        existing.setTotalCoins(updatedPlayer.getTotalCoins());
        existing.setTotalDistance(updatedPlayer.getTotalDistance());
        return existing;
    }

    public void deletePlayer(UUID playerId) {
        playerRepository.deleteById(playerId);
    }

    public void deletePlayerByUsername(String username) {
        Player player = getPlayerByUsername(username);
        if (player != null) {
            playerRepository.deleteById(player.getId());
        }
    }

    public Player updatePlayerStats(UUID playerId, int scoreValue, int coinsCollected, int distanceTravelled) {
        Player player = getPlayerById(playerId);
        if (player == null) {
            throw new RuntimeException("Player not found");
        }
        if (scoreValue > player.getHighScore()) {
            player.setHighScore(scoreValue);
        }
        player.setTotalCoins(player.getTotalCoins() + coinsCollected);
        player.setTotalDistance(player.getTotalDistance() + distanceTravelled);
        return player;
    }

    public List<Player> getLeaderboardByHighScore(int limit) {
        return playerRepository.findTopPlayersByHighScore(limit);
    }

    public List<Player> getLeaderboardByTotalCoins() {
        return playerRepository.findAllByOrderByTotalCoinsDesc();
    }

    public List<Player> getLeaderboardByTotalDistance() {
        return playerRepository.findAllByOrderByTotalDistanceTravelledDesc();
    }
}