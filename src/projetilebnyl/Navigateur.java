package projetilebnyl;

import java.awt.Color;

public class Navigateur extends Aventurier {

    public Navigateur(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.JAUNE.getCouleur();
    }
}
