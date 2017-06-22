package Aventurier;

import Aventurier.Aventurier;
import Grille.Tuile;
import java.awt.Color;
import Vues.Utils;

//Hérite d'Aventurier
public class Navigateur extends Aventurier {

    //Constructeur
    public Navigateur(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.JAUNE.getCouleur();
    }

//    @Override
//    public boolean getActionPilote() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setActionPilote(boolean etat) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
