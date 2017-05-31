package projetilebnyl;

public class Tuile {
	private String nomCase;
	private int colonne;
	private int ligne;
	private int statut;

   	public String getNomCase() {
		return this.nomCase;
	}

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int _colonne) {
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int _ligne) {
        this.ligne = ligne;
    }
        

	public int getStatut(String aNomCase) {
		return this.statut;
	}

	public void setStatut(int statut) {
		this.statut=statut;
	}

	public String getPosition() {
            return ("("+this.getColonne()+","+this.getLigne()+")");
        }
}