public class Tuile {
	private String _nomCase;
	private int _colonne;
	private int _ligne;
	private int _statut;

   	public String getNomCase() {
		return this._nomCase;
	}

    public int getColonne() {
        return _colonne;
    }

    public void setColonne(int _colonne) {
        this._colonne = _colonne;
    }

    public int getLigne() {
        return _ligne;
    }

    public void setLigne(int _ligne) {
        this._ligne = _ligne;
    }
        

	public int getStatut(String aNomCase) {
		return this._statut;
	}

	public void setStatut(int aStatut) {
		this._statut=aStatut;
	}

	public String getPosition() {
            return ("("+this.getColonne()+","+this.getLigne()+")");
        }
}