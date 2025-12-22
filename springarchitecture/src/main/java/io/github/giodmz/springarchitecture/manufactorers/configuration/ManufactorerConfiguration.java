package io.github.giodmz.springarchitecture.manufactorers.configuration;

import io.github.giodmz.springarchitecture.manufactorers.Engine;
import io.github.giodmz.springarchitecture.manufactorers.enums.EngineType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ManufactorerConfiguration {

    @Bean(name = "aspiratedEngine") // metodo que retorna um objeto construido
    public Engine aspiratedEngine(){
        var engine = new Engine();
        engine.setHp(120);
        engine.setCylinders(4);
        engine.setModel("GW-2");
        engine.setEngSize(2.0);
        engine.setEngine(EngineType.ASPIRATED);
        return engine;
    }

    @Bean(name = "electricEngine")
    public Engine electricEngine(){
        var engine = new Engine();
        engine.setHp(140);
        engine.setCylinders(4);
        engine.setModel("MHW-14");
        engine.setEngSize(2.0);
        engine.setEngine(EngineType.ELECTRIC);
        return engine;
    }

    @Bean(name = "turboEngine")
    public Engine turboEngine(){
        var engine = new Engine();
        engine.setHp(200);
        engine.setCylinders(4);
        engine.setModel("YL2-2");
        engine.setEngSize(1.6);
        engine.setEngine(EngineType.TURBO);
        return engine;
    }
}
