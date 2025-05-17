package org.example.models.enums.types;

public enum TradeType {
    OFFER("offer"),
    REQUEST("request"),
    MONEY("money"),
    ITEM("item");


    private final String displayName;

    TradeType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName(){
        return displayName;
    }


}
