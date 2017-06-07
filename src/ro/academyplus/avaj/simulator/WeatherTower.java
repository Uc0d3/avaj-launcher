package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.weather.Coordinates;
import ro.academyplus.avaj.weather.WeatherProvider;

/**
 * Created by root on 6/7/17.
 */
public class WeatherTower extends Tower{

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);

    }

    void changeWeather() {
        super.conditionsChanged();
    }
}
