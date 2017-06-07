package projetilebnyl;

import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public class Pilote extends Aventurier {
    
    private boolean action = true;

    public Pilote(String nomJ, int capacite, Tuile positionCourante) {
        super(nomJ,capacite,positionCourante);
    }

    
    public ArrayList<Tuile> getTuilesPossibles(Grille grille) {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        tuilesPossibles = grille.getTuilesPossibles();
        
        if (getAction()) {
            tuilesPossibles.remove(getPositionCourante());
        } else {
            tuilesPossibles = grille.getListeTuileAdj(positionCourante);
        }
        return tuilesPossibles;
    }
    
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        return grille.getTuilesPossibles();
    }

    public boolean getAction() {
        return action;
    }

    public void setAction(boolean etat) {
        this.action = etat;
    }
    
    
}
