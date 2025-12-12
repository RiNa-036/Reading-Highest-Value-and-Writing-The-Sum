import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputFile = "Input.txt";
        String outputFile = "Output.txt";

        long sum = 0;
        int highestSoFar = Integer.MIN_VALUE;
        StringBuilder highestList = new StringBuilder();

        try {
            Scanner scanner = new Scanner(new File(inputFile));
            scanner.useDelimiter(",\\s*");

            while (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                sum += value;
                if (value > highestSoFar) {
                    highestSoFar = value;
                    highestList.append(value).append(", ");
                }
            }
            scanner.close();

            PrintWriter writer = new PrintWriter(outputFile);
            writer.println(highestList.toString());
            writer.println(sum);
            writer.close();

            System.out.println("Done");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
