package games.tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe("X", "O");

        while (!game.isOver()) {
            System.out.println(game.situationToString());
            String joueur = game.getCurrentPlayer();
            System.out.println("C'est au joueur " + joueur + " de jouer : ");
            int r = lireEntier(scanner, "ligne (0 à 2) : ");
            int c = lireEntier(scanner, "colonne (0 à 2) : ");
            if (game.isValid(r, c)) {
                game.execute(r, c);
            } else {
                System.out.println("coup invalide, ressayez !\n");
            }
        }

        System.out.println(game.situationToString());
        String winner = game.getWinner();
        if (winner != null) {
            System.out.println("le joueur " + winner + " a gagne !");
        } else {
            System.out.println("match nul !");
        }
        scanner.close();
    }

    public static int lireEntier(Scanner scan, String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(scan.next());
        } catch (NumberFormatException exception) {
            System.out.println("Le nombre que vous avez saissis n'est pas valide ressayez : ");
            return lireEntier(scan, message);
        }
    }
}