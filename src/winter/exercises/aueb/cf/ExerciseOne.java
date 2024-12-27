package winter.exercises.aueb.cf;
/*
  A program that creates a txt file with numbers 1 to 49. It then reads the file and passes
  the numbers in an array that then sorts. It then creates all possible combinations of 6 numbers.
  After that it checks every six number combination for having at most 4 even or odds numbers, 2 sequential numbers,
  3 numbers with the same last digit and lastly 3 numbers with the same first digit.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ExerciseOne {

    public static void main(String[] args) throws IOException {
        // Create a one dimensional table with numbers from 1 to 49
        int[] ar = new int[49];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = i + 1;
        }
        // Create a file and write the contents of the table in it
        File inFd = new File("F:/project files/exercise1.txt");
        try(PrintStream ps = new PrintStream(inFd)) {
            for (int token : ar) {
                ps.println(token);
        }

        }

        // Create a file that the results will be entered into
        File outFd = new File("F:/project files/combinations.txt");

        //Create an ArrayList that the program will take the data from and populate it with the elements of the file 'inFd'
        ArrayList<Integer> numbers = new ArrayList<>();
        int n = 6;
        int[] row = new int[6];

        Scanner in = new Scanner(inFd);
        while (in.hasNextInt()) {
            numbers.add(in.nextInt());
        }

        //Loop through the array list elements and populate the new .txt file table with all possible 6 number combinations from the numbers ArrayList
        try(PrintStream psOut = new PrintStream(outFd)) {
            for (int i = 0; i < numbers.size() - n; i++) {
                for (int j = i + 1; j < numbers.size() - n + 1; j++) {
                    for (int k = j + 1; k < numbers.size() - n + 2; k++) {
                        for (int l = k + 1; l < numbers.size() - n + 3; l++) {
                            for (int m = l + 1; m < numbers.size() - n + 4; m++) {
                                for (int o = m + 1; o < numbers.size() - n + 5; o++) {
                                    row[0] = numbers.get(i);
                                    row[1] = numbers.get(j);
                                    row[2] = numbers.get(k);
                                    row[3] = numbers.get(l);
                                    row[4] = numbers.get(m);
                                    row[5] = numbers.get(o);
                                    if (isEven(row)) {
                                        psOut.printf("Combination: %d\t%d\t%d\t%d\t%d\t%d\t has 4 even numbers",
                                                numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(m), numbers.get(o));
                                    } else if (isOdd(row)) {
                                        psOut.printf("Combination: %d\t%d\t%d\t%d\t%d\t%d\t has 4 odd numbers",
                                                numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(m), numbers.get(o));
                                    } else if (moreThanTwoConsecutive(row)) {
                                        psOut.printf("Combination: %d\t%d\t%d\t%d\t%d\t%d\t has more than 2 consecutive numbers",
                                                numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(m), numbers.get(o));
                                    } else if (moreThanTwoSameEndings(row)) {
                                        psOut.printf("Combination: %d\t%d\t%d\t%d\t%d\t%d\t has more than 2 numbers with same last digit",
                                                numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(m), numbers.get(o));
                                    } else if (moreThanTwoSameStart(row)) {
                                        psOut.printf("Combination: %d\t%d\t%d\t%d\t%d\t%d\t has more than 2 numbers with same first digit",
                                                numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(m), numbers.get(o));
                                    } else psOut.printf("Combination: %d\t%d\t%d\t%d\t%d\t%d\t is clean of all checks",
                                            numbers.get(i), numbers.get(j), numbers.get(k), numbers.get(l), numbers.get(m), numbers.get(o));
                                    psOut.println();
                                }


                            }
                        }
                    }
                }
            }

        }

        }

    private static boolean moreThanTwoSameStart(int[] row) {
        if (row == null) return false;
        int[] endings = new int[10];
        boolean hasSameStart = false;

        for (int item: row) {
            endings[item / 10]++;
        }
        for (int item : endings) {
            if (item >= 3) {
                break;
            }
        }
        return hasSameStart;
    }

    private static boolean moreThanTwoSameEndings(int[] row) {
        if (row == null) return false;
        int[] endings = new int[10];
        boolean hasSameEndings = false;

        for (int item: row) {
            endings[item % 10]++;
        }
        for (int item : endings) {
            if (item >= 3) {
                break;
            }
        }
        return hasSameEndings;
    }

    private static boolean moreThanTwoConsecutive(int[] row) {
        if (row == null) return false;
        int cons = 0;
        for (int i = 0; i < row.length - 2; i++) {
            if ((row[i] == row[i + 1] - 1) && (row[i] == row[i + 2] - 2)) {
                cons++;
            }
        }
        return cons >= 1;
    }

    private static boolean isOdd(int[] row) {
        if (row == null) return false;
        int count = 0;
        for (int num : row) {
            if (num % 2 != 0) count++;
        }
        return (count > 4);
    }

    private static boolean isEven(int[] row) {
        if (row == null) return false;
        int count = 0;
        for (int num : row) {
            if (num % 2 == 0) count++;
        }
        return (count > 4);
    }

}
