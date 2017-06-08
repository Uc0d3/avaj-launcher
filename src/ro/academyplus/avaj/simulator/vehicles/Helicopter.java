package ro.academyplus.avaj.simulator.vehicles;


import ro.academyplus.avaj.simulator.Logger;
import ro.academyplus.avaj.simulator.WeatherTower;
import ro.academyplus.avaj.weather.Coordinates;

/**
 * Created by root on 6/7/17.
 */
public class Helicopter extends Aircraft implements Flyable {
    WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = null;
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(super.coordinates);
        Coordinates newCoordinates = null;

        switch (weather) {
            case "SUN":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude() + 10,
                        super.coordinates.getLatitude() ,
                        Math.min(super.coordinates.getHeight() + 2, 100)
                );
                Logger.log(
                        "Helicopter#" + super.name + "(" + super.id + "): Suuny day for heli ride."
                );
                break;
            case "RAIN":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude() + 5,
                        super.coordinates.getLatitude(),
                        super.coordinates.getHeight()
                );
                Logger.log(
                        "Helicopter#" + super.name + "(" + super.id + "): Fricking rain."
                );
                break;
            case "FOG":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude() + 1,
                        super.coordinates.getLatitude(),
                        super.coordinates.getHeight()
                );
                Logger.log(
                        "Helicopter#" + super.name + "(" + super.id + "): Yo John theres to much fog, can't see"
                );
                break;
            case "SNOW":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() ,
                        Math.max(super.coordinates.getHeight() - 12, 0)
                );
                Logger.log(
                        "Helicopter#" + super.name + "(" + super.id + "): Let it snow!:))."
                );
                break;
            //default:
                //throw new UnknownWeatherException("Unknown weather: " + weather);
        }
        super.coordinates = newCoordinates;
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.log(
                "Tower says: Helicopter#" + super.name + "(" + super.id + ") registered to weather tower."
        );
    }
}
