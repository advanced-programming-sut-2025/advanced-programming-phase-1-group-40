package org.example;

import org.example.models.DataManager;
import org.example.view.AppView;

public class Main {
    public static void main(String[] args) {
        // Load all data at startup directly from DataManager
        DataManager.getInstance().loadAllData();

        // Run the application
        AppView.runApp();

        // Save all data before exiting directly from DataManager
        DataManager.getInstance().saveAllData();
    }
}
