package projetilebnyl;

import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public class Aventurier {
    private String nomJ;
    private int capacite;
    private int colonne;
    private int ligne;
    public Pilote pilote;
    public Explorateur explorateur;
    public Ingénieur ingénieur;
    public Navigateur navigateur;
    public Messager messager;
    public Plongeur plongeur;
    public Tuile positionCourante;

    public Aventurier(String nomJ, int capacite, Tuile positionCourante) {
        this.nomJ = nomJ;
        this.capacite = capacite;
        this.positionCourante = positionCourante;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
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
    
    
    
}
