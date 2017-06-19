package Aventurier;

import Aventurier.Aventurier;
import Grille.Tuile;
import java.awt.Color;
import Vues.Utils;

public class Navigateur extends Aventurier {

    public Navigateur(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.JAUNE.getCouleur();
    }
}
