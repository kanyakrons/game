public class Board {
    private Square[] squares;

    public Board(Square[] squares) {
        this.squares = squares;
    }

    public Square[] getSquares() {
        return squares;
    }

    public Square getSquare(int index) {
        return squares[index];
    }
}
