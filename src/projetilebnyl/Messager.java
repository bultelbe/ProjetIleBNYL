package projetilebnyl;

import java.awt.Color;

public class Messager extends Aventurier {

    public Messager(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.BLANC.getCouleur();
    }
}
