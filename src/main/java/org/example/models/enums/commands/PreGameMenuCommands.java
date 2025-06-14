package org.example.models.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum PreGameMenuCommands implements Command {

    GO_TO_MAIN_MENU("\\s*menu\\s+enter\\s+(m|M)ain(\\s+(M|m)enu)?\\s*"),
    NEW_GAME("\\s*game\\s+new\\s+-u(?<users>.+)?\\s*"),
    SELECT_MAP("\\s*game\\s+map\\s+(?<mapNumber>\\S+)\\s*"),
    SHOW_CURRENT_MENU("\\s*show\\s+current\\s+menu\\s*"),
    LOAD_GAME("\\s*load\\s+game\\s*"),
    SHOW_MAP("\\s*show\\s+map\\s*");

    private final String regexString;

    PreGameMenuCommands(String regexString){
        this.regexString = regexString;
    }

    public String getRegexString() {
        return regexString;
    }

    @Override
    public Matcher getMatcher(String input) {

        Matcher matcher = Pattern.compile(regexString).matcher(input);

        if (matcher.matches()) return matcher;

        return null;
    }

}
