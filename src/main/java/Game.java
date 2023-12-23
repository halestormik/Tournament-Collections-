import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Game {
    HashMap<String, Player> hashPlayers = new HashMap<>(); // список игроков

    public Player findByName(String playerName) { // поиск игрока по имени в списке игроков
        
        if (hashPlayers.containsKey(playerName)) {
            return hashPlayers.get(playerName);
        }
        return null;
    }

    public void register(String playerName, Player player) { // метод регистрации игрока на турнир
        hashPlayers.put(playerName, player);
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
