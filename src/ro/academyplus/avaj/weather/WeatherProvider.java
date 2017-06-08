package ro.academyplus.avaj.weather;

import ro.academyplus.avaj.simulator.WeatherTower;

/**
 * Created by root on 6/7/17.
 */
public class WeatherProvider {

    public static final WeatherProvider weatherProvider = new WeatherProvider();
    String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum;
        sum =   coordinates.getLongitude() *
                coordinates.getLatitude() +
                coordinates.getHeight() + 1;
        return weather[sum % 4];
    }


}
