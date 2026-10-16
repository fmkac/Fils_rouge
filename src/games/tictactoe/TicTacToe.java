package games.tictactoe;

import java.util.HashMap;

public class TicTacToe{
    private String joueur1 ; 
    private String joueur2 ; 
    private String[][] tab ; 
    private String joueurCourent ; 

    public TicTacToe(String joueur1, String joueur2){
        this.joueur1 = joueur1 ; 
        this.joueur2 = joueur2 ; 
        this.tab = new String[3][3] ; 
        this.joueurCourent = joueur1; 
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                this.tab[r][c] = ".";
            }
        }
    }

    public String getCurrentPlayer(){
        return this.joueurCourent; 
    }

    public void execute(int row , int col){
        if (getCurrentPlayer().equals(this.joueur1)){
             tab[row][col] = this.joueur1;
             this.joueurCourent = this.joueur2; 
        }
        else{
            tab[row][col] = this.joueur2;
            this.joueurCourent = this.joueur1; 
        }
    }

    public boolean isValid(int row, int col){
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return ".".equals(this.tab[row][col]);
        }
        return false ;
    }

    public boolean wins(String joueur, int row, int col , int deltaRow , int deltaCol){
        int r1 = row;
        int c1 = col;
        int r2 = row + deltaRow;
        int c2 = col + deltaCol;
        int r3 = row + 2 * deltaRow;
        int c3 = col + 2 * deltaCol;

        if (r3 < 0 || r3 >= 3 || c3 < 0 || c3 >= 3) {
            return false;
        }
        return joueur.equals(tab[r1][c1]) && joueur.equals(tab[r2][c2]) && joueur.equals(tab[r3][c3]);
    }

    public String getWinner() {
        String[] joueurs = {this.joueur1, this.joueur2};
        for (String j : joueurs) {
            for (int r = 0; r < 3; r++) {
                if (wins(j, r, 0, 0, 1)) {
                    return j;
                }
            }
            for (int c = 0; c < 3; c++) {
                if (wins(j, 0, c, 1, 0)) {
                    return j;
                }
            }
            if (wins(j, 0, 0, 1, 1)) {
                return j;
            }
            if (wins(j, 2, 0, -1, 1)) {
                return j;
            }
        }

        return null;
    }

    public boolean isOver() {
        // Si un joueur a gagné, la partie est terminée
        if (getWinner() != null) {
            return true;
        }
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (tab[r][c] == ".") {
                    return false; // Il reste des cases à jouer
                }
            }
        }
        return true;
    }
    public String situationToString() {
        String res = "";
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                res += this.tab[r][c];
                if (c < 2) {
                    res += " ";
                }
            }
            res += System.lineSeparator();
        }
        return res;
    }
    
}