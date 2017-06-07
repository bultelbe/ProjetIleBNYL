package projetilebnyl;

import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public class Plongeur extends Aventurier {

    public Plongeur(String nomJ, int capacite, Tuile positionCourante) {
        super(nomJ,capacite,positionCourante);
    }

    
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesTrav = new ArrayList<>();
        tuilesTrav.add(positionCourante);
        
        ArrayList<Tuile> tuilesInondeesCoulees = new ArrayList<>();
        tuilesInondeesCoulees = grille.getTuilesPossibles();
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            Tuile t1 = tuilesTrav.get(i);
            
            if (t1.getStatut() != COULEE) {
                tuilesInondeesCoulees.add(t1);
                
                for (Tuile t2 : grille.getListeTuileAdj(t1))
                    if (t2.getStatut() == COULEE && tuilesInondeesCoulees.contains(t2)) {
                        tuilesInondeesCoulees.add(t2);
                        
                    } else if (t2.getStatut() != COULEE && !tuilesTrav.contains(t2)) {
                        tuilesTrav.add(t2);
                    }
            }
        }
        return tuilesTrav;
    }
}
