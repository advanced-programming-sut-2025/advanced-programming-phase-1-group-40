package org.example.models.Map;

import org.example.models.Position;

/**
 * Abstract class representing components that can be placed on the farm map
 */
public abstract class MapComponents {

    protected Position position;
    protected int width;
    protected int height;
    protected String name;
    
    public MapComponents(Position position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }
    
    public MapComponents(int x, int y, int width, int height) {
        this.position = new Position(x, y);
        this.width = width;
        this.height = height;
    }
    
    public int getX() {
        return position.getX();
    }
    
    public int getY() {
        return position.getY();
    }
    
    public Position getPosition() {
        return position;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean contains(int pointX, int pointY) {
        return pointX >= position.getX() && pointX < position.getX() + width && 
               pointY >= position.getY() && pointY < position.getY() + height;
    }
    
    /**
     * Update method called daily to update component state
     */
    public abstract void update();
}
