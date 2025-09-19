package Repository;

import Model.Score;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreRepository extends BaseRepository<Score, UUID> {
    public List<Score> findByPlayerId(UUID playerId) {
        return entities.stream()
                .filter(s -> s.getPlayerId().equals(playerId))
                .collect(Collectors.toList());
    }

    public List<Score> findByPlayerIdOrderByValueDesc(UUID playerId) {
        return entities.stream()
                .filter(s -> s.getPlayerId().equals(playerId))
                .sorted(Comparator.comparingInt(Score::getValue).reversed())
                .collect(Collectors.toList());
    }

    public List<Score> findTopScores(int limit) {
        return entities.stream()
                .sorted(Comparator.comparingInt(Score::getValue).reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Optional<Score> findHighestScoreByPlayerId(UUID playerId) {
        return entities.stream()
                .filter(s -> s.getPlayerId().equals(playerId))
                .max(Comparator.comparingInt(Score::getValue));
    }

    public List<Score> findByValueGreaterThan(Integer minValue) {
        return entities.stream()
                .filter(s -> s.getValue() > minValue)
                .collect(Collectors.toList());
    }

    public List<Score> findAllByOrderByCreatedAtDesc() {
        return entities.stream()
                .sorted(Comparator.comparing(Score::getCreatedAt).reversed())
                .collect(Collectors.toList());
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        return entities.stream()
                .filter(s -> s.getPlayerId().equals(playerId))
                .mapToInt(Score::getCoinsCollected)
                .sum();
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId) {
        return entities.stream()
                .filter(s -> s.getPlayerId().equals(playerId))
                .mapToInt(Score::getDistanceTravelled)
                .sum();
    }

    @Override
    public void save(Score score) {
        storage.put(score.getId(), score);
        entities.add(score);
    }

    @Override
    protected UUID getId(Score entity) {
        return entity.getId();
    }
}