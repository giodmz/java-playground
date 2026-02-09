package io.github.giodmz.springarchitecture.manufactorers.api;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // retention default
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD}) // permite usar a annotation em cima de classe, campo e método
@Qualifier("aspiratedEngine") // bean definito previamente
public @interface Aspirated {
}
