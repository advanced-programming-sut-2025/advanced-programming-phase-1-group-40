package org.example.controller.User;

import org.example.models.Result;

public class PreGameMenuController {
    public Result startGame(){
        return new Result(true, "Game started!");
    }
    public Result loadGame(){
        return new Result(true, "Loading Game...");
}
    public Result exitGame(){
        return new Result(true, "Exiting Game...");}
}
    public Result gameOver(){
    return new Result(true, "Game Over!");
    }



