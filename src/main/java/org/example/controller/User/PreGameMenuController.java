package org.example.controller.User;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.Player;
import org.example.models.Game;
import org.example.models.DataManager;


public class PreGameMenuController {
    public Result startGame() {
        Player currentPlayer = (Player) App.dataManager.getCurrentUser();

        // Check if player is already in a game
        Game existingGame = App.dataManager.getGameForPlayer(currentPlayer.getUsername());
        if (existingGame != null) {
            // Set as current game
            App.dataManager.setCurrentGame(existingGame);
            return new Result(true, "Continuing existing game!");
        }

        // Create a new single-player game
        Player[] players = {currentPlayer};
        Game newGame = App.dataManager.createNewGame(players);
        newGame.setCreator(currentPlayer);
        newGame.setCurrentTurnPlayer(currentPlayer);

        return new Result(true, "New game started!");
    }

    public Result loadGame() {
        Player currentPlayer = App.dataManager.getCurrentPlayer();

        Game savedGame = App.dataManager.loadGameForPlayer(currentPlayer.getUsername());
        if (savedGame == null) {
            return new Result(false, "No saved game found.");
        }

        return new Result(true, "Game loaded successfully!");
    }

    public Result exitGame() {
        App.dataManager.exitCurrentGame();
        return new Result(true, "Exiting Game...");
    }

    public Result gameOver() {
        return new Result(true, "Game Over!");
    }
}




