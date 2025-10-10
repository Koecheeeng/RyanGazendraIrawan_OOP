package com.koecheng.backend.service;

import com.koecheng.backend.model.Score;
import com.koecheng.backend.repository.ScoreRepository;
import com.koecheng.backend.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Transactional
    public Score createScore (Score score) {
        if (!playerService.playerExists(score.getPlayerId())) {
            throw new RuntimeException("No player has been found with ID : " + score.getPlayerId());
        }
    }

    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPLayerIdOrderByValueDesc(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        return scoreRepository.findTopScores(int limit);
    }

    public Optional<Score> getHighestScoreByPlayerId(UUID playerId) {
        List<Score> scores = scoreRepository.findHighestScoreByPlayerId(playerId);
        if (scores.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(scores.get(0));
    }

    public List<Score> getScoresAboveValue(Integer minValue) {
        return scoreRepository.findByValueGreaterThan(minValue);
    }

    public List<Score> getRecentScores() {
        return scoreRepository.findAllByOrderByCreatedAtDesc();
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId) {
        Integer total = scoreRepository.getTotalCoinsByPlayerId(playerId);
        return total != null ? total : 0;
    }

    public Integer getTotalDistanceByPlayerId(UUID playerId) {
        Integer total = scoreRepository.getTotalDistanceByPlayerId(playerId);
        return total != null ? total : 0;
    }
}

