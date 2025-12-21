package io.github.giodmz.springarchitecture.manufactorers;

import io.github.giodmz.springarchitecture.manufactorers.enums.Manufactorer;

import java.awt.*;

public class Car {
    private String model;
    private Color color;
    private Engine engine;
    private Manufactorer manufactorer;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Manufactorer getManufactorer() {
        return manufactorer;
    }

    public void setManufactorer(Manufactorer manufactorer) {
        this.manufactorer = manufactorer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
