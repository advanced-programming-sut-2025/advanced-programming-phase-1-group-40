package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Position;
import org.example.models.enums.types.TreeType;

import java.util.Random;

public class ForagingTree extends Tree implements Item {

    private final TreeType treeType;

    ForagingTree(Position position) {


        super(TreeType.values()[ 8 + (new Random().nextInt(5))],position);
        this.treeType = super.getTreeType();

    }

    @Override
    public TreeType getTreeType() {
        return treeType;
    }
}
