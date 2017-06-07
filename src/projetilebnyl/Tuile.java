package projetilebnyl;

import projetilebnyl.Utils.EtatTuile;
import static projetilebnyl.Utils.EtatTuile.*;

public class Tuile {
	private String nomCase;
	private int colonne;
	private int ligne;
	private EtatTuile statut;
        
    Tuile(String nomCase){
        this.nomCase=nomCase;
    }
              
        
    public String getNomCase() {
		return nomCase;
	}

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public EtatTuile getStatut() {
         return this.statut;
    }

    public void setStatut(EtatTuile statut) {
            this.statut=statut;
    }

    public String getPosition() {
        return ("("+this.getColonne()+","+this.getLigne()+")");
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
        System.out.print(nom +" , Colone :"+x+" , Ligne : "+y+" , "+statut);
    }
}

