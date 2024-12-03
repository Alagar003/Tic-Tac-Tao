public class Board {
    private char[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < size; i++) {
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            if (i < size - 1) {
                for (int j = 0; j < size; j++) {
                    System.out.print("~~");
                }
                System.out.println("~");
            }
        }
    }

    public boolean placeMark(int row, int col, char playerSymbol) {
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == ' ') {
            board[row][col] = playerSymbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(int row, int col, char playerSymbol) {
        int[][] directions = {{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        
        for (int[] direction : directions) {
            int count = 1;
            int x = row + direction[0];
            int y = col + direction[1];
            
            // Check in one direction
            while (x >= 0 && x < size && y >= 0 && y < size && board[x][y] == playerSymbol) {
                count++;
                x += direction[0];
                y += direction[1];
            }
            
            // Check in the opposite direction
            x = row - direction[0];
            y = col - direction[1];
            while (x >= 0 && x < size && y >= 0 && y < size && board[x][y] == playerSymbol) {
                count++;
                x -= direction[0];
                y -= direction[1];
            }
            
            if (count >= size) {
                return true;
            }
        }
        
        return false;
    }

    public boolean checkTie() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
