import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player playerObj;

        clearConsole();
        System.out.println("Enter player names (optional => - - -)(- - !):");
        String player1 = scanner.next();
        String player2 = scanner.next();
        String player3 = scanner.next();

        if (player1.equals("-") && player2.equals("-") && player3.equals("-")) {
            playerObj = new Player("X", "O", "#");
        } else if (!player1.equals("-") && !player2.equals("-") && !player3.equals("!")) {
            playerObj = new Player(player1, player2, player3);
        } else if (player1.equals("-") && player2.equals("-") && player3.equals("!")) {
            playerObj = new Player("X", "O");
        } else {
            playerObj = new Player(player1, player2);
        }

        clearConsole();
        System.out.println("Welcome to Tic Tac Toe game " + playerObj.getPlayerName1() + " & " + playerObj.getPlayerName2() + (!playerObj.isTwoPlayerGame() ? " & " + playerObj.getPlayerName3() : "") + "!");
        System.out.println("Enter board size:");
        int size = scanner.nextInt();

        while (size < 3) {
            System.out.println("Board size should be greater than or equal to 3. Enter again:");
            size = scanner.nextInt();
        }

        Board board = new Board(size);
        boolean gameWon = false;
        String invalidInputMessage = "";

        while (!gameWon) {
            clearConsole();
            if (!invalidInputMessage.isEmpty()) {
                System.out.println(invalidInputMessage);
                invalidInputMessage = "";
            }
            board.printBoard();
            System.out.println(playerObj.getPlayerName1() + " score: " + playerObj.getScore(playerObj.getPlayerName1()));
            System.out.println(playerObj.getPlayerName2() + " score: " + playerObj.getScore(playerObj.getPlayerName2()));
            if (!playerObj.isTwoPlayerGame()) {
                System.out.println(playerObj.getPlayerName3() + " score: " + playerObj.getScore(playerObj.getPlayerName3()));
            }
            String currentPlayerName = playerObj.getPlayerName();
            char currentSymbol = playerObj.getCurrentPlayer();
            System.out.println("Current player: " + currentPlayerName + " (" + currentSymbol + ")");
            System.out.print("Enter row (0 to " + (size - 1) + ") and column (0 to " + (size - 1) + "): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board.placeMark(row, col, currentSymbol)) {
                gameWon = board.checkWin(row, col, currentSymbol);
                if (board.checkTie()) {
                    System.out.println("Game tied!");
                    gameWon = true;
                }
                if (!gameWon) {
                    playerObj.switchPlayer();
                }
            } else {
                invalidInputMessage = "This position is already taken or invalid. Try again.";
            }
        }
        clearConsole();
        board.printBoard();
        System.out.println("Player " + playerObj.getPlayerName() + " wins!");
        System.out.println("Game over!");
        System.out.print("Do you want to play again? (y/n): ");
        String playAgain = scanner.next();

        if (playAgain.equalsIgnoreCase("y")) {
            main(args);
        }
        scanner.close();
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing console");
        }
    }
}
