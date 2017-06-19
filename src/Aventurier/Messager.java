package Aventurier;

import Aventurier.Aventurier;
import Grille.Tuile;
import java.awt.Color;
import Vues.Utils;

public class Messager extends Aventurier {

    public Messager(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    @Override
    public Color getColor() {
        return Utils.Pion.BLANC.getCouleur();
    }
}
