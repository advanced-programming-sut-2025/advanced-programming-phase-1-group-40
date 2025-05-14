package org.example.models.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum GameMenuCommands implements Command {

    GO_TO_MAIN_MENU("\\s*menu\\s+enter\\s+(m|M)ain(\\s+(M|m)enu)?\\s*"),
    NEW_GAME("game\\s+new\\s+-u\\s+(?<user1>\\S*\\s+)?(?<user2>\\S*\\s+)?(?<user3>\\S+)?"),
    SHOW_CURRENT_MENU("\\s*menu\\s+show\\s+menu\\s*");

    private final String regexString;

    GameMenuCommands(String regexString){
        this.regexString = regexString;
    }

    @Override
    public Matcher getMatcher(String input) {

        Matcher matcher = Pattern.compile(regexString).matcher(input);

        if (matcher.matches()) return matcher;

        return null;
    }

}
