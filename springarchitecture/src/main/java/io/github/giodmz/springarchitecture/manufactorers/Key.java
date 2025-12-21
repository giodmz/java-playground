package io.github.giodmz.springarchitecture.manufactorers;

import io.github.giodmz.springarchitecture.manufactorers.enums.Manufactorer;

public class Key {
    private Manufactorer manufactorer;
    private String type;

    public Manufactorer getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(Manufactorer manufactorer) {
        this.manufactorer = manufactorer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
