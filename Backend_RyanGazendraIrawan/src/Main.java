import Model.Player;
import Model.Score;
import Repository.PlayerRepository;
import Repository.ScoreRepository;
import Service.PlayerService;
import Service.ScoreService;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepository = new PlayerRepository();
        ScoreRepository scoreRepository = new ScoreRepository();

        PlayerService playerService = new PlayerService(playerRepository);
        ScoreService scoreService = new ScoreService(scoreRepository, playerRepository, playerService);

        System.out.println("=== CS 4 ===\n");

        Player player1 = new Player("NanaBanana");
        Player player2 = new Player("Yingko");
        Player player3 = new Player("LegdontWork");

        playerService.createPlayer(player1);
        playerService.createPlayer(player2);
        playerService.createPlayer(player3);

        System.out.println("Players created\n");
        playerService.getAllPlayers().forEach(System.out::println);

        Score score1 = new Score(player1.getId(), 1500, 50, 3000);
        Score score2 = new Score(player1.getId(), 2000, 75, 4500);
        Score score3 = new Score(player2.getId(), 1800, 60, 3500);
        Score score4 = new Score(player3.getId(), 1200, 40, 2500);
        Score score5 = new Score(player3.getId(), 2500, 90, 5000);

        scoreService.createScore(score1);
        scoreService.createScore(score2);
        scoreService.createScore(score3);
        scoreService.createScore(score4);
        scoreService.createScore(score5);

        System.out.println("Scores created!\n");
        System.out.println("Player Score:");
        playerService.getAllPlayers().forEach(System.out::println);

        System.out.println("Top 2 players by high score");
        playerService.getLeaderboardByHighScore(2).forEach(System.out::println);

        System.out.println("All scores for " + player1.getUsername() + ":");
        scoreService.getScoresByPlayerId(player1.getId()).forEach(System.out::println);

        System.out.println("Top 3 scores overall:");
        scoreService.getLeaderboard(3).forEach(System.out::println);

        System.out.println("Searching for player 'NanaBanana':");
        Player found = playerService.getPlayerByUsername("NanaBanana");
        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Player not found!");
        }

        System.out.println("Totals for " + player3.getUsername() + ":");
        System.out.println("Total coins: " + scoreService.getTotalCoinsByPlayerId(player3.getId()));
        System.out.println("Total distance: " + scoreService.getTotalDistanceByPlayerId(player3.getId()));

        System.out.println("Recent scores (ordered by creation time):");
        scoreService.getRecentScores().forEach(System.out::println);
    }
}
