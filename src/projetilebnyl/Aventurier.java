package projetilebnyl;

import java.util.ArrayList;

public class Aventurier {
    private String nomJ;
    private int capacite;
    private int colonne;
    private int ligne;
    private int nbrActions;
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

     public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
     }

    public Tuile getTuile() {
            return positionCourante;
    }

    public void positionGrille(Grille grille) {

    }

    public void deplacementsPossibles(Grille grille) {
        
        /*
        if (joueur.getCapacite() == 1) { //pilote
            System.out.println("Vous pouvez vous déplacer sur n'importe quelle case sèche de l'île pour une action.");
        } else if (joueur.getCapacite() == 2) { //plongeur
            System.out.println("Vous pouvez vous déplacer au travers d’une ou plusieurs tuiles adjacentes manquantes et/ou inondées pour une action (pas forcément en ligne droite)");
        }
        
        
        ArrayList<Tuile> tuilesSeches = new ArrayList<>();
        
        if (joueur.getCapacite() == 1) { //pilote - Déplacement possible sur toutes les tuiles non coulées
            for(int i = 1; i <= grille.getGrille().size(); i++) {
                if (grille.getGrille().get(i).getStatut() == 1) { //case sèche
                    tuilesSeches.add(grille.getGrille().get(i));
                }
            }
        } else if (joueur.getCapacite() == 2) { //plongeur - Déplacement possible en 1 action à travers toutes

        } else {

        }*/
    }

    public void DeplaceJoueur(int colonne, int ligne) {
            this.setColonne(colonne);
            this.setLigne(ligne);
    }
    
}
