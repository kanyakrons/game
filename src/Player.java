public class Player {
    private String name;
    private Die[] dice;
    private Piece piece;
    private Board board;

    public Player(String name, Die[] dice, Piece piece, Board board) {
        this.name = name;
        this.dice = dice;
        this.piece = piece;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void takeTurn() {
        Square currentLocation = piece.getLocation();
        int currentIndex = findSquareIndex(currentLocation);
        System.out.printf("     Current location: %s\n", currentLocation.getName());

        System.out.print("     Roll! ");
        for (Die die : dice) {
            die.roll();
        }
        int totalRoll = dice[0].getFaceValue() + dice[1].getFaceValue();
        System.out.printf("%d\n", totalRoll);

        int newIndex = (currentIndex + totalRoll) % board.getSquares().length;
        Square newLocation = board.getSquare(newIndex);
        piece.setLocation(newLocation);
        System.out.printf("     New Location: %s\n", newLocation.getName());
    }

    private int findSquareIndex(Square square) {
        for (int i = 0; i < board.getSquares().length; i++) {
            if (board.getSquare(i) == square) {
                return i;
            }
        }
        return -1;
    }
}
