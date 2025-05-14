package org.example.models.Map.SecondaryMapComponents;

import org.example.models.Item;
import org.example.models.Map.MapComponents;
import org.example.models.Position;
import org.example.models.enums.types.FruitType;
import org.example.models.enums.types.TreeType;

import java.util.Map;
import java.util.Random;

public class Tree extends MapComponents implements Item {

    @Override
    public void update(){

    }

    private final TreeType treeType;
    private boolean isFullyGrown;
    private boolean isBurnt;

    public Tree(TreeType treeType,Position position) {



        super(position, 1,1);
        this.isFullyGrown = false;
        this.isBurnt = false;

        this.treeType = treeType;

    }

    public void setFullyGrown(boolean fullyGrown) {
        isFullyGrown = fullyGrown;
    }

    public void setBurnt(boolean burnt) {
        isBurnt = burnt;
    }

    public boolean isFullyGrown() {
        return isFullyGrown;
    }

    public boolean isBurnt() {
        return isBurnt;
    }

    public TreeType getTreeType() {
        return treeType;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String getItemName() {
        return "Tree";
    }

}
