package org.example.models.tools;

import org.example.models.enums.types.ToolTypes;

public class WateringCan extends Tool {
public WateringCan() {
    super(ToolTypes.WATERING_CAN);
}
@Override
    public String getItemName(){
    return "Watering Can";
}
}

