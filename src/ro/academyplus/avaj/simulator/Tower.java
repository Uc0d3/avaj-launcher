package ro.academyplus.avaj.simulator;

import java.util.ArrayList;
import java.util.Objects;

import ro.academyplus.avaj.simulator.vehicles.Flyable;
/**
 * Created by root on 6/7/17.
 */
public class Tower {
    ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        System.out.println(flyable);
        observers.remove(flyable.getId());

    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
    }
}
