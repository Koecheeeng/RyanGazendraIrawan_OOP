import Model.Player;
import Model.Score;
import Repository.PlayerRepository;
import Repository.ScoreRepository;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        PlayerRepository playerRepo = new PlayerRepository();
        ScoreRepository scoreRepo = new ScoreRepository();

        Player player1 = new Player("Jokowi");
        Player player2 = new Player("Gibran");
        Player player3 = new Player("Ahok");
        Player player4 = new Player("Anies");

        playerRepo.save(player1);
        playerRepo.save(player2);
        playerRepo.save(player3);
        playerRepo.save(player4);

        player1.updateHighScore(1500);
        player1.addCoins(250);
        player1.addDistance(5000);

        player2.updateHighScore(3200);
        player2.addCoins(750);
        player2.addDistance(12000);

        player3.updateHighScore(2400);
        player3.addCoins(500);
        player3.addDistance(6000);

        player4.updateHighScore(1800);
        player4.addCoins(300);
        player4.addDistance(4000);

        scoreRepo.save(new Score(player2.getId(), 1500, 250, 5000));
        scoreRepo.save(new Score(player4.getId(), 3200, 750, 12000));
        scoreRepo.save(new Score(player1.getId(), 4000, 400, 32000));
        scoreRepo.save(new Score(player4.getId(), 1800, 300, 6000));
        scoreRepo.save(new Score(player3.getId(), 2400, 240, 2400));
        scoreRepo.save(new Score(player2.getId(), 6200, 320, 5000));
        scoreRepo.save(new Score(player4.getId(), 1800, 60, 1200));
        scoreRepo.save(new Score(player1.getId(), 2100, 200, 7000));
        scoreRepo.save(new Score(player1.getId(), 8000, 720, 6200));
        scoreRepo.save(new Score(player3.getId(), 1900, 210, 4200));

        System.out.println("=== TESTING CS3 ===");
        System.out.println("Find player by ID:");
        System.out.println(playerRepo.findById(player3.getId()).get());

        System.out.println("All players:");
        playerRepo.findAll().forEach(System.out::println);

        System.out.println("Sorted by Highscore:");
        playerRepo.findTopPlayersByHighScore(10).forEach(System.out::println);

        System.out.println("Scores for player1:");
        scoreRepo.findByPlayerId(player1.getId()).forEach(System.out::println);
    }
}
