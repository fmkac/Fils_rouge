package games.tictactoe ;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe("X", "O");

        while (!game.isOver()) {
            System.out.println(game.situationToString());
            String joueur = game.getCurrentPlayer();
            System.out.println("C'est au joueur " + joueur + " de jouer (ligne puis colonne, 0 à 2) : ");

            int r = scanner.nextInt();
            int c = scanner.nextInt();

            if (game.isValid(r, c)) {
                game.execute(r, c);
            } else {
                System.out.println("Coup invalide, réessayez !");
            }
        }

        // Affichage final
        System.out.println(game.situationToString());
        String winner = game.getWinner();
        if (winner != null) {
            System.out.println("Le joueur " + winner + " a gagné !");
        } else {
            System.out.println("Match nul !");
        }

        scanner.close();
    }
}