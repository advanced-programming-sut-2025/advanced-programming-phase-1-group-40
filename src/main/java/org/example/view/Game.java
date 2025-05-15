package org.example.view;


import org.example.controller.Game.GameController;
import org.example.models.enums.commands.GameCommands;


import java.util.Scanner;

public class Game implements AppMenu {

    private final GameController gameController = new GameController();

    @Override
    public void getInput(String input, Scanner scanner) {


        ///  TIME & DATE

        if (GameCommands.SHOW_TIME.getMatcher(input) != null) {


            System.out.println(gameController.showTime());


        }
        else if (GameCommands.SHOW_DATE.getMatcher(input) != null) {


            System.out.println(gameController.showDate());


        }
        else if (GameCommands.SHOW_DATETIME.getMatcher(input) != null) {


            System.out.println(gameController.showDateTime());


        }
        else if (GameCommands.SHOW_DAY_OF_THE_WEEK.getMatcher(input) != null) {


            System.out.println(gameController.showDayOfTheWeek());


        }
        else if (GameCommands.CHEAT_ADVANCE_TIME.getMatcher(input) != null) {


            System.out.println(gameController.cheatAdvanceTime(GameCommands.CHEAT_ADVANCE_TIME.getMatcher(input).group("time")).message());


        }
        else if (GameCommands.CHEAT_ADVANCE_DATE.getMatcher(input) != null) {


            System.out.println(gameController.cheatAdvanceDate(GameCommands.CHEAT_ADVANCE_DATE.getMatcher(input).group("date")).message());


        }
        else if (GameCommands.SHOW_SEASON.getMatcher(input) != null) {


            System.out.println(gameController.showSeason());


        }


        ///  WEATHER

        else if ( GameCommands.CHEAT_THOR.getMatcher(input) != null ) {



        }
        else if ( GameCommands.SHOW_WEATHER.getMatcher(input) != null ) {}
        else if ( GameCommands.SHOW_WEATHER_FORECAST.getMatcher(input) != null ) {}
        else if ( GameCommands.CHEAT_WEATHER_SET.getMatcher(input) != null ) {}


        ///  DAMDARI
        else if (GameCommands.BUILD.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if ( GameCommands.BUY_ANIMAL.getMatcher(input) != null) {


            System.out.println(gameController.buyAnimal(GameCommands.BUY_ANIMAL.getMatcher(input)).message());


        }
        else if (GameCommands.PET.getMatcher(input) != null) {


            System.out.println(gameController.petAnimal(GameCommands.PET.getMatcher(input)).message());


        }
        else if (GameCommands.CHEAT_SET_FRIENDSHIP.getMatcher(input) != null) {


            System.out.println(gameController.cheatSetFriendship(GameCommands.CHEAT_SET_FRIENDSHIP.getMatcher(input)).message());


        }
        else if (GameCommands.SHOW_ANIMAL_INFO.getMatcher(input) != null) {


            gameController.showAnimalInfo(GameCommands.SHOW_ANIMAL_INFO.getMatcher(input));

        }
        else if (GameCommands.SHEPHERD_ANIMALS.getMatcher(input) != null) {


            System.out.println(gameController.shepherd(GameCommands.SHEPHERD_ANIMALS.getMatcher(input)).message());


        }
        else if (GameCommands.FEED_HAY.getMatcher(input) != null) {


            System.out.println(gameController.feedWithHay(GameCommands.FEED_HAY.getMatcher(input)).message());


        }
        else if (GameCommands.SHOW_UNCOLLECTED_PRODUCTS.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.COLLECT_PRODUCTS.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SELL_ANIMAL.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.FISHING.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SELL_ANIMAL.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.FISHING.getMatcher(input) != null) {


            System.out.println("build new building");


        }

        ///  ARTISAN

        else if (GameCommands.ARTISAN_USE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.ARTISAN_GET.getMatcher(input) != null) {


            System.out.println("build new building");


        }

        ///  SHOP

        else if (GameCommands.SHOW_ALL_PRODUCTS_IN_STORE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_AVAILABLE_PRODUCTS_IN_STORE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.PURCHASE_ITEM.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.CHEAT_ADD_MONEY.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SELL_ITEM.getMatcher(input) != null) {


            System.out.println("build new building");


        }


        /// TAAMOLAT VA RAVABET BA DIGAR BAZIKONAN

        else if (GameCommands.SHOW_FRIENDSHIP.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.TALK_WITH_OTHERS.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_TALK_HISTORY.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.GIVE_GIFT_TO_OTHERS.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_RECEIVED_GIFTS.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.RATE_GIFT.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.GIFT_HISTORY_WITH_USER.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.HUG_USER.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.FLOWER_USER.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.ASK_MARRIAGE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.RESPOND_TO_MARRIAGE.getMatcher(input) != null) {


            System.out.println("build new building");


        }

        /// NPC

        else if (GameCommands.MEET_NPC.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.GIFT_NPC.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_FRIENDSHIP_WITH_NPC.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_QUESTS_LIST.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.FINISH_QUESTS.getMatcher(input) != null) {


            System.out.println("build new building");


        }






    }

    


}
