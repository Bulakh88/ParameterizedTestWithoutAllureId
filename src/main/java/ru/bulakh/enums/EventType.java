package ru.bulakh.enums;

public enum EventType {
    WEBINAR, MEETING, TRAINING;

    public String getType() {
        return name().toLowerCase();
    }
}
