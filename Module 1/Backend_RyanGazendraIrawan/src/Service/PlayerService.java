package Service;

import Model.Player;
import Repository.PlayerRepository;

public class PlayerService extends PlayerRepository {
    public boolean existsByUsername(String username) {

    }

    public Player createPlayer(Player player) {

    }

    public Optional<Player> getPlayerById(UUID playerId) {

    }

    public Optional<Player> getPlayerByUsername(String username) {

    }

    public List<Player> getAllPlayer() {

    }

    public Player updatePlayer(UUID playerID, Player updatedPlayer) {

    }

    public void deletePlayer(UUID playerID) {

    }

    public Player updatePlayerStats(UUID playerId, int scoreValue, int coinsCollected, int distanceTravelled) {

    }

    public void deletePlayerByUsername(String username) {

    }

    public List<Player> getLeaderboardByHighScore(int limit) {

    }

    public Optional<Player> getPlayerByld(UUID playerId) {

    }

    private List<Player> leaderboardByTotalCoins() {

    }

    private List<Player> leaderboardByTotalDistance() {

    }

    private List<Player> allPlayers() {

    }
}
