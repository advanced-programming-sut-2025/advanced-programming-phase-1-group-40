package org.example.models.enums.commands;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum MainMenuCommands implements Command{


    GO_TO_PROFILE_MENU("\\s*menu\\s+enter\\s+(p|P)rofile(\\s+(M|m)enu)?\\s*"),
    GO_TO_GAME_MENU("\\s*menu\\s+enter\\s+(g|G)ame(\\s+(M|m)enu)?\\s*"),
    GO_TO_AVATAR_MENU("\\s*menu\\s+enter\\s+(a|A)vater(\\s+(M|m)enu)?\\s*"),
    USER_LOGOUT("\\s*user\\s+logout\\s*"),
    SHOW_CURRENT_MENU("\\s*menu\\s+show\\s+menu\\s*");


    private final String regexString;

    MainMenuCommands(String regexString){
        this.regexString = regexString;
    }

    @Override
    public Matcher getMatcher(String input) {

        Matcher matcher = Pattern.compile(regexString).matcher(input);

        if (matcher.matches()) return matcher;

        return null;
    }


}
