package io.github.giodmz.springarchitecture.manufactorers.api;

import io.github.giodmz.springarchitecture.HondaHRV;
import io.github.giodmz.springarchitecture.manufactorers.CarStatus;
import io.github.giodmz.springarchitecture.manufactorers.Engine;
import io.github.giodmz.springarchitecture.manufactorers.Key;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class TestFactoryController {

    @Autowired // injecao de dependencia -> pegue um objeto do tipo 'engine'
    @Qualifier("electricEngine")
    private Engine engine;

    @PostMapping
    public CarStatus powerCar(@RequestBody Key key){
        var car = new HondaHRV(engine);
        return car.bootCar(key);
    }

}
