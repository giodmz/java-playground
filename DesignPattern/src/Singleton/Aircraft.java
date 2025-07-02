package Singleton;

/*
* Uma classe que só pode ter um objeto que deverá usado em qualquer parte do
* código que precisar dela
* Exemplo: Drive de conexão com database
*
* Não importa onde o objeto é trabalhado (AircraftSingletonEager), ele sempre vai
* estar referenciando o mesmo espaço de memória
*/

import java.util.HashSet;
import java.util.Set;

public final class Aircraft {
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    public Aircraft(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return  availableSeats.remove(seat);
    }
}
