package projetilebnyl;

public class Tuile {
	private String nomCase;
	private int colonne;
	private int ligne;
	private int statut;
        
    Tuile(String nomCase,int colonne,int ligne){
        this.nomCase=nomCase;
        this.colonne=colonne;
        this.ligne=ligne;
        this.statut=1;
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
       


	public int getStatut() {
             return this.statut;
	}

	public void setStatut(int statut) {
		this.statut=statut;
	}

	public String getPosition() {
            return ("("+this.getColonne()+","+this.getLigne()+")");
        }
}
