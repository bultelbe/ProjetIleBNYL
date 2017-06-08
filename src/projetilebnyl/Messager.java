package projetilebnyl;

import java.awt.Color;

public class Messager extends Aventurier {

    public Messager(String nomJ, Tuile positionCourante) {
        super(nomJ, positionCourante);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.BLANC.getCouleur();
    }
}
