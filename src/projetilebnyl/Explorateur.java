package projetilebnyl;

import java.awt.Color;
import java.util.ArrayList;

public class Explorateur extends Aventurier {

    public Explorateur(String nomJ, Tuile positionCourante,String noma) {
        super(nomJ, positionCourante, noma);
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

    @Override
    public Color getColor() {
        return Utils.Pion.VERT.getCouleur();
    }
    
}
