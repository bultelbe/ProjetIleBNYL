package projetilebnyl;

import java.util.ArrayList;

public class Explorateur extends Aventurier {

    public Explorateur(String nomJ, Tuile positionCourante) {
        super(nomJ, positionCourante);
    }
    
    
    public ArrayList<Tuile> assechementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesDiag = new ArrayList<>();
        tuilesDiag = grille.getListeTuileDiag(positionCourante);
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj = grille.getListeTuileAdj(positionCourante);
        
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = tuilesDiag;
        
        for (Tuile t : tuilesAdj) {
            tuilesAssechables.add(t);
        }
        return tuilesAssechables;
    }
    
}
