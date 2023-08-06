public class MGame {
    private int roundCnt;
    private Board board;
    private Die[] dice;
    private Player[] players;

    public MGame(int roundCnt, Board board, Die[] dice, Player[] players) {
        this.roundCnt = roundCnt;
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    public void playGame() {
        for (int round = 0; round < roundCnt; round++) {
            System.out.printf("----------ROUND %d----------\n", round+1);
            playRound();
        }
    }

    private void playRound() {
        for (Player player : players) {
            System.out.printf("%s's turn\n", player.getName());
            player.takeTurn();
        }
    }
}
