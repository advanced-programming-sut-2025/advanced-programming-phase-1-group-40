package org.example.view;

import org.example.controller.Game.*;
import org.example.controller.User.*;
import org.example.models.App;
import org.example.models.User;
import org.example.models.enums.Menu;

import java.util.Scanner;

public class AppView {


    public static void runApp() {

        Scanner scanner = new Scanner(System.in);

        do{


            App.getCurrentMenu().getMenu().getInput(scanner.nextLine(),scanner);


        }while ( ! App.getCurrentMenu().equals(Menu.EXIT) );



    }

}

