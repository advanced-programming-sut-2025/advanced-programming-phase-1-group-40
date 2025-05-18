package org.example.view.menu;

import org.example.controller.Game.GameController;
import org.example.models.App;
import org.example.models.Game;
import org.example.models.Player;
import org.example.models.User;
import org.example.models.enums.SecurityQuestion;
import org.example.models.enums.enviroment.Time;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeTest {
//    private static Time time;

    private static GameController gameController = new GameController();
    private static Game game;
    @BeforeAll
    static void setUp() {
        Player creator = new Player(new User("username1","password1","nickname1","email1","male", SecurityQuestion.FIRST_PET,"firstpet1"));
        Player player2 = new Player(new User("username2","password2","nickname2","email2","male", SecurityQuestion.FIRST_PET,"firstpet2"));
        Player player3 = new Player(new User("username3","password3","nickname3","email3","male", SecurityQuestion.FIRST_PET,"firstpet3"));
        Player player4 = new Player(new User("username4","password4","nickname4","email4","male", SecurityQuestion.FIRST_PET,"firstpet4"));

        game = new Game(creator,new ArrayList<>(List.of(creator,player2,player3,player4)));
        App.dataManager.setCurrentGame(game);
        App.dataManager.addGame(game);
    }

    @Test
    void testShowTimeCommand() {
        String result = gameController.showTime();
        assertEquals("Time is: " + game.getTime().getHour(), result);
    }

    @Test
    void testShowDateCommand() {
        String result = gameController.showDate();
        assertEquals("Date is: " + game.getTime().getYear() + "." +
                (game.getTime().getMonth().getMonthIndex()+1) + "." +
                game.getTime().getDate(), result);
    }

    @Test
    void testShowDatetimeCommand() {
        String result = gameController.showDateTime();
        assertEquals("Date is: " + game.getTime().getYear() + "." +
                (game.getTime().getMonth().getMonthIndex()+1) + "." +
                game.getTime().getDate() + " And " +"Time is: " + game.getTime().getHour(), result);
    }

    @Test
    void testShowDayOfTheWeekCommand() {
        String result = gameController.showDayOfTheWeek();
        assertEquals("Today is: " + game.getTime().getWeekday().getDayName(), result);
    }

    @Test
    void testShowSeasonCommand() {
        String result = gameController.showSeason();
        assertEquals("Current Season is: " + game.getTime().getSeason().getName(), result);
    }

    @Test
    void testCheatTimeCommand() {
        String result = gameController.showSeason();
        assertEquals("Current Season is: " + game.getTime().getSeason().getName(), result);
    }


}
