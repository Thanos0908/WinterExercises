package winter.exercises.aueb.cf;
// A simple program with 2 methods to reserve and cancel reservation of seats in a theatre
public class ExerciseFive {
    //create a private boolean to be accessed from every method in the class
    private static boolean[][] seats = new boolean[30][12];
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 12; j++) {
                seats[i][j] = false;
            }
        }


    }
    // create the book method if the seat is already booked display a message
    public static void book(char column, int row) {
        int columnIndex = column - 'A';
        int rowIndex = row - 1;
        if (!seats[rowIndex][columnIndex]) {
            seats[rowIndex][columnIndex] = true;
            System.out.println("Seat " + column + row + " is now booked. Enjoy the play!");
        } else {
            System.out.println("Seat " + column + row + " is already booked");
        }

    }

    // create the cancel method
    public static void cancel(char column, int row) {
        int columnIndex = column - 'A';
        int rowIndex = row - 1;
        if (seats[rowIndex][columnIndex]) {
            seats[rowIndex][columnIndex] = false;
            System.out.println("Seat " + column + row + " is free now.");
        } else {
            System.out.println("The seat is not booked so no need to cancel.");
        }
    }


}
