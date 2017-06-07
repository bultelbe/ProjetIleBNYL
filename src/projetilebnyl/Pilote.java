package projetilebnyl;

import java.util.ArrayList;

public class Pilote extends Aventurier {

    public Pilote(String nomJ, int capacite, Tuile positionCourante) {
        super(nomJ,capacite,positionCourante);
    }
    
    @Override
    public void deplacementsPossibles(Grille grille) {

        ArrayList<Tuile> tuilesSeches = new ArrayList<>();
        
        for(int i = 1; i <= grille.getGrille().size(); i++) {
            if (grille.getGrille().get(i).getStatut() == 1) { //case sèche
                tuilesSeches.add(grille.getGrille().get(i));
            }
        }
    }
}
