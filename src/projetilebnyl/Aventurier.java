package projetilebnyl;

public class Aventurier {
	private int _capacité;
	private int _colonne;
	private int _ligne;
	private Tuile _positionCourante;

        public Aventurier(int _capacité, int _colonne, int _ligne, Tuile _positionCourante) {
            this._capacité = _capacité;
            this._colonne = _colonne;
            this._ligne = _ligne;
            this._positionCourante = _positionCourante;
        }


        
        
         public void setColonne(int _colonne) {
            this._colonne = _colonne;
        }

        public void setLigne(int _ligne) {
            this._ligne = _ligne;
         }
        
	public int getCapacité() {
		return this._capacité;
	}

	public Tuile getTuile() {
		return this._positionCourante;
	}

	public Tuile positionGrille(Grille aGrille) {
		throw new UnsupportedOperationException();
	}
        
	public void DeplaceJoueur(int Colonne, int ligne) {
		this.setColonne(Colonne);
                this.setLigne(ligne);
	}

	public void DeplacementsPossibles(Grille aGrille) {
		throw new UnsupportedOperationException();
	}
}