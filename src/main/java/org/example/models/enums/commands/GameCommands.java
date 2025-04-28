package org.example.models.enums.commands;

import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;
import org.example.models.farming.*;
import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum GameCommands implements Command{




    ///  COMMAND HAYE DAMDARI

    BUILD("\\s+build\\s+-a\\s+(?<buildingName>.+)\\s+-l\\s+(?<x>\\S+)\\s+(?<y>\\S+)\\s+"),
    BUY_ANIMAL("\\s+buy\\s+animal\\s+-a\\s+(?<animalName>.+)\\s+-n\\s+(?<name>.+)\\s+"),
    PET("\\s+pet\\s+-n\\s+(?<name>.+)\\s+"),
    CHEAT_SET_FRIENDSHIP("\\s+cheat\\s+set\\s+friendship\\s+-n\\s+(?<animalName>.+)\\s+-c\\s+(?<amount>.+)\\s+"),
    SHOW_ANIMAL_INFO("\\s+animals\\s+"),
    SHEPHERD_ANIMALS("\\s+shepherd\\s+animals\\s+-n\\s+(?<animalName>.+)\\s+-l\\s+(?<x>\\S+)\\s+(?<y>\\S+)\\s+"),
    FEED_HAY("\\s+feed\\s+hay\\s+-n\\s+(?<animalName>.+)\\s+"),
    SHOW_UNCOLLECTED_PRODUCTS("\\s+produces\\s+");


    private final String regexString;

    GameCommands(String regexString) {
        this.regexString = regexString;
    }

    @Override
    public Matcher getMatcher(String input) {
        return null;
    }
}
