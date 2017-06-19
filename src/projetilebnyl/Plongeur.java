package projetilebnyl;

import java.awt.Color;
import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public class Plongeur extends Aventurier {

    public Plongeur(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    
    @Override
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        Tuile tuileL;
        ArrayList<Tuile> tuilesPossibles = super.deplacementsPossibles(grille);
        
        ArrayList<Tuile> tuilesTrav = new ArrayList();
        tuilesTrav.add(positionCourante);
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            tuileL = tuilesTrav.get(i);
            
            if (tuileL.getStatut() != COULEE)
                tuilesPossibles.add(tuileL);
            
            for (Tuile tuile : grille.getListeTuileAdj(tuileL)) {
                if (tuile.getStatut() != COULEE && !tuilesPossibles.contains(tuile))
                    tuilesPossibles.add(tuile);
                
                else if (tuile.getStatut() != ASSECHEE && !tuilesTrav.contains(tuile))
                    tuilesTrav.add(tuile);
            }
        }   
        
        tuilesPossibles.remove(positionCourante);
        return tuilesPossibles;
    }

    @Override
    public Color getColor() {
        return Utils.Pion.NOIR.getCouleur();
    }

}
