package org.example.models.enums.commands;

import java.util.regex.*;

public enum LoginCommands implements Command {

    ///  REGISTER

    REGISTER("\\s*register\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)\\s+(?<repeatPassword>\\S+)\\s+-n\\s+(?<nickname>\\S+)\\s+-e\\s+(?<email>\\S+)\\s+-g\\s+(?<gender>\\S+)\\s*"),
    USERNAME_REGEX("[A-Za-z0-9-]+"),
    EMAIL_USER_REGEX("(?!.*\\.\\.)[a-zA-Z0-9](?:[a-zA-Z0-9._-]*[a-zA-Z0-9])?"),
    EMAIL_DOMAIN_REGEX("(?=[a-zA-Z0-9][a-zA-Z0-9.-]*[a-zA-Z0-9]$)(?=.*\\.)[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"),
    EMAIL_SPECIAL_CHAR(".*[!@#$%^&*()+\\-=\\[\\]{}|\\\\:;\"'<>,?/].*"),
    PASSWORD_REGEX("[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{}|\\\\:;\"'<>,.?/]+"),             // CHECK BESHE
    PASSWORD_CONTAINS_DIGITS(".*\\d.*"),
    PASSWORD_SPECIAL_CHAR(".*[!@#$%^&*()_+\\-=\\[\\]{}|\\\\:;\"'<>,.?/].*"),
    PICK_QUESTION("\\s*pick\\s+question\\s+-q\\s+(?<questionNumber>\\S+)\\s+-a\\s+(?<answer>\\S+)\\s+-c\\s+(?<answerConfirm>\\S+)\\s*"),


    /// LOGIN

    LOGIN("\\s*login\\s+-u\\s+(?<username>\\S+)\\s+-p\\s+(?<password>\\S+)(\\s+-stay-logged-in)?\\s*"),
    FORGET_PASSWORD("\\s*forget\\s+password\\s+-u\\s+(?<username>\\S+)\\s*"),
    ANSWER("\\s*answer\\s+-a\\s+(?<answer>\\S+)\\s*"),



    EXIT("\\s*menu\\s+exit\\s*"),
    SHOW_CURRENT_MENU("\\s*menu\\s+show\\s+menu\\s*");



    private final String regexString;

    LoginCommands(String regexString){
        this.regexString = regexString;
    }

    @Override
    public Matcher getMatcher(String input) {

        Matcher matcher = Pattern.compile(regexString).matcher(input);

        if (matcher.matches()) return matcher;

        return null;
    }


}


