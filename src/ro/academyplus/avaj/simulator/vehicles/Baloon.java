package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.simulator.Logger;
import ro.academyplus.avaj.simulator.WeatherTower;
import ro.academyplus.avaj.weather.Coordinates;

/**
 * Created by root on 6/7/17.
 */
public class Baloon extends Aircraft implements Flyable {
    WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = null;
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        Coordinates newCoordinates = null;

        switch (weather) {
            case "SUN":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude() + 2,
                        super.coordinates.getLatitude() ,
                        Math.min(super.coordinates.getHeight() + 4, 100)
                );
                Logger.getLogger().log(
                        "Baloon#" + super.name + "(" + super.id + "): Let's enjoy the good weather and take some pics."
                );
                break;
            case "RAIN":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude() + 5,
                        super.coordinates.getLatitude(),
                        Math.max(super.coordinates.getHeight() - 5, 0)
                );
                Logger.getLogger().log(
                        "Baloon#" + super.name + "(" + super.id + "): Damn you rain! You messed up my baloon."
                );
                break;
            case "FOG":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude() + 1,
                        super.coordinates.getLatitude(),
                        Math.max(super.coordinates.getHeight() - 3, 0)
                );
                Logger.getLogger().log(
                        "Baloon#" + super.name + "(" + super.id + "): Where are you Jack? It's to foggy"
                );
                break;
            case "SNOW":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() ,
                        Math.max(super.coordinates.getHeight() - 15, 0)
                );
                Logger.getLogger().log(
                        "Baloon#" + super.name + "(" + super.id + "): It's snowing. We're gonna crash."
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
        Logger.getLogger().log(
                "Tower says: Baloon#" + super.name + "(" + super.id + ") registered to weather tower."
        );

    }
}
