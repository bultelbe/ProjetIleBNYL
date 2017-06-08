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
        
        if (tuilesInondees.isEmpty()) {
            System.out.println("Il n'y a aucunes tuiles à assécher autour de vous.");
        } else {

            Scanner sc = new Scanner(System.in);
            System.out.println("Combien de tuiles voulez-vous assécher (2 maximum) ?");
            String nbrActions = sc.nextLine();
            int i = Integer.parseInt(nbrActions);

            if (i >= 2) {
                i = 2;
                for (int j = 0; j < i; j++) {
                    
                }
            }
        }
        return tuilesInondees;
    }

    @Override
    public Color getColor() {
        return Utils.Pion.ROUGE.getCouleur();
    }
    
}
