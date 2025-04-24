package org.example.models.enums.commands;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.regex.*;

public interface Command {

    String getRegex();

    default Matcher getMatcher(String input) {
        Pattern pattern = Pattern.compile(getRegex());
        return pattern.matcher(input);
    }

    default boolean matches(String input) {
        return getMatcher(input).matches();
    }
}