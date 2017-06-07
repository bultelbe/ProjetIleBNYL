package projetilebnyl;

import java.util.ArrayList;

public class Explorateur extends Aventurier {

    public Explorateur(String nomJ, int capacite, Tuile positionCourante) {
        super(nomJ, capacite, positionCourante);
    }
    
    
    public void assechementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesDiag = new ArrayList<>();
        tuilesDiag = grille.getListeTuileDiag(positionCourante);
        
    }
    
}
