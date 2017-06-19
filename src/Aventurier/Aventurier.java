package Aventurier;

import Grille.Grille;
import Grille.Tuile;
import java.awt.Color;
import java.util.ArrayList;
import static Vues.Utils.EtatTuile.*;

public abstract class Aventurier {
    private String nomJ;
    private int colonne;
    private int ligne;
    private String noma;
    
    public Tuile positionCourante;

    public Aventurier(String nomJ, Tuile positionCourante, String noma) {
        this.nomJ = nomJ;
        this.positionCourante = positionCourante;
        this.noma = noma;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne - 1;
    }

    public int getColonne() {
        return colonne + 1;
    }

    public int getLigne() {
        return ligne + 1;
    }
    

    public void setLigne(int ligne) {
        this.ligne = ligne - 1;
     }

    public ArrayList<Tuile> assechementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesInondees = new ArrayList<>();
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj = (grille.getListeTuileAdj(positionCourante));
        tuilesAdj.add(positionCourante);
        
        for (Tuile t : tuilesAdj) {
            if (t.getStatut() == INONDEE) {
                tuilesInondees.add(t);
            }
        }
        return tuilesInondees;
    }

    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj=(grille.getListeTuileAdj(positionCourante));
        
        for (Tuile t : tuilesAdj) {
            if (t.getStatut() != COULEE) {
                tuilesPossibles.add(t);
            }
        }
        return tuilesPossibles;
    }

    public Tuile getPositionCourante() {
        return positionCourante;
    }

    public void setPositionCourante(Tuile positionCourante) {
        this.positionCourante = positionCourante;
    }
    
    public abstract Color getColor();

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public String getNomJ() {
        return nomJ;
    }

    public void setNomJ(String nomJ) {
        this.nomJ = nomJ;
    }

    
    
}
