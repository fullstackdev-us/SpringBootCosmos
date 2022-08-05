package com.example.sbcosmos.models;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import java.util.UUID;

import org.springframework.data.annotation.Id;

@Container(containerName = "TodoCollection")
public class Item {
    @Id
    private UUID id;
    @PartitionKey
    private String listName;
    private String description;
    private boolean complete;

    public Item(String listName, String description, boolean complete) {
        this.id = java.util.UUID.randomUUID();
        this.listName = listName;
        this.description = description;
        this.complete = complete;
    }

    public Item(Item item) {
        this.id = java.util.UUID.randomUUID();
        this.listName = item.listName;
        this.description = item.description;
        this.complete = item.complete;
    }

    public UUID getId() {
        return id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
