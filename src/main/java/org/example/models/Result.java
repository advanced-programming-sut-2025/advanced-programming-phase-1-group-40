package org.example.models;

public record Result(boolean success, String message) {
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
