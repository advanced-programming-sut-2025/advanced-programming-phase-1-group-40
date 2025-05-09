package org.example.view;


import org.example.controller.Game.*;
import org.example.controller.User.*;
import org.example.models.enums.commands.GameCommands;


import java.util.Scanner;

public class GameMenu implements AppMenu {

    @Override
    public void getInput(String input, Scanner scanner) {


        if (GameCommands.BUILD.getMatcher(input) != null) {


            System.out.println("build new building");


        }


    }

    


}
