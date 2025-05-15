package org.example.models.tools;

import org.example.models.enums.types.ToolTypes;

public class FishingRod extends Tool{
    public FishingRod(){
        super(ToolTypes.FISHING_ROD);
    }
    @Override
    public String getItemName(){
        return "Fishing Pole";
    }
}
