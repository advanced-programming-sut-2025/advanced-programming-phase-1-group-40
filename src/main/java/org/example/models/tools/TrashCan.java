package org.example.models.tools;
import org.example.models.*;
import org.example.models.enums.types.*;
import org.example.models.enums.enviroment.*;
import org.example.models.enums.*;

import org.example.models.inventory.*;
import org.example.models.tools.*;
import org.example.models.*;
import java.util.Map;

public class TrashCan extends Tool {

    public TrashCan() {
        super(ToolTypes.TRASH_CAN, null);
    }

    @Override
    public String getItemName() {
        return "Trash Can";
    }

    @Override
    public int getBaseEnergyCost() {
        return 0;
    }
    // energy masraf nemikone
    @Override
    public void useTool(Direction direction) {
        //?
    }
}
