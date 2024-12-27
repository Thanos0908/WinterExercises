package winter.exercises.aueb.cf;
/*
This is a simple tic-tac-toe game
 */
import java.util.Scanner;

public class ExerciseFour {

    public static void main(String[] args) {
        // create the board table and get the players' names
        char[][] array = new char[3][3];
        Scanner playerOne = new Scanner(System.in);
        System.out.println("Please enter first player's name: ");
        String firstPlayer = playerOne.nextLine();
        Scanner playerTwo = new Scanner(System.in);
        System.out.println("Please enter second's player's name: ");
        String secondPlayer = playerTwo.nextLine();
        System.out.printf("%s plays with (x) and %s plays with (o)", firstPlayer, secondPlayer);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = ' ';
            }
        }

        int turnsPlayed = 0;
        boolean winCase = false;
        while (turnsPlayed < 9 && !winCase) {
            playerOneMove(array, firstPlayer);
            turnsPlayed++;
            winCase = winCheck(array, firstPlayer, secondPlayer);
            if (!winCase && turnsPlayed < 9) {
                playerTwoMove(array, secondPlayer);
                viewBoard(array);
                turnsPlayed++;
                winCase = winCheck(array, firstPlayer, secondPlayer);
            } else if (winCase) {
                viewBoard(array);
            } else {
                System.out.println("It is a tie!");
            }

        }


    }
    // create a method to display the board table
    public static void viewBoard(char[][] ar) {
        System.out.println("|-----------|");
        System.out.println("| " + ar[0][0] + " | " + ar[0][1] + " | " + ar[0][2] + " |");
        System.out.println("| " + ar[1][0] + " | " + ar[1][1] + " | " + ar[1][2] + " |");
        System.out.println("| " + ar[2][0] + " | " + ar[2][1] + " | " + ar[2][2] + " |");
        System.out.println("|-----------|");
    }
    // create play method for first player and check if the position entered is free
    public static void playerOneMove(char[][] ar, String name) {
        while (true) {
            System.out.println("available positions");
            viewBoard(ar);
            Scanner moveRow = new Scanner(System.in);
            System.out.println(name + " please choose a row to enter (x) (1 ,2 ,3)");
            int row = getValidInteger(moveRow);
            Scanner moveColumn = new Scanner(System.in);
            System.out.println(name + " please choose a column to enter (x) (1, 2, 3)");
            int column = getValidInteger(moveColumn);
            if (ar[row - 1][column - 1] != ' ') {
                System.out.println("Please choose an empty position");
            } else {
                ar[row - 1][column - 1] = 'x';
                break;
            }
        }
    }
    // create play method for second player and check if the position entered is free
    public static void playerTwoMove(char[][] ar, String name) {
        while (true) {
            System.out.println("available positions");
            viewBoard(ar);
            Scanner moveRow = new Scanner(System.in);
            System.out.println(name + " please choose a row to enter (o) (1 ,2 ,3)");
            int row = getValidInteger(moveRow);
            Scanner moveColumn = new Scanner(System.in);
            System.out.println(name + " please choose a column to enter (o) (1, 2, 3)");
            int column = getValidInteger(moveColumn);
            if (ar[row - 1][column - 1] != ' ') {
                System.out.println("Please choose an empty position");
            } else {
                ar[row - 1][column - 1] = 'o';
                break;
            }
        }
    }

    public static boolean winCheck(char[][] ar, String player1, String player2) {
        boolean win = false;
        // check horizontal win
        if ((ar[0][0] == ar[0][1] && ar[0][1] == ar[0][2] && ar[0][0] == 'x') ||
                (ar[1][0] == ar[1][1] && ar[1][1] == ar[1][2] && ar[1][0] == 'x') ||
                (ar[2][0] == ar[2][1] && ar[2][1] == ar[2][2] && ar[2][0] == 'x')) {
            System.out.println(player1 + " wins!");
            win = true;
        } else if ((ar[0][0] == ar[0][1] && ar[0][1] == ar[0][2] && ar[0][0] == 'o') ||
                (ar[1][0] == ar[1][1] && ar[1][1] == ar[1][2] && ar[1][0] == 'o') ||
                (ar[2][0] == ar[2][1] && ar[2][1] == ar[2][2] && ar[2][0] == 'o')) {
            System.out.println(player2 + " wins!");
            win = true;
        }
        //check vertical win
        if ((ar[0][0] == ar[1][0] && ar[1][0] == ar[2][0] && ar[0][0] == 'x') ||
                (ar[0][1] == ar[1][1] && ar[1][1] == ar[2][1] && ar[0][1] == 'x') ||
                (ar[0][2] == ar[1][2] && ar[1][2] == ar[2][2] && ar[0][2] == 'x')) {
            System.out.println(player1 + " wins!");
            win = true;
        } else if ((ar[0][0] == ar[1][0] && ar[1][0] == ar[2][0] && ar[0][0] == 'o') ||
                (ar[0][1] == ar[1][1] && ar[1][1] == ar[2][1] && ar[0][1] == 'o') ||
                (ar[0][2] == ar[1][2] && ar[1][2] == ar[2][2] && ar[0][2] == 'o')) {
            System.out.println(player2 + " wins!");
            win = true;
        }
        //check diagonal win
        if ((ar[0][0] == ar[1][1] && ar[1][1] == ar[2][2] && ar[0][0] == 'x') ||
                (ar[2][0] == ar[1][1] && ar[1][1] == ar[0][2] && ar[2][0] == 'x')){
            System.out.println(player1 + " wins!");
            win = true;
        } else if ((ar[0][0] == ar[1][1] && ar[1][1] == ar[2][2] && ar[0][0] == 'o') ||
                (ar[2][0] == ar[1][1] && ar[1][1] == ar[0][2] && ar[2][0] == 'o')){
            System.out.println(player2 + " wins!");
            win = true;
        }
        return win;
    }
    // create a method to check if the users input is an int between 1 and 3 (to use in play methods)
    public static int getValidInteger(Scanner scanner) {
        int number;
        while (true) {
            System.out.print("Please give a number between 1 and 3 : ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number >= 1 && number <= 3) {
                    break;
                } else {
                    System.out.println("Please give a number between 1 and 3");
                }
            } else {
                System.out.println("Invalid input. That's not a number.");
                // we need to consume the invalid token that Scanner.nextInt()
                // encountered so we use scanner.next() to read and remove the token
                // so it can prompt the user to enter again another input
                scanner.next();
            }
        }
        return number;
    }
}
