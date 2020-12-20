package com.arhohuttunen.junit5.mockito;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime creationDate;

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
