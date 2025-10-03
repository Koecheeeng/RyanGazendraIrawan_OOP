package Repository;

import Model.Score;
import java.util.*;
import java.util.stream.Collectors;

public class ScoreRepository extends BaseRepository<Score, UUID> {

    @Override
    protected UUID getId(Score entity) {
        return entity.getId();
    }

    public List<Score> findByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .collect(Collectors.toList());
    }

    public List<Score> findByPlayerIdOrderByValueDesc(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .collect(Collectors.toList());
    }

    public List<Score> findTopScores(int limit) {
        return allData.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .limit(limit)
                .collect(Collectors.toList());
    }

    public Optional<Score> findHighestScoreByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .max(Comparator.comparingInt(Score::getValue));
    }

    public List<Score> findByValueGreaterThan(int minValue) {
        return allData.stream()
                .filter(score -> score.getValue() > minValue)
                .collect(Collectors.toList());
    }

    public List<Score> findAllByOrderByCreatedAtDesc() {
        return allData.stream()
                .sorted((s1, s2) -> Long.compare(s2.getCreatedAt(), s1.getCreatedAt()))
                .collect(Collectors.toList());
    }

    public int getTotalCoinsByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getCoinsCollected)
                .sum();
    }

    public int getTotalDistanceByPlayerId(UUID playerId) {
        return allData.stream()
                .filter(score -> score.getPlayerId().equals(playerId))
                .mapToInt(Score::getDistanceTravelled)
                .sum();
    }
}