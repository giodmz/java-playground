package io.github.giodmz.springarchitecture.manufactorers.configuration;

import io.github.giodmz.springarchitecture.manufactorers.Engine;
import io.github.giodmz.springarchitecture.manufactorers.enums.EngineType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufactorerConfiguration {

    @Bean // metodo que retorna um objeto construido
    public Engine engine(){
        var engine = new Engine();
        engine.setHp(120);
        engine.setCylinders(4);
        engine.setModel("GW-2");
        engine.setEngSize(2.0);
        engine.setEngine(EngineType.ASPIRATED);
        return engine;
    }
}
