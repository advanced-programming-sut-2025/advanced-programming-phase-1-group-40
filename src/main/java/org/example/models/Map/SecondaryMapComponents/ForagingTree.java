package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Position;
import org.example.models.enums.types.TreeType;

import java.util.Random;

public class ForagingTree extends Tree{

    ForagingTree(Position position) {

        super(TreeType.values()[ 8 + (new Random().nextInt(5))],position);

    }


}
