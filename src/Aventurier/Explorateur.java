package Aventurier;

import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import java.awt.Color;
import java.util.ArrayList;
import Vues.Utils;
import static Vues.Utils.EtatTuile.*;

public class Explorateur extends Aventurier {

    public Explorateur(String nomJ, Tuile positionCourante,String noma) {
        super(nomJ, positionCourante, noma);
    }
    
    @Override
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesAdj = super.deplacementsPossibles(grille);
        ArrayList<Tuile> tuilesDiag = new ArrayList<>();
        tuilesDiag = grille.getListeTuileDiag(getPositionCourante());
        
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        tuilesPossibles = tuilesDiag;
        
        for (Tuile t : tuilesAdj) {
            if (t.getStatut() != COULEE)
                tuilesPossibles.add(t);
        }
        return tuilesPossibles;
    }
    
    
    public ArrayList<Tuile> assechementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesAdj = super.assechementsPossibles(grille);
        ArrayList<Tuile> tuilesDiag = new ArrayList<>();
        tuilesDiag = grille.getListeTuileDiag(getPositionCourante());
        
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = tuilesDiag;
        tuilesAssechables.add(getPositionCourante());
        
        for (Tuile t : tuilesAdj) {
            if (t.getStatut() == INONDEE)
            tuilesAssechables.add(t);
        }
        return tuilesAssechables;
    }

    @Override
    public Color getColor() {
        return Utils.Pion.VERT.getCouleur();
    }
    
}
