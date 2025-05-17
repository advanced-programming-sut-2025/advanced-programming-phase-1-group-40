package org.example.models.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum GameCommands implements Command{


    ///  GENERAL COMMANDS

    NEXT_TURN("\\s*next\\s+turn\\s*"),
    EXIT_GAME("\\s*exit\\s+game\\s*"),
    WALK("\\s*walk\\s+-l\\s+(?<x>\\d+)\\s+(?<y>\\d+)\\s*"),
    SHOW_CURRENT_MENU("\\s*show\\s+current\\s+menu\\s*"),
    PRINT_MAP("^\\s*print\\s+map\\s+-l\\s+(?<x>\\d+)\\s+(?<y>\\d+)\\s+-s\\s+(?<size>\\d+)\\s*$"),
    HELP_READING_MAP("\\s*help\\s+reading\\s+map\\s*"),
    SHOW_MAP("\\s*show\\s+map\\s*"),


    ///  COAMMND HAYE TIME&DATE


    SHOW_TIME("\\s*time\\s*"),
    SHOW_DATE("\\s*date\\s*"),
    SHOW_DATETIME("\\s*datetime\\s*"),
    SHOW_DAY_OF_THE_WEEK("\\s*day\\s+of\\s+the\\s+week\\s*"),
    CHEAT_ADVANCE_TIME("\\s*cheat\\s+advance\\s+time\\s+(?<time>.+)h\\s*"),
    CHEAT_ADVANCE_DATE("\\s*cheat\\s+advance\\s+date\\s+(?<date>.+)d\\s*"),
    SHOW_SEASON("\\s*season\\s*"),


    ///  COMMAND HAYE WEATHER


    CHEAT_THOR("\\s*cheat\\s+thor\\s+-l\\s+(?<x>.+)\\s+(?<y>.+)\\s*"),
    SHOW_WEATHER("\\s*weather\\s*"),
    SHOW_WEATHER_FORECAST("\\s*weather\\s+forecast\\s*"),
    CHEAT_WEATHER_SET("\\s*cheat\\s+weather\\s+set\\s+(?<weatherType>.+)\\s*"),



    ///  COMMAND HAYE DAMDARI


    BUILD("\\s*build\\s+-a\\s+(?<buildingName>.+)\\s+-l\\s+(?<x>\\S+)\\s+(?<y>\\S+)\\s*"),
    BUY_ANIMAL("\\s*buy\\s+animal\\s+-a\\s+(?<animalName>.+)\\s+-n\\s+(?<name>.+)\\s*"),
    PET("\\s*pet\\s+-n\\s+(?<name>.+)\\s*"),
    CHEAT_SET_FRIENDSHIP("\\s*cheat\\s+set\\s+friendship\\s+-n\\s+(?<animalName>.+)\\s+-c\\s+(?<amount>.+)\\s*"),
    SHOW_ANIMAL_INFO("\\s*animals\\s*"),
    SHEPHERD_ANIMALS("\\s*shepherd\\s+animals\\s+-n\\s+(?<animalName>.+)\\s+-l\\s+(?<x>\\S+)\\s+(?<y>\\S+)\\s*"),
    FEED_HAY("\\s*feed\\s+hay\\s+-n\\s+(?<animalName>.+)\\s*"),
    SHOW_UNCOLLECTED_PRODUCTS("\\s+produces\\s*"),
    COLLECT_PRODUCTS("\\s*collect\\s+produce\\s+n-\\s+(?<name>.+)\\s*"),
    SELL_ANIMAL("\\s*sell\\s+animal\\s+n-\\s+(?<name>.+)\\s*"),
    FISHING("\\s*fishing\\s+p-\\s+(?<fishingPole>.+)\\s*"),



    ///  COMMAND HAYE ARTISAN


    ARTISAN_USE("\\s*artisan\\s+use\\s+(?<artisanName>.+)\\s+(?<itemName>.+)\\s*"),
    ARTISAN_GET("\\s*artisan\\s+get\\s+(?<artisanName>.+)\\s*"),


    ///  COMMAND HAYE SHOP


    SHOW_ALL_PRODUCTS_IN_STORE("\\s*show\\s+all\\s+products\\s*"),
    SHOW_AVAILABLE_PRODUCTS_IN_STORE("\\s+show\\s+all\\s+available\\s+products\\s*"),
    PURCHASE_ITEM("\\s*purchase\\s+(?<productName>.+)\\s+-n\\s+(?<count>.+)\\s*"),
    CHEAT_ADD_MONEY("\\s*cheat\\s+add\\s+(?<count>.+)\\s+dollars\\s*"),
    SELL_ITEM("\\s*sell\\s+(?<productName>.+)\\s+-n\\s+(?<count>.+)\\s*"),


    /// COMMAND HAYE TAAMOLAT VA RAVABET BA BAZIKONAYE DIGE


    SHOW_FRIENDSHIP("\\s*friendships\\s*"),
    TALK_WITH_OTHERS("\\s*talk\\s+-u\\s+(?<username>.+)\\s+-m\\s+(?<message>.+)\\s*"),
    SHOW_TALK_HISTORY("\\s*talk\\s+history\\s+-u\\s+(?<username>.+)\\s*"),
    GIVE_GIFT_TO_OTHERS("\\s*gift\\s+-u\\s+(?<username>.+)\\s+-i\\s+(?<item>.+)\\s+-a\\s+(?<amount>.+)\\s*"),
    SHOW_RECEIVED_GIFTS("\\s*gift\\s+list\\s*"),
    RATE_GIFT("\\s*gift\\s+rate\\s+-i\\s+(?<giftNumber>.+)\\s+-r\\s+(?<rate>.+)\\s*"),
    GIFT_HISTORY_WITH_USER("\\s*gift\\s+history\\s+-u\\s+(?<username>.+)\\s*"),
    HUG_USER("\\s*hug\\s+-u\\s+(?<username>.+)\\s*"),
    FLOWER_USER("\\s*flower\\s+-u\\s+(?<username>.+)\\s*"),
    ASK_MARRIAGE("\\s*ask\\s+marriage\\s+-u\\s+(?<username>.+)\\s+-r\\s+(?<ring>.+)\\s*"),
    RESPOND_TO_MARRIAGE("\\s*respond\\s+(-accept|-reject)\\s+-u\\s+(?<username>.+)\\s*"),


    ///  COMMAND HAYE TRADE(TRADE MENU)


    START_TRADE("\\s*start\\s+trade\\s*"),
    TRADE_WITH_MONEY("\\s*trade\\s+-u\\s+(?<username>.+)\\s+-t\\s+(?<type>.+)\\s+-i\\s+(?<item>.+)\\s+-a\\s+(?<amount>.+)\\s+-p\\s+(?<price>.+)\\s*"),
    TRADE_WITH_ITEM("\\s*trade\\s+-u\\s+(?<username>.+)\\s+-t\\s+(?<type>.+)\\s+-i\\s+(?<item>.+)\\s+-a\\s+(?<amount>.+)\\s+-ti\\s+(?<targetItem>.+)\\s+-ta\\s+(?<targetItem>.+)\\s*"),
    SHOW_TRADE_LIST("\\s*trade\\s+list\\s*"),
    RESPOND_TO_TRADE("\\s*trade\\s+response\\s+(-accept|-reject)\\s+-i\\s+(?<id>.+)\\s*"),
    SHOW_TRADE_HISTORY("\\s*trade\\s+history\\s*"),


    ///  COMMAND HAYE NPC


    MEET_NPC("\\s*meet\\s+NPC\\s+(?<npcName>.+)\\s*"),
    GIFT_NPC("\\s*gift\\s+NPC\\s+(?<npcName>.+)\\s+-i\\s+(?<item>.+)\\s*"),
    SHOW_FRIENDSHIP_WITH_NPC("\\s*friendship\\s+NPC\\s+list\\s*"),
    SHOW_QUESTS_LIST("\\s*quests\\s+list\\s*"),
    FINISH_QUESTS("\\s*quests\\s+finish\\s+-i\\s+(?<index>.+)\\s*"),


    //  COMMAND HAYE ENERGY


    SHOW_ENERGY("\\s*energy\\s+show\\s*"),
    SET_ENERGY("\\s*energy\\s+set\\s+-v\\s+(?<value>\\d+)\\s*"),
    SET_UNLIMITED_ENERGY("\\s*energy\\s+unlimited\\s*"),


    //  COMMAND HAYE INVENTORY


    SHOW_INVENTORY("\\s*inventory\\s+show\\s*"),
    TRASH_ITEM("\\s*inventory\\s+trash\\s+-i\\s+(?<itemName>.+)(?:\\s+-n\\s+(?<number>\\d+))?\\s*"),


    // COMMAND HAYE TOOLS


    TOOLS_EQUIP("\\s*tools\\s+equip\\s+(?<toolName>.+)\\s*"),
    TOOLS_SHOW_CURRENT("\\s*tools\\s+show\\s+current\\s*"),
    TOOLS_SHOW_AVAILABLE("\\s*tools\\s+show\\s+available\\s*"),
    TOOLS_UPGRADE("\\s*tools\\s+upgrade\\s+(?<toolName>.+)\\s*"),
    TOOLS_USE("\\s*tools\\s+use\\s+-d\\s+(?<direction>\\w+)\\s*"),



    // COMMAND HAYE PISHRAFT BAAZI

    SHOW_PRODUCT_DETAIL("\\s*craftino\\s+-n\\s+(?<craft_name>.+)\\s*"),


    // COMMAND HAYE AGRICULTURE


    PLANT("\\s*plant\\s+-s\\s+(?<seed>.+)\\s+-d\\s+(?<direction>.+)\\s*"),
    SHOW_PLANT("\\s*showplant\\s+-l\\s+(?<x>\\S+)\\s*,\\s*(?<y>\\S+)\\s*"),
    FERTILIZE("\\s*fertilize\\s+-f\\s+(?<fertilizer>.+)\\s+-d\\s+(?<direction>.+)\\s*"),
    CHECK_WATER("\\s*howmuch\\s+water\\s*"),


    // COMMAND HAYE CRAFTING


    SHOW_CRAFTING_RECIPES("\\s*crafting\\s+show\\s+recipes\\s*"),
    CRAFT_ITEM("\\s*crafting\\s+craft\\s+(?<itemName>.+)\\s*"),
    PLACE_ITEM("\\s*place\\s+item\\s+-n\\s+(?<itemName>.+)\\s+-d\\s+(?<direction>.+)\\s*"),
    CHEAT_ADD_ITEM("\\s*cheat\\s+add\\s+item\\s+-n\\s+(?<itemName>.+)\\s+-c\\s+(?<count>\\d+)\\s*"),


    // COMMANDS RELATED TO COOKING

    COOKING_REFRIGERATOR("\\s*cooking\\s+refrigerator\\s+(?<action>put|pick)\\s+(?<item>.+)\\s*"),
    COOKING_SHOW_RECIPES("\\s*cooking\\s+show\\s+recipes\\s*"),
    COOKING_PREPARE("\\s*cooking\\s+prepare\\s+(?<recipeName>.+)\\s*"),
    EAT_FOOD("\\s*eat\\s+(?<foodName>.+)\\s*");






    private final String regexString;

    GameCommands(String regexString){
        this.regexString = regexString;
    }

    @Override
    public Matcher getMatcher(String input) {

        Matcher matcher = Pattern.compile(regexString).matcher(input);

        if (matcher.matches()) return matcher;

        return null;
    }


}
