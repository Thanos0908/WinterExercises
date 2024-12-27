package winter.exercises.aueb.cf;
/*
A simple program returning the maximum sum subarray of an array using Kadane's algorithm
Please check the ExerciseTwoExtended class if you need a more user appealing approach
 */

public class ExerciseTwo {

    public static void main(String[] args) {
        // Create the target array and use the method in it
        int[] ar = {-2, 1,-3, 4, -1, 2, 1, -5, 4};
        int sum = 0;
        // Simple solution
        for (int i = 0; i < maxSubArray(ar).length; i++) {
            sum += maxSubArray(ar)[i];
            System.out.print(maxSubArray(ar)[i] + " ");
        }
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
