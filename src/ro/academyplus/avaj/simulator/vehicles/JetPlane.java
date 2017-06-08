package ro.academyplus.avaj.simulator.vehicles;

import ro.academyplus.avaj.simulator.Logger;
import ro.academyplus.avaj.simulator.WeatherTower;
import ro.academyplus.avaj.weather.Coordinates;

/**
 * Created by root on 6/7/17.
 */
public class JetPlane extends Aircraft implements Flyable {
    WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        weatherTower = null;
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(super.coordinates);
        Coordinates newCoordinates = null;

        switch (weather) {
            case "SUN":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() + 10,
                        Math.min(super.coordinates.getHeight() + 2, 100)
                );
                Logger.log(
                      "JetPlane#" + super.name + "(" + super.id + "): Hello sunshine!"
                );
                break;
            case "RAIN":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude() + 5,
                        super.coordinates.getLatitude(),
                        super.coordinates.getHeight()
                );
                Logger.log(
                        "JetPlane#" + super.name + "(" + super.id + "): Let's hope thunder is not gonna struck us"
                );
                break;
            case "FOG":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() + 1,
                        super.coordinates.getHeight()
                );
                Logger.log(
                        "JetPlane#" + super.name + "(" + super.id + "): Everything is so blurry, could it be the LSD?"
                 );
                break;
            case "SNOW":
                newCoordinates = new Coordinates(
                        super.coordinates.getLongitude(),
                        super.coordinates.getLatitude() ,
                        Math.max(super.coordinates.getHeight() - 7  , 0)
                );
                Logger.log(
                        "JetPlane#" + super.name + "(" + super.id + "): Winter is cumming."
                );
                break;
        }
        super.coordinates = newCoordinates;
        if (newCoordinates.getHeight() <= 0) {
            this.weatherTower.unregister(this);
            Logger.log("JetPlane#" + super.name + "(" + super.id + ") landing "
                    + newCoordinates.getLongitude() + " "
                    + newCoordinates.getLatitude() + " "
                    + newCoordinates.getHeight());
            Logger.log("Tower says: JetPlane#" + super.name + "(" + super.id + ") unregistered from weather tower");
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        Logger.log(
                "Tower says: JetPlane#" + super.name + "(" + super.id + ") registered to weather tower."
        );

    }
}
