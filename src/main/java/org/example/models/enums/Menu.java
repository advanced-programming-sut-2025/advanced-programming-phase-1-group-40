package org.example.models.enums;

import org.example.view.*;

public enum Menu {
    LOGIN_MENU("Login Menu", new LoginMenu()),
    SIGNUP_MENU("Signup Menu", new SignUpMenu()),
    MAIN_MENU("Main Menu", new MainMenu()),
    PROFILE_MENU("Profile Menu", new ProfileMenu()),
    GAME_MENU("Game Menu", new GameMenu()),
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
