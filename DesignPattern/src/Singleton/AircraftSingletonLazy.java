package Singleton;

import test.AircraftTestLazy;

import java.util.HashSet;
import java.util.Set;
/*
 * O problema é que threads trabalhando juntas, provavelmente 2
 * pessoas diferentes irão conseguir pegar o mesmo assento.
 */
public class AircraftSingletonLazy {

    //Lazy initialization

    private  static AircraftSingletonLazy INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();
    private final String name;

    private AircraftSingletonLazy(String name) {
        this.name = name;
    }

    {
        availableSeats.add("1A");
        availableSeats.add("1B");
    }

    public boolean bookSeat(String seat) {
        return  availableSeats.remove(seat);
    }

    // poderia usar o synchronized diretamente no métdo,
    // porém isso afeta a performance, já que pega o méthod inteiro

    // public synchronized static AircraftSingletonLazy getInstance() {...}
    public static AircraftSingletonLazy getInstance() {
        if (INSTANCE == null) {
            synchronized (AircraftTestLazy.class){
                if (INSTANCE == null) {
                INSTANCE  = new AircraftSingletonLazy("787-900");
                }
            }
        }
        return INSTANCE;
    }


}
