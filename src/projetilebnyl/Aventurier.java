package projetilebnyl;

import java.awt.Color;
import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public abstract class Aventurier {
    private String nomJ;
    private int colonne;
    private int ligne;
    private String noma;
    
    private int nbrActions;
    public Pilote pilote;
    public Explorateur explorateur;
    public Ingenieur ingénieur;
    public Navigateur navigateur;
    public Messager messager;
    public Plongeur plongeur;
    public Tuile positionCourante;

    public Aventurier(String nomJ, Tuile positionCourante, String noma) {
        this.nomJ = nomJ;
        this.positionCourante = positionCourante;
        this.noma = noma;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }
    

    public void setLigne(int ligne) {
        this.ligne = ligne;
     }

    public ArrayList<Tuile> assechementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesInondees = new ArrayList<>();
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj = (grille.getListeTuileAdj(positionCourante));
        
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
            if (t.getStatut() == INONDEE || t.getStatut() == ASSECHEE) {
                tuilesPossibles.add(t);
            }
        }
        return tuilesPossibles;
    }

    public void DeplaceJoueur(int colonne, int ligne) {
        this.setColonne(colonne);
        this.setLigne(ligne);
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
    
    
}
