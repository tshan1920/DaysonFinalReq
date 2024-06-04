import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Class to read the radius from a file, calculate the area of a circle,
 * and write the area to a file.
 */
public class DaysonChristianFinalReq {

    public static void main(String[] args) {
        // Define the filename from which to read the radius
        String filename = "radius.txt";
        
        // Read the radius from the file
        BigDecimal radius = readRadiusFromFile(filename);
        
        // Calculate the area of the circle
        BigDecimal area = calculateArea(radius);
        
        // Output the result
        System.out.println("Radius read from file: " + radius);
        System.out.println("Area of the circle: " + area);

        // Write the area to a file
        writeAreaToFile(area, "area.txt");
    }

    /**
     * Reads the radius from the specified file.
     *
     * @param filename the name of the file to read from
     * @return the radius read from the file
     */
    private static BigDecimal readRadiusFromFile(String filename) {
        BigDecimal radius = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            if (line != null) {
                // Parse the radius from the file
                radius = new BigDecimal(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return radius;
    }

    /**
     * Calculates the area of a circle given its radius.
     *
     * @param radius the radius of the circle
     * @return the area of the circle
     */
    private static BigDecimal calculateArea(BigDecimal radius) {
        BigDecimal pi = new BigDecimal("3.14159"); // Using a more precise value of pi
        return pi.multiply(radius).multiply(radius);
    }

    /**
     * Writes the area to the specified file.
     *
     * @param area the area of the circle to write
     * @param fileName the name of the file to write to
     */
    public static void writeAreaToFile(BigDecimal area, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write("Area of the circle: " + area.toString());
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
