import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\\n");

        Die[] dice = {new Die(), new Die()};

        String[] countryNames = {
                "Zambia", "Egypt", "Peru", "Indonesia", "Brazil",
                "Japan", "Germany", "Australia", "Mexico", "Italy",
                "Canada", "Kenya", "Thailand", "Argentina", "Netherlands",
                "Turkey", "South Korea", "France", "Spain", "India",
                "China", "Russia", "Vietnam", "Pakistan", "Iran",
                "Nigeria", "South Africa", "Colombia", "Chile", "Sweden",
                "Ukraine", "Poland", "Greece", "Saudi Arabia", "Czech Republic",
                "Ireland", "New Zealand", "Malaysia", "Singapore", "Switzerland"
        };

        Square[] squares  = new Square[40];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new Square(countryNames[i]);
        }

        Board board = new Board(squares);

        System.out.print("Number of player: ");
        int n = in.nextInt();
        Player[] players = new Player[n];

        for(int i = 0; i < n; i++){
            Piece piece = new Piece(board.getSquare(0));

            System.out.printf("Player %d name: ", i+1);
            String name = in.next();
            Player player = new Player(name, dice, piece, board);

            players[i] = player;
        }

        MGame game = new MGame(10, board, dice, players);

        game.playGame();
    }
}