package winter.exercises.aueb.cf;
/*
Creates a simple program that reads through a file and stores the chars it founds into a dimensional
array of 128 rows and 2 columns. In the first column will be the character and on the second column the
times it has been encountered
 */
import java.io.*;
import java.util.Scanner;


public class ExerciseThree {

    public static void main(String[] args) {
        // Define the file to be read
        Scanner file = new Scanner(System.in);
        System.out.println("Please enter a valid file to be read: ");
        String path = file.nextLine();
        // Replace with the path to your file

        // Create a 2D array with 128 rows (ASCII characters) and 2 columns
        int[][] charCounts = new int[128][2];

        // Initialize the first column with ASCII values and set the second column counter to zero
        for (int i = 0; i < 128; i++) {
            charCounts[i][0] = i;
            charCounts[i][1] = 0;
        }

        // Create a FileReader that we use to read each character in the file in ASCII code
        try (FileReader reader = new FileReader(path)) {
            int character;
            while ((character = reader.read()) != -1) {
                // Ignore whitespace characters
                if (!Character.isWhitespace(character)) {
                    if (character < 128) {
                        charCounts[character][1]++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            return;
        }

        // Print the characters that appear at least one and their occurrences
        System.out.println("Character |  Times appeared");
        System.out.println("-----------------------");
        for (int i = 0; i < 128; i++) {
            if (charCounts[i][1] > 0) {
                System.out.println((char) charCounts[i][0] + " ------------> " + charCounts[i][1]);
            }
        }
    }
}
