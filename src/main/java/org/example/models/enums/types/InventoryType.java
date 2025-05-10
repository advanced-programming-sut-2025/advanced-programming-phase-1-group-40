package org.example.models.enums.types;


public enum InventoryType {

    INITIAL(12),
    LARGE(24),
    DELUXE(Integer.MAX_VALUE),
    REFRIGERATOR(Integer.MAX_VALUE);

    private final Integer capacity;

    InventoryType(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }


}

