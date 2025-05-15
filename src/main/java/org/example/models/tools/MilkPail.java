package org.example.models.tools;


import org.example.models.enums.types.ToolTypes;

public class MilkPail extends Tool{
    public MilkPail(){
        super(ToolTypes.MILK_PAIL);
    }
    @Override
    public String getItemName(){
        return "Milk Pail";
    }
}

