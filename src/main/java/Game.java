import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>(); // список игроков

    public Player findByName(String playerName) { // поиск игрока по имени в списке игроков

        for (int i = 0; i < players.size(); i++) {

            if (playerName.equals(players.get(i).getName())) {
                return players.get(i);
            }
        }
        return null;
    }

    public void register(Player player) { // метод регистрации игрока на турнир
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(playerName1);
        } else if (findByName(playerName2) == null) {
            throw new NotRegisteredException(playerName2);
        }

        int player1Strength = findByName(playerName1).getStrength();
        int player2Strength = findByName(playerName2).getStrength();
        if (player1Strength > player2Strength) {
            return 1;
        } else if (player1Strength < player2Strength) {
            return 2;
        }
        return 0;
    }
}
