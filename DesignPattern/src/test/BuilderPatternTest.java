package test;

import Builder.Person;

public class BuilderPatternTest {
    public static void main (String[] args) {
        Person build = new Person.PersonBuilder()
                .firstName("Marcelo")
                .lastName("Fodao")
                .username("sufirstinha123")
                .email("corinthiansgigante@gmail.com")
                .build();
        System.out.println(build);
    }
}
