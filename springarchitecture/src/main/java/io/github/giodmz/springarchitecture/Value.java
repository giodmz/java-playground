package io.github.giodmz.springarchitecture;

import org.springframework.stereotype.Component;

@Component
public class Value {

    @org.springframework.beans.factory.annotation.Value("${app.config.variavel}")
    private String variavel;

    public void printVar(){
        System.out.println(variavel);
    }
}
