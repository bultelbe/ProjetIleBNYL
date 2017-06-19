package Grille;

import Vues.Utils.EtatTuile;
import static Vues.Utils.EtatTuile.*;

public class Tuile {
	private String nomCase;
	private int colonne;
	private int ligne;
	private EtatTuile statut;
        
    Tuile(String nomCase) {
        this.nomCase = nomCase;

        this.statut = EtatTuile.ASSECHEE;
    }
    
    Tuile(String nomCase, EtatTuile statut){
        this.nomCase=nomCase;
        this.statut=statut;
    }

    public Tuile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
              
        
    public String getNomCase() {
        return nomCase;
	}

    public int getColonne() {
        return colonne + 1;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne - 1;
    }

    public int getLigne() {
        return ligne + 1;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne - 1;
    }

    public EtatTuile getStatut() {
        return this.statut;
    }


    public void setStatut(EtatTuile statut) {
	this.statut=statut;
    }

    public void afficheTuile() {
        int x = this.getColonne();
        int y = this.getLigne();
        String nom = this.getNomCase();
        EtatTuile stat = this.getStatut();
        String statut = "";
        
        if (stat == ASSECHEE) {
            statut="Séche";
        } else if (stat == INONDEE) {
            statut="Innondée";
        } else if (stat == COULEE) {
            statut="Coulée";
        }
        System.out.println("Nom de la tuile : " + nom + "\nAux coordonnées : \nX : " + x + "\nY : " + y + "\nStatut : "+ statut + "\n");
    }
}

