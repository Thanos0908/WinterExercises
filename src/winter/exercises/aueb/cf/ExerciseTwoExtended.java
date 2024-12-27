package winter.exercises.aueb.cf;
/*
A simple program returning the maximum sum subarray of an array using Kadane's algorithm
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseTwoExtended {
    public static void main(String[] args) {
        // Prompt the user to enter numbers to populate the target array
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> integerList = new ArrayList<>();

        System.out.println("Please enter integers to create the array (type 'exit' to stop):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                integerList.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer or 'exit' to finish.");
            }
        }

        // Convert ArrayList to array
        int[] userArray = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            userArray[i] = integerList.get(i);
        }

        // Close the scanner
        scanner.close();

        int sum = 0;

        System.out.println();

        // Print the given array to make it a bit more appealing to the user (not obligatory)
        if (maxSubArray(userArray).length != 0) {
            System.out.println("The maximum sum subarray of the array: ");
        } else {
            System.out.println("Can not check empty array");
        }
        for (int i = 0; i < userArray.length; i++) {
            if (i == 0) {
                System.out.print("{");
                System.out.print(userArray[i] + ", ");
            } else if (i == (userArray).length - 1) {
                System.out.println(userArray[i] + "}");
            } else
                System.out.print(userArray[i] + ", ");
        }
        // print the subarray inside {} to make it more appealing to the user instead of just using System.out.println(maxSubArray(ar)[i]);
        for (int i = 0; i < maxSubArray(userArray).length; i++) {
            sum += maxSubArray(userArray)[i];
            if (i == 0 && i != maxSubArray(userArray).length - 1 ) {
                System.out.println("is");
                System.out.print("{");
                System.out.print(maxSubArray(userArray)[i] + ", ");
            } else if (i == 0 && i == maxSubArray(userArray).length - 1)  {
                System.out.println("is");
                System.out.print("{");
                System.out.print(maxSubArray(userArray)[i]);
            } else if (i == maxSubArray(userArray).length - 1) {
                System.out.print(maxSubArray(userArray)[i]);
            } else
            System.out.print(maxSubArray(userArray)[i] + ", ");
        }
        System.out.println("}");
        System.out.println();
        System.out.println("The total sum of the subarray is: " + sum);


    }




    // Create a method that returns a subarray according to Kadane's algorithm
    public static int[] maxSubArray(int[] nums) {
        // Check if the array given is null or its length is 0 and return null if so
        if ((nums == null) || (nums.length == 0)) return new int[0];

        int startIndex = 0;
        int endIndex = 0;
        int localMaximum = 0;
        int globalMaximum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            localMaximum = Math.max(nums[i], nums[i] + localMaximum);
            globalMaximum = Math.max(localMaximum, globalMaximum);
            if (nums[i] == localMaximum & localMaximum == globalMaximum) {
                startIndex = i;
            }
            if (localMaximum == globalMaximum) {
                endIndex = i;
            }
        }
        int[] subAr =  new int[endIndex - startIndex + 1];
        if (endIndex - startIndex >= 0) System.arraycopy(nums, startIndex, subAr, 0, endIndex - startIndex + 1);
        return subAr;
    }
}
