package org.example.models.Map;

import org.example.models.Position;
import org.example.models.enums.types.FruitType;
import org.example.models.enums.types.TreeType;

import java.util.Map;
import java.util.Random;

public class Tree extends MapComponents {

    @Override
    public void update(){

    }

    private final TreeType treeType;
    private final Position position;
    private boolean isFullyGrown;
    private boolean isBurnt;

    public Tree(Position position) {



        super(position.getX(), position.getY(), 1,1);
        this.position = position;
        this.isFullyGrown = false;
        this.isBurnt = false;

        ///  GENERATING RANDOM TYPE OF TREE

        this.treeType = TreeType.values()[(new Random().nextInt(TreeType.values().length))];

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
}
