package org.example.models.enums.commands;

import java.util.regex.*;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;

public enum LoginCommands implements Command {

    USERNAME_REGEX("^[a-zA-Z0-9-]+$"),
    PASSWORD_REGEX("^[a-zA-Z0-9?<>,\"';:\\\\/|\\[\\] {}+=)(*&^%\\$#!]+$"),
    EMAIL_REGEX("^(?!.*\\.\\.)[A-Za-z0-9](?:[A-Za-z0-9._-]*[A-Za-z0-9])?@(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z]{2,}$");


    private final String regex;
    private final Pattern pattern;

    LoginCommands(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(this.regex);
    }

    public boolean matches(String input) {
        // TODO
        return this.pattern.matcher(input).matches();
    }

    public String getRegex() {
        return this.regex;
    }

    @Override
    public Matcher getMatcher(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            return matcher;
        }
        return null;
    }
}


