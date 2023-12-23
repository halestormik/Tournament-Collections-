import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class GameTest {
    Player player1 = new Player(1, "Иванов", 15);
    Player player2 = new Player(2, "Петров", 12);
    Player player3 = new Player(3, "Сидоров", 10);
    Player player4 = new Player(4, "Папанов", 17);
    Player player5 = new Player(5, "Лебедев", 12);

    @Test
    public void shouldWinFirstPlayer() { // выигрывает первый игрок
        Game tournament = new Game();

        tournament.register(player1.getName(), player1);
        tournament.register(player2.getName(), player2);

        int expected = 1;
        int actual = tournament.round(player1.getName(), player2.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecondPlayer() { // выигрывает второй игрок
        Game tournament = new Game();

        tournament.register(player3.getName(), player3);
        tournament.register(player4.getName(), player4);

        int expected = 2;
        int actual = tournament.round(player3.getName(), player4.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeDraw() { // ничья в турнире
        Game tournament = new Game();

        tournament.register(player2.getName(), player2);
        tournament.register(player5.getName(), player5);

        int expected = 0;
        int actual = tournament.round(player2.getName(), player5.getName());

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWarnIfNotRegisteredFirstPlayer() { // первый игрок не зарегистрирован
        Game tournament = new Game();

        tournament.register(player2.getName(), player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> tournament.round(player1.getName(), player2.getName()));
    }

    @Test
    public void shouldWarnIfNotRegisteredSecondPlayer() { // второй игрок не зарегистрирован
        Game tournament = new Game();

        tournament.register(player1.getName(), player1);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> tournament.round(player1.getName(), player2.getName()));
    }
}
