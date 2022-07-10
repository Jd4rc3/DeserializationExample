package org.example;

import lombok.Data;

@Data
public class Hulk {

    String name;
    String description;

    public Hulk(String name, String description) {
        this.name        = name;
        this.description = description;
    }
}
