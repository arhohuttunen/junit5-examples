package com.arhohuttunen.junit5.parameterized;

import java.time.LocalDate;

public class Task {
    private final String title;
    private final Status status;
    private final LocalDate dateCreated;

    public enum Status {
        OPENED, IN_PROGRESS, CLOSED
    }

    public Task(String title, Status status, LocalDate dateCreated) {
        this.title = title;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public Status getGender() {
        return status;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status=" + status +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
