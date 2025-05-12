package org.example.view;

import org.example.controller.Game.*;
import org.example.controller.User.*;

import java.util.Scanner;

public interface AppMenu {

    public abstract void getInput(String input, Scanner scanner);
    public void run(Scanner scanner);
}