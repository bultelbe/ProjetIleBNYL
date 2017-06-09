package projetilebnyl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import static projetilebnyl.Utils.EtatTuile.*;

public class Ingenieur extends Aventurier {

    public Ingenieur(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }
    
    
    public ArrayList<Tuile> assechementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj = grille.getListeTuileAdj(positionCourante);
        ArrayList<Tuile> tuilesInondees = new ArrayList<>();
        
        tuilesAdj.add(positionCourante);
        
        for(Tuile t : tuilesAdj) {
            if (t.getStatut() == INONDEE) {
                tuilesInondees.add(t);
            }
        }
        return tuilesInondees;
    }

    @Override
    public Color getColor() {
        return Utils.Pion.ROUGE.getCouleur();
    }
    
}
