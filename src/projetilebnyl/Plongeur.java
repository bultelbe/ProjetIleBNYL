package projetilebnyl;

import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public class Plongeur extends Aventurier {

    public Plongeur(String nomJ, int capacite, Tuile positionCourante) {
        super(nomJ,capacite,positionCourante);
    }
    
    @Override
    public void deplacementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesIC = new ArrayList<>();
        tuilesIC=(grille.getListeTuileAdj(positionCourante));
        
        ArrayList<Tuile> tuilesTrav = new ArrayList<>();
        
        for (int i = 0; i < tuilesIC.size(); i++) {
            Tuile t1 = tuilesIC.get(i);
            
            if (t1.getStatut() != COULEE) {
                for (Tuile t2 : grille.getListeTuileAdj(t1))
                    if (t2.getStatut() == COULEE && tuilesTrav.contains(t2)) {
                        
                    } else if (t2.getStatut() != COULEE && !tuilesIC.contains(t2)) {
                        
                    }
            }
        }
        
        /*for (Tuile t1 : tuilesIC) {
            if (t1.getStatut() == INONDEE || t1.getStatut() == COULEE) {
                tuilesTrav.add(t1);
                
                for (Tuile t2 : grille.getListeTuileAdj(t1)) {
                    if (t2.getStatut() == INONDEE || t2.getStatut() == COULEE) {
                        tuilesTrav.add(t2);
                        tuilesIC.add(t2);
                    }
                }
            }
        }*/
        
    }
}
