public class Player {
    private char currentPlayer;
    private String player1;
    private String player2;
    private String player3;
    private boolean isTwoPlayerGame;
    private int score1;
    private int score2;
    private int score3;

    public Player(String player1, String player2, String player3) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.isTwoPlayerGame = false;
        this.score1 = 0;
        this.score2 = 0;
        this.score3 = 0;
        currentPlayer = 'X';
    }

    public Player(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = null;
        this.isTwoPlayerGame = true;
        this.score1 = 0;
        this.score2 = 0;
        this.score3 = 0;
        currentPlayer = 'X';
    }

    public void switchPlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else if (currentPlayer == 'O' && !isTwoPlayerGame) {
            currentPlayer = '#';
        } else {
            currentPlayer = 'X';
        }
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public String getPlayerName() {
        switch (currentPlayer) {
            case 'X':
                return player1;
            case 'O':
                return player2;
            default:
                return player3;
        }
    }

    public String getPlayerName1() {
        return player1;
    }

    public String getPlayerName2() {
        return player2;
    }

    public String getPlayerName3() {
        return player3;
    }

    public boolean isTwoPlayerGame() {
        return isTwoPlayerGame;
    }

    public void updateScore(int points) {
        switch (currentPlayer) {
            case 'X':
                score1 += points;
                break;
            case 'O':
                score2 += points;
                break;
            case '#':
                score3 += points;
                break;
        }
    }

    public int getScore(String playerName1) {
        switch (currentPlayer) {
            case 'X':
                return score1;
            case 'O':
                return score2;
            case '#':
                return score3;
            default:
                return 0;
        }
    }
}
