package projetilebnyl;

import java.util.ArrayList;

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

    Aventurier joueur = new Aventurier(nomJ, capacite, positionCourante);

    public Aventurier(String nomJ, int capacite, Tuile positionCourante) {
        this.nomJ = nomJ;
        this.capacite = capacite;
        this.positionCourante = positionCourante;
    }

    public int getCapacite() {
            return capacite;
    }

    public Aventurier(int capacite, int colonne, int ligne, Tuile positionCourante) {
        this.capacite = capacite;
        this.colonne = colonne;
        this.ligne = ligne;
        this.positionCourante = positionCourante;
    }




     public void setColonne(int _colonne) {
        this.colonne = _colonne;
    }

    public void setLigne(int _ligne) {
        this.ligne = _ligne;
     }

    public int getCapacité() {
            return this.capacite;
    }

    public Tuile getTuile() {
            return positionCourante;
            return this._positionCourante;
    }

    public void positionGrille(Grille aGrille) {

    }

    public void deplacementsPossibles(Grille aGrille) {

        if (joueur.getCapacite() == 1) { //pilote - Déplacement possible sur toutes les tuiles non coulées
            for(int i = 1; i <= 36; i++) {
                if (getStatut(i) == 1 || getStatut(i) == 2) {

                }
            }
        } else if (joueur.getCapacite() == 2) { //plongeur - Déplacement possible en 1 action à travers toutes

        } else {

        }
    }

    public void DeplaceJoueur(int Colonne, int ligne) {
            this.setColonne(Colonne);
            this.setLigne(ligne);
    }

    public void deplaceJoueur() {

    }
}

