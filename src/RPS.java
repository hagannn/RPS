import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RPS {
    static String getMove(String prompt) throws IOException {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        System.out.print(prompt);
        String input = br.readLine();
        input = input.toLowerCase();

        if (!input.equals("r") && !input.equals("p") && !input.equals("s")) {
            System.out.println("Invalid move");
            return getMove(prompt);
        }
        return input;
    }

    static int checkPlayerWin(String player, String computer) {
        switch (player) {
            case "r":
                switch (computer) {
                    case "r":
                        System.out.println("Rock vs Rock");
                        return 0;
                    case "p":
                        System.out.println("Paper covers rock");
                        return 2;
                    case "s":
                        System.out.println("Rock breaks Scissors");
                        return 1;
                }
            case "p":
                switch (computer) {
                    case "r":
                        System.out.println("Paper covers rock");
                        return 1;
                    case "p":
                        System.out.println("Paper vs Paper");
                        return 0;
                    case "s":
                        System.out.println("Scissors cuts Paper");
                        return 2;
                }
            case "s":
                switch (computer) {
                    case "r":
                        System.out.println("Rock breaks Scissors");
                        return 2;
                    case "p":
                        System.out.println("Scissors cuts Paper");
                        return 1;
                    case "s":
                        System.out.println("Scissors vs Scissors");
                        return 0;
                }

            default:
                return -1;
        }
    }

    static boolean playAgain() throws IOException {
        InputStreamReader sr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(sr);

        System.out.print("Play again [Y/N]: ");
        String input = br.readLine();
        input = input.toLowerCase();

        if (input.equals("y")) {
            return true;
        } else if (input.equals("n")) {
            return false;
        } else {
            return playAgain();
        }
    }

    public static void main(String[] args) throws IOException {
        boolean playing = true;
        String playerMove;
        String player1;
        int playerWin = 0;

        while (playing) {

            while (playerWin == 0) {
                playerMove = getMove("PlayerA move (R,P,S): ");
                player1 = getMove("PlayerB move (R,P,S): ");

                playerWin = checkPlayerWin(playerMove, player1);

                if (playerWin == 0) {
                    System.out.println("Tie\n");
                } else if (playerWin == 1) {
                    System.out.println("PlayerA wins\n");
                } else if (playerWin == 2) {
                    System.out.println("PlayerB wins\n");
                }

            }
            playerWin = 0;
            playing = playAgain();
        }


    }
}
