package org.example.models.enums.commands;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.regex.Matcher;

public enum ProfileCommands implements Command {

    CHANGE_USERNAME("\\s*change\\s+username\\s+-u\\s+(?<username>\\S+)\\s*"),
    CHANGE_NICKNAME("\\s*change\\s+nickname\\s+-u\\s+(?<nickname>\\S+)\\s*"),
    CHANGE_EMAIL("\\s*change\\s+email\\s+-e\\s+(?<email>\\S+)\\s*"),
    CHANGE_PASSWORD("\\s*change\\s+password\\s+-p\\s+(?<oldPassword>\\S+)\\s+-o\\s+(?<newPassword>\\S+)\\s*"),
    SHOW_USER_INFO("\\s*user\\s+info\\s*"),
    GO_TO_MAIN_MENU("\\s*menu\\s+enter\\s+(m|M)ain(\\s+(M|m)enu)?\\s*"),
    SHOW_CURRENT_MENU("\\s*show\\s+current\\s+menu\\s*");

    private final String regex;

    ProfileCommands(String regex) {
        this.regex = regex;
    }

    @Override
    public Matcher getMatcher(String input) {
        return null;
    }
}
