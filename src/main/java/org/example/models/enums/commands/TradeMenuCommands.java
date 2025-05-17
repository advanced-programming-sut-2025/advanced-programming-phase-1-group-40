package org.example.models.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum TradeMenuCommands implements Command{

    TRADE_WITH_MONEY("\\s*trade\\s+-u\\s+(?<username>.+)\\s+-t\\s+(?<type>.+)\\s+-i\\s+(?<item>.+)\\s+-a\\s+(?<amount>.+)\\s+-p\\s+(?<price>.+)\\s*"),
    TRADE_WITH_ITEM("\\s*trade\\s+-u\\s+(?<username>.+)\\s+-t\\s+(?<type>.+)\\s+-i\\s+(?<item>.+)\\s+-a\\s+(?<amount>.+)\\s+-ti\\s+(?<targetItem>.+)\\s+-ta\\s+(?<targetAmount>.+)\\s*"),
    SHOW_TRADE_LIST("\\s*trade\\s+list\\s*"),
    RESPOND_TO_TRADE("\\s*trade\\s+response\\s+(-accept|-reject)\\s+-i\\s+(?<id>.+)\\s*"),
    SHOW_TRADE_HISTORY("\\s*trade\\s+history\\s*"),
    EXIT_TRADE("\\s*exit\\s+trade\\s"),
    SHOW_CURRENT_MENU("\\s*show\\s+current\\s+menu\\s*");

    private final String regexString;

    TradeMenuCommands(String regexString){
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
