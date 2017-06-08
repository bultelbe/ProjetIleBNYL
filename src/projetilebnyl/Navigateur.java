package projetilebnyl;

import java.awt.Color;

public class Navigateur extends Aventurier {

    public Navigateur(String nomJ, Tuile positionCourante) {
        super(nomJ, positionCourante);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.JAUNE.getCouleur();
    }
}
