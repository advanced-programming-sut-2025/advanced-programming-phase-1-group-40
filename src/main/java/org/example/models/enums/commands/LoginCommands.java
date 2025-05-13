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

    ///  REGISTER

    REGISTER("\\s*register\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+(?<repeatPassword>\\S+)\\s+-n\\s+(?<nickname>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-g\\s+(?<gender>\\S+)\\s*"),
    USERNAME_REGEX(".+"),
    EMAIL_REGEX(".+"),
    PASSWORD_REGEX(".+"),
    PICK_QUESTION("\\s*pick\\s+question\\s+-q\\s+(?<questionNumber>\\S+)\\s+-a\\s+(?<answer>\\S+)\\s+-c\\s+(?<answerConfirm>\\S+)\\s*"),


    /// LOGIN

    LOGIN("\\s*login\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)(\\s+-stay-logged-in)?\\s*"),
    FORGET_PASSWORD("\\s*forget\\s+password\\s+-u\\s+(?<username>\\S+)\\s*"),
    ANSWER("\\s*answer\\s+-a\\s+(?<answer>\\S+)\\s*"),



    EXIT("\\s*menu\\s+exit\\s*"),
    SHOW_CURRENT_MENU("\\s*menu\\s+show\\s+menu\\s*");



    private final String regex;
    private final Pattern pattern;

    LoginCommands(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(this.regex);
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


