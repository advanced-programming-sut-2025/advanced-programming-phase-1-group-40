package org.example.models.enums;

public enum Menu {
    LOGIN_MENU("Login Menu"),
    SIGNUP_MENU("Signup Menu"),
    MAIN_MENU("Main Menu"),
    PROFILE_MENU("Profile Menu"),
    GAME_MENU("Game Menu"),
    AVATAR_MENU("Avatar Menu"),
    EXIT("Exit");

    private final String displayName;

    Menu(String displayName) {
        this.displayName = displayName;
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
