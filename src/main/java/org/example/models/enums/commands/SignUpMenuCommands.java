package org.example.models.enums.commands;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.regex.Matcher;

public enum SignUpMenuCommands implements Command{
    REGISTER_USER("\\s*register\\s+-u\\s+(?<username>.+)\\s+-p\\s+(?<password>.+)\\s+(?<repeatPassword>.+)\\s+-n\\s+(?<nickname>.+)\\s+-e\\s+(?<email>.+)\\s+-g\\s+(?<gender>.+)\\s*"),
    ;

    private String command;

    SignUpMenuCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    @Override
    public Matcher getMatcher(String input) {
        return null;
    }
}
