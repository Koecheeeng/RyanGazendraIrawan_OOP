package com.koecheng.backend.repository;

import com.koecheng.backend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    Optional<Player> findByUsername(String username);
    boolean existsByUsername(String username);

    List<Player> findTop10ByOrderByHighScoreDesc();
    List<Player> findAllByOrderByTotalCoinsDesc();
    List<Player> findAllByOrderByTotalDistanceTravelledDesc();
}