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

    CHANGE_USERNAME("^//s+change//s+username//s+-u//s+(?<username>[a-zA-Z0-9-]+)$"),
    CHANGE_NICKNAME("^//s+change//s+nickname//s+-u//s+(?<nickname>[a-zA-Z0-9-]+)$"),
    CHANGE_EMAIL("^//s+change//s+email//s+(?<email>(?!.*\\\\.\\\\.)[A-Za-z0-9](?:[A-Za-z0-9._-]*[A-Za-z0-9])?@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\\\.)+[A-Za-z]{2,})$"),
    CHANGE_PASSWORD("^//s+change$"),
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
