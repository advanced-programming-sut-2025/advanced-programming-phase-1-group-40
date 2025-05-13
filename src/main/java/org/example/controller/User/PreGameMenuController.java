package org.example.controller.User;

import org.example.models.App;
import org.example.models.Result;
import org.example.models.Player;
import org.example.models.Game;
import org.example.models.persistence.DataManager;


public class PreGameMenuController {
    public Result startGame() {
        Player currentPlayer = DataManager.getInstance().getCurrentPlayer();
        
        // Check if player is already in a game
        Game existingGame = DataManager.getInstance().getGameForPlayer(currentPlayer.getUsername());
        if (existingGame != null) {
            // Set as current game
            DataManager.getInstance().setCurrentGame(existingGame);
            return new Result(true, "Continuing existing game!");
        }
        
        // Create a new single-player game
        Player[] players = {currentPlayer};
        Game newGame = DataManager.getInstance().createNewGame(players);
        newGame.setCreator(currentPlayer);
        newGame.setCurrentTurnPlayer(currentPlayer);
        
        return new Result(true, "New game started!");
    }

    public Result loadGame() {
        Player currentPlayer = App.getCurrentPlayer();
        
        Game savedGame = DataManager.getInstance().loadGameForPlayer(currentPlayer.getUsername());
        if (savedGame == null) {
            return new Result(false, "No saved game found.");
        }
        
        return new Result(true, "Game loaded successfully!");
    }

    public Result exitGame() {
        DataManager.getInstance().exitCurrentGame();
        return new Result(true, "Exiting Game...");
    }

    public Result gameOver() {
        return new Result(true, "Game Over!");
    }
}




