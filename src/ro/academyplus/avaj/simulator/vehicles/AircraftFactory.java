package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.weather.Coordinates;

/**
 * Created by root on 6/7/17.
 */
public class AircraftFactory {

    public static Flyable newAircraft(String type,
                               String name,
                               int longitude,
                               int latitude,
                               int height)
                                throws Exception {
        Flyable flyable;
        switch (type) {
            case "Baloon":
                flyable = new Baloon(name, new Coordinates(longitude, latitude, height));
                break;
            case "JetPlane":
                flyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
                break;
            case "Helicopter":
                flyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
                break;
            default:
                flyable = null;
        }
        if (flyable == null)
            throw new Exception("Unknown aircraft type: " + type);
        return flyable;

    }
}
