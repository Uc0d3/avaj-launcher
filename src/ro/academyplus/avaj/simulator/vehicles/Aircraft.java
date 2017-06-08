package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.weather.Coordinates;

/**
 * Created by root on 6/7/17.
 */

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return ++idCounter;
    }
}

