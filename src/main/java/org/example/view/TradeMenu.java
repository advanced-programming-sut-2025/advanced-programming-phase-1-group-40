package org.example.view;


import org.example.controller.Game.*;
import org.example.controller.User.*;
import org.example.models.enums.commands.GameCommands;

import java.util.*;

public class TradeMenu implements AppMenu {

    @Override
    public void getInput(String input, Scanner scanner){

        if (GameCommands.START_TRADE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.TRADE_WITH_MONEY.getMatcher(input) != null) {


            System.out.println("build new building");


        }else if (GameCommands.TRADE_WITH_ITEM.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_TRADE_LIST.getMatcher(input) != null) {


            System.out.println("build new building");


        }else if (GameCommands.RESPOND_TO_TRADE.getMatcher(input) != null) {


            System.out.println("build new building");


        }
        else if (GameCommands.SHOW_TRADE_HISTORY.getMatcher(input) != null) {


            System.out.println("build new building");


        }

        else {

            System.out.println("Invalid command");

        }


    }

}
