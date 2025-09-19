package Repository;

import Model.Player;
import java.util.*;
import java.util.stream.Collectors;

public class PlayerRepository extends BaseRepository<Player, UUID> {
    public Optional<Player> findByUsername(String username) {
        return entities.stream().filter(p -> p.getUsername().equals(username)).findFirst();
    }

    public List<Player> findTopPlayersByHighScore(int limit) {
        return entities.stream()
                .sorted(Comparator.comparingInt(Player::getHighScore).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Player> findByHighscoreGreaterThan(int minScore) {
        return entities.stream()
                .filter(p -> p.getHighScore() > minScore)
                .collect(Collectors.toList());
    }

    public List<Player> findAllByOrderByTotalCoinsDesc() {
        return entities.stream()
                .sorted(Comparator.comparingInt(Player::getTotalCoins).reversed())
                .collect(Collectors.toList());
    }

    public List<Player> findAllByOrderByTotalDistanceTravelledDesc() {
        return entities.stream()
                .sorted(Comparator.comparingInt(Player::getTotalDistance).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public void save(Player player) {
        storage.put(player.getId(), player);
        entities.add(player);
    }

    @Override
    protected UUID getId(Player entity) {
        return entity.getId();
    }
}
