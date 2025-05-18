package org.example.models.enums.types;

import org.example.models.Item;

public enum RewardType implements Item {
    COIN,
    FRIENDSHIP_LEVEL;

    @Override
    public String getItemName() {
        return "";
    }
}
