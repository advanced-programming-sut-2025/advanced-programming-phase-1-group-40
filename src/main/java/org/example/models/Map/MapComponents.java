package org.example.models.Map;

/**
 * Abstract class representing components that can be placed on the farm map
 */
public abstract class MapComponents {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String name;
    
    public MapComponents(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
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
        return pointX >= x && pointX < x + width && 
               pointY >= y && pointY < y + height;
    }
    
    /**
     * Update method called daily to update component state
     */
    public abstract void update();
}
