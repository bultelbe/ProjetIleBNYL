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
        return super.assechementsPossibles(grille);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.ROUGE.getCouleur();
    }
    
}
