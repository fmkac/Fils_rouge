package games.nim;

public class Nim {
    private int n; //nb allumette
    private int k; //nb max pr enleve allumette
    private String j1; // joueur1
    private String j2; // joueur2

    private int n_courant; //nb courant allumette
    private String j_courant; //nom du joueur courant


    public Nim(int n, int k, String j1, String j2) {
        this.n = n;
        this.k = k;
        this.j1= j1;
        this.j2 = j2;

        this.n_courant = n;
        this.j_courant = j1;
    }


    public int getInitialNbMatches() {
        return this.n;
    }

    public int getCurrentNbMatches() {
        return this.n_courant;
    }

    public String getCurrentPlayer() {
        return this.j_courant;
    }


    public String situationToString() {
        return "Il reste " + getCurrentNbMatches() + " allumettes";
    }


    public void removeMatches(int r) {
        this.n_courant = this.n_courant-r;
        if (j_courant.equals(this.j1)) {
            j_courant = (this.j2);
        }
        else {
            j_courant = this.j1;
        }
    }

    public boolean isValid(int r) {
        if (r>0 && r<=this.n_courant && r<= this.k) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOver() {
        if (this.n_courant == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getWinner() {
        if (isOver()) {
            return this.j_courant;
        }
        else {
            return null;
        }
    }

}