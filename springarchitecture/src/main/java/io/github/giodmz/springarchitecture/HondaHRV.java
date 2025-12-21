package io.github.giodmz.springarchitecture;

import io.github.giodmz.springarchitecture.manufactorers.Car;
import io.github.giodmz.springarchitecture.manufactorers.Engine;
import io.github.giodmz.springarchitecture.manufactorers.enums.Manufactorer;

import java.awt.*;

public class HondaHRV extends Car {

    public HondaHRV(Engine engine) {
        super(engine);
        setModel("HRV");
        setColor(Color.CYAN);
        setManufactorer(Manufactorer.TOYOTA);

    }

}
