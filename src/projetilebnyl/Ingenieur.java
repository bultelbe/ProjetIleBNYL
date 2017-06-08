package projetilebnyl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Ingenieur extends Aventurier {

    public Ingenieur(String nomJ, Tuile positionCourante) {
        super(nomJ, positionCourante);
    }
    
    
    public ArrayList<Tuile> assechementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj = grille.getListeTuileAdj(positionCourante);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Combien de tuiles voulez-vous assécher (2 maximum) ?");
        String nbrActions = sc.nextLine();
        int i = Integer.parseInt(nbrActions);
        
        if (i > 2) {
            i = 2;
        } else {
            for(int j = 0; j < i; j++) {
            }   
        }
        return tuilesAdj;
    }

    @Override
    public Color getColor() {
        return Utils.Pion.ROUGE.getCouleur();
    }
    
}
