package ro.academyplus.avaj.simulator.vehicles;


import ro.academyplus.avaj.simulator.WeatherTower;

/**
 * Created by root on 6/7/17.
 */
public interface Flyable {

    void updateConditions();
    long getId();
    void registerTower(WeatherTower weatherTower);
}
