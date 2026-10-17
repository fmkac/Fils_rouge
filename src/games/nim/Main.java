package games.nim;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nom du joueur 1 : ");
        String player1 = scanner.next();

        System.out.print("Nom du joueur 2 : ");
        String player2 = scanner.next();

        System.out.print("Nombre d'allumettes au depart : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Saisie invalide : veuillez entrer un nombre entier valide.");
            scanner.next();
            System.out.print("Nombre d'allumettes au départ : ");
        }
        int n = scanner.nextInt();

        System.out.print("Nombre max d'allumettes retirables par tour : ");
        while (!scanner.hasNextInt()) {
            System.out.println("Saisie invalide : veuillez entrer un nombre entier valide.");
            scanner.next();
            System.out.print("Nombre max d'allumettes retirables : ");
        }
        int k = scanner.nextInt();

        Nim game = new Nim(n, k, player1, player2);

        while (game.isOver() == false) {
            System.out.println(game.situationToString());
            System.out.println("C'est a " + game.getCurrentPlayer() + " de jouer.");

            int move = 0;
            boolean valid = false;

            while (!valid) {
                System.out.print("Combien d'allumettes voulez-vous enlever ? ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Saisie invalide : veuillez entrer un nombre entier valide.");
                    scanner.next();
                    System.out.print("Combien d'allumettes voulez-vous retirer ? ");
                }
                move = scanner.nextInt();

                if (game.isValid(move)) {
                    valid = true;
                } else {
                    System.out.println("Coup non valide, reessayez.");
                }
            }

            game.removeMatches(move);
        }

        System.out.println(game.situationToString());
        System.out.println("La partie est terminee ! Le gagnant est " + game.getWinner() + ".");

        scanner.close();
    }
}

