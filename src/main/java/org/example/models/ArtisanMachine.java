package org.example.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.example.models.enums.types.ArtisanType;

    public class ArtisanMachine {
    private final ArtisanType type;
    private List<Item> inputItems;
    private LocalDateTime finishTime;
    private boolean isProcessing;

    public ArtisanMachine(ArtisanType type) {
        this.type = type;
        this.inputItems = new ArrayList<>();
        this.isProcessing = false;
    }

    public boolean startProcessing(List<Item> items) {
        if (isProcessing) return false;
        this.inputItems = items;
        this.finishTime = LocalDateTime.now().plusHours(type.getProcessingTimeInHours());
        this.isProcessing = true;
        return true;
    }

    public boolean isReady() {
        return isProcessing && LocalDateTime.now().isAfter(finishTime);
    }

    public ArtisanType getType() {
        return type;
    }

    public boolean isProcessing() {
        return isProcessing;
    }
}
