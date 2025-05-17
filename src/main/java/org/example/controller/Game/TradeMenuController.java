package org.example.controller.Game;

import org.example.models.*;


public class TradeMenuController {
    public Result trade(String username, String typeStr, String itemName, String amountStr, String priceStr,
                        String targetItemName, String targetAmountStr) {
        User player = App.dataManager.getCurrentUser();
        if (username.equals(player.getUsername())) {
            return new Result(false, "You can't trade with yourself.");
        }

        Game game = App.dataManager.getCurrentGame();

        User targetUser = game.getPlayerByUsername(username);
        if (targetUser == null) {
            return new Result(false, "User not found.");
        }

        if (!amountStr.matches("\\d+")) {
            return new Result(false, "Invalid amount.");
        }
        int amount = Integer.parseInt(amountStr);

        // TODO: Item item = ...
//        if (item == null) {
//            return new Result(false, "Item not found.");
//        }

        boolean isOffer = typeStr.equals("offer");
        if (priceStr != null) {
            int price = Integer.parseInt(priceStr);
            if (targetItemName != null) {
                return new Result(false, "You can only trade with money or item and not both.");
            }
            // TODO
        }
        return new Result(true, "");
    }

    public Result showTradeList() {
        return new Result(true, "");
    }

    public Result tradeResponse(String response, String idStr) {
        return new Result(true, "");
    }

    public Result showTradeHistory() {
        return new Result(true, "");

    }
}
