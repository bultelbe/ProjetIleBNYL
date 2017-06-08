package projetilebnyl;

import java.util.ArrayList;
import java.util.Scanner;

public class Ingénieur extends Aventurier {

    public Ingénieur(String nomJ, Tuile positionCourante) {
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
    
}
