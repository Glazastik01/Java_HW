package java_HW2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;


public class task_3_HW2 {
    private static final Logger logger = Logger.getLogger(task_3_HW2.class.getName());
    public static void main(String[] args) {
        byte num = 0;
        try {
            num = Byte.parseByte(args[0]);
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Invalid number format", e);
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.log(Level.SEVERE, "No input number provided", e);
            return;
        }
        try (FileWriter writer = new FileWriter("result.txt")) {
            writer.write(Byte.toString(num));
            logger.log(Level.INFO, "Number written to file");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error writing to file", e);
        }
    }
}
