package ro.academyplus.avaj.simulator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ro.academyplus.avaj.simulator.vehicles.Flyable;
/**
 * Created by root on 6/7/17.
 */
public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        ArrayList<Flyable> copyObservers = new ArrayList<Flyable>();

        for (Flyable flyable : observers) {
            copyObservers.add(flyable);
        }

        for (Flyable flyable : copyObservers) {
            flyable.updateConditions();
        }
    }
}
