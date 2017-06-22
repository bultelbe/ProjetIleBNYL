package Aventurier;

import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;
import Vues.Utils;
import static Vues.Utils.EtatTuile.*;

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

    @Override
    public boolean getActionPilote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActionPilote(boolean etat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
