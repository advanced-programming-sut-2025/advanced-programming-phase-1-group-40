package org.example;

import org.example.models.App;
import org.example.view.AppView;

public class Main {
    public static void main(String[] args) {
        // Load all data at startup
        App.loadAllData();

        // Run the application
        AppView.runApp();

        // Save all data before exiting
        App.saveAllData();
    }
}
