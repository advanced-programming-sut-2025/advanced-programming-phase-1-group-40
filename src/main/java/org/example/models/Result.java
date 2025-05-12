package org.example.models;

public record Result(boolean success, String message) {


    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public String message() {
        return message;
    }

}
