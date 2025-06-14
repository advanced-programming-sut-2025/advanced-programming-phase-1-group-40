package org.example.models.enums;

import org.example.view.*;

public enum Menu {
    TRADE_MENU("Trade Menu", new TradeMenu()),
    LOGIN_MENU("Login/Register Menu", new LoginMenu()),
    MAIN_MENU("Main Menu", new MainMenu()),
    PROFILE_MENU("Profile Menu", new ProfileMenu()),
    PRE_GAME_MENU("Pre Game Menu", new PreGameMenu()),
    GAME("Game", new Game()),
    AVATAR_MENU("Avatar Menu", new AvatarMenu()),
    EXIT("Exit", new ExitMenu());

    private final String displayName;
    private final AppMenu menu;

    Menu(String displayName, AppMenu menu) {
        this.displayName = displayName;
        this.menu = menu;
    }

    public AppMenu getMenu() {
        return menu;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Menu getMenuFromDisplayName(String menuName) {
        for (Menu menu : values()) {
            if (menu.getDisplayName().equalsIgnoreCase(menuName)) {
                return menu;
            }
        }
        return null;
    }
}
