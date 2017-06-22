package Aventurier;

import Grille.Tuile;
import java.awt.Color;
import Vues.Utils;

//Hérite d'Aventurier
public class Messager extends Aventurier {

    //Constructeur
    public Messager(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    //Getter et setter
    @Override
    public Color getColor() {
        return Utils.Pion.BLANC.getCouleur();
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
