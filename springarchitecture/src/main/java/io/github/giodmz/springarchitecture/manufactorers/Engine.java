package io.github.giodmz.springarchitecture.manufactorers;

import io.github.giodmz.springarchitecture.manufactorers.enums.EngineType;

public class Engine {
    private String model;
    private Integer hp;
    private Integer cylinders;
    private Double engSize;
    private EngineType engine;


    public Integer getCylinders() {
        return cylinders;
    }

    public void setCylinders(Integer cylinders) {
        this.cylinders = cylinders;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType aspirated) {
        this.engine = engine;
    }

    public Double getEngSize() {
        return engSize;
    }

    public void setEngSize(Double engSize) {
        this.engSize = engSize;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "cylinders=" + cylinders +
                ", model='" + model + '\'' +
                ", hp=" + hp +
                ", engSize=" + engSize +
                ", engine=" + engine +
                '}';
    }
}
