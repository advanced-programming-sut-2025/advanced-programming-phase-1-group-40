package org.example.controller.Game;

import org.example.models.*;


public class TradeMenuController {

    public Result tradeWithMoney(String targetUsername, String type, String itemName, int amount, int price) { // type?

         Player targetPlayer =

        return new Result(true, "");
    }

    public Result tradeWithItem(String targetUsername, String type, String itemName, int amount, String targetItemName, int targetAmount) { // type?
        // TODO: create a Trade class; int ID, User user1, User user2, Hashmap<Item, Integer>
        return new Result(true, "");
    }

    public Result showTradeList(){
        return new Result(true, "");
    }

    public Result AorRtrade(){
        return new Result(true, "");
    }


}
