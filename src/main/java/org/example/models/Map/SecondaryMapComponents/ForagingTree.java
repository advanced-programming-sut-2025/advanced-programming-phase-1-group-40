package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Position;
import org.example.models.enums.types.TreeType;

import java.util.Random;

public class ForagingTree extends Tree implements Item {

    private final TreeType treeType;

    public ForagingTree(Position position) {


        super(TreeType.values()[ 8 + (new Random().nextInt(5))],position);
        this.treeType = super.getTreeType();

    }
    public ForagingTree(Position position, TreeType treeType) {
        super(TreeType.values()[ 8 + (new Random().nextInt(5))],position);
        this.treeType = treeType;
    }

    @Override
    public TreeType getTreeType() {
        return treeType;
    }

    @Override
    public String getItemName() {
        return "Foraging Tree";
    }
}
