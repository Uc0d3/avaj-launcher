package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.exceptions.InvalidAircraftException;
import ro.academyplus.avaj.exceptions.InvalidCoordException;
import ro.academyplus.avaj.simulator.vehicles.AircraftFactory;
import ro.academyplus.avaj.simulator.vehicles.Flyable;
import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 6/7/17.
 */
public class Simulator {
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();

    public static void main(String[] arg) throws InterruptedException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arg[0]));
            String line = reader.readLine();
            if (line != null) {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line  = reader.readLine()) != null) {
                    String[] fields = line.split(" ");
                    Flyable flyable = AircraftFactory.newAircraft( fields[0], fields[1],
                            Integer.parseInt(fields[2]),
                            Integer.parseInt(fields[3]),
                            Integer.parseInt(fields[4]));
                    flyables.add(flyable);
                }

                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 0; i < simulations; i++) {
                    weatherTower.changeWeather();
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find file " + arg[0]);
        } catch (IOException e) {
            System.out.println("There was an error while reading the file " + arg[0]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Malformed or corrupt scenario file");
        }
        catch (NumberFormatException e){
            System.out.println("Invalid Coordinates in file");
        }
        catch (InvalidCoordException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidAircraftException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            Logger.close();
        }
    }
}
