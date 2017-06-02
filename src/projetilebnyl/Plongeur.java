package projetilebnyl;

import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public class Plongeur extends Aventurier {

    public Plongeur(int colonne, int ligne, Tuile positionCourante) {
        super(5, colonne, ligne, positionCourante);
    }
    
    @Override
    public void deplacementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj=(grille.getListeTuileAdj(positionCourante));
        
        ArrayList<Tuile> tuilesInondeesCoulees = new ArrayList<>();
        
        for (Tuile t1 : tuilesAdj) {
            if (t1.getStatut() == INONDEE || t1.getStatut() == COULEE) {
                tuilesInondeesCoulees.add(t1);
                
                for (Tuile t2 : grille.getListeTuileAdj(t1)) {
                    if (t2.getStatut() == INONDEE || t2.getStatut() == COULEE) {
                        tuilesInondeesCoulees.add(t2);
                        tuilesAdj.add(t2);
                    }
                }
            }
        }
        
    }
}
