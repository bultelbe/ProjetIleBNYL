package projetilebnyl;

import projetilebnyl.Utils.EtatTuile;

public class Tuile {
	private String nomCase;
	private int colonne;
	private int ligne;
	private EtatTuile statut;
        
    Tuile(String nomCase){
        this.nomCase=nomCase;

        this.statut=EtatTuile.ASSECHEE;
    }
        
        
    public String getNomCase() {
		return this.nomCase;
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
}
