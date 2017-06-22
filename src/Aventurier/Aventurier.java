package Aventurier;

import Grille.Grille;
import Grille.Tuile;
import Pioches_Tresor.Carte;
import java.awt.Color;
import java.util.ArrayList;
import static Vues.Utils.EtatTuile.*;
import projetilebnyl.PionJoueur;


public abstract class Aventurier {
    private String nomJ;
    private int colonne;
    private int ligne;
    private String noma;
    private ArrayList<Carte> carteMain;
    private PionJoueur pionjoueur;
    private Tuile positionCourante;
    private boolean actionPilote;

    // Constructeur d'Aventurier
    public Aventurier(String nomJ, Tuile positionCourante, String noma) {
        this.nomJ = nomJ;
        this.positionCourante = positionCourante;
        this.noma = noma;
        this.carteMain = new ArrayList<>();
        pionjoueur = new PionJoueur(this.getColor());
    }

    //Retourne une arrayList des tuiles Inondées positionnées sur les tuiles adjacentes à l'aventurier
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
    
    //Retourne une ArrayList des tuiles non coulées positionnées sur les tuiles adjacentes à l'aventurier
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        tuilesAdj = grille.getListeTuileAdj(positionCourante);
        
        for (Tuile t : tuilesAdj) {
            if (t.getStatut() == ASSECHEE ||t.getStatut() == INONDEE ) {
                tuilesPossibles.add(t);
            }
        }
        return tuilesPossibles;
    }
    
    //Ajoute une carte à la main
    public void addCarte(Carte carte){
        this.getCarteMain().add(carte);
    }
    
    //Getter et setter
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

    public ArrayList<Carte> getCarteMain() {
        return carteMain;
    }

    public void setCarteMain(ArrayList<Carte> carteMain) {
        this.carteMain = carteMain;
    }
    
    public PionJoueur getPionjoueur() {
        return pionjoueur;
    }

    public void setPionjoueur(PionJoueur pionjoueur) {
        this.pionjoueur = pionjoueur;
    }
    
    public abstract boolean getActionPilote();
    
    public abstract void setActionPilote(boolean etat);
    
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
}
