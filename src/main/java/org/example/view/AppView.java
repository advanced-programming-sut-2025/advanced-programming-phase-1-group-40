package org.example.view;

import org.example.models.App;
import org.example.models.enums.Menu;

import java.util.Scanner;

public class AppView {


    public static void runApp() {

        Scanner scanner = new Scanner(System.in);

        do{


            App.dataManager.getCurrentMenu().getMenu().getInput(scanner.nextLine().trim(),scanner);


        }while ( ! App.dataManager.getCurrentMenu().equals(Menu.EXIT) );



    }

}

