package ro.academyplus.avaj.simulator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by root on 6/7/17.
 */
public class Logger {
    private static BufferedWriter bufferedWriter = null;
    public static final Logger logger = new Logger();

    private Logger(){
        if (bufferedWriter == null) {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(new File("simulation.txt")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Logger getLogger() {

        return logger;
    }

    public void log(String log) {
        try {
            bufferedWriter.write(log);
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
