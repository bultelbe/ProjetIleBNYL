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
        ArrayList<Tuile> tuilesArret = new ArrayList<>();
        
        ArrayList<Tuile> tuilesACotes = new ArrayList<>();
        tuilesACotes = grille.getListeTuileAdjDiag(positionCourante);
        
        ArrayList<Tuile> tuilesInondeesCoulees = new ArrayList<>();
        
        ArrayList<Tuile> tuilesaCotesInondeesCoulees = new ArrayList<>();
        
        for (Tuile t1 : tuilesACotes) {
            if (t1.getStatut() == INONDEE || t1.getStatut() == ASSECHEE) tuilesArret.add(t1);
            if (t1.getStatut() == INONDEE || t1.getStatut() == COULEE) tuilesInondeesCoulees.add(t1);
        }
        
        for (Tuile t2 : tuilesInondeesCoulees) {
            tuilesaCotesInondeesCoulees = grille.getListeTuileAdjDiag(t2);

            for (Tuile t3 : tuilesaCotesInondeesCoulees) {
                if (t3.getStatut() == INONDEE || t3.getStatut() == COULEE) tuilesInondeesCoulees.add(t3);
                if (t3.getStatut() == INONDEE || t3.getStatut() == ASSECHEE) tuilesArret.add(t3);
            }
        }
        
        return tuilesArret;
        
    }

    @Override
    public Color getColor() {
        return Utils.Pion.NOIR.getCouleur();
    }
}
