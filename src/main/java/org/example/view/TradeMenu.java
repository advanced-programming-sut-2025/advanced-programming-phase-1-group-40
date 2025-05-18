package org.example.view;


import org.example.controller.Game.*;
import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.enums.commands.TradeMenuCommands;
import org.example.models.enums.commands.TradeMenuCommands;

import java.util.*;

public class TradeMenu implements AppMenu {

    private final TradeMenuController tradeMenuController = new TradeMenuController();


    @Override
    public void getInput(String input, Scanner scanner){

        if (TradeMenuCommands.TRADE_WITH_MONEY.getMatcher(input) != null) {


            System.out.println(tradeMenuController.tradeWithMoney(TradeMenuCommands.TRADE_WITH_MONEY.getMatcher(input)).message());


        }
        else if (TradeMenuCommands.TRADE_WITH_ITEM.getMatcher(input) != null) {


            System.out.println(tradeMenuController.tradeWithItem(TradeMenuCommands.TRADE_WITH_ITEM.getMatcher(input)).message());


        }
        else if (TradeMenuCommands.SHOW_TRADE_LIST.getMatcher(input) != null) {


            tradeMenuController.showTradeList();


        }
        else if (TradeMenuCommands.RESPOND_TO_TRADE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (TradeMenuCommands.SHOW_TRADE_HISTORY.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if ( TradeMenuCommands.EXIT_TRADE.getMatcher(input) != null ) {

            tradeMenuController.exitTradeMenu();

        }

        else {

            System.out.println("Invalid command");

        }


        System.out.printf("It is " + App.dataManager.getCurrentGame().getCurrentTurnPlayer().getUsername() + "'s turn: ");


    }

}
