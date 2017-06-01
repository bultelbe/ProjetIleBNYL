package projetilebnyl;

public class Aventurier {
	private int capacité;
	private int colonne;
	private int ligne;
	private Tuile positionCourante;

        public Aventurier(int _capacité, int _colonne, int _ligne, Tuile _positionCourante) {
            this.capacité = _capacité;
            this.colonne = _colonne;
            this.ligne = _ligne;
            this.positionCourante = _positionCourante;
        }
      
        public void setColonne(int _colonne) {
            this.colonne = _colonne;
        }

        public void setLigne(int _ligne) {
            this.ligne = _ligne;
         }
        
	public int getCapacité() {
		return this.capacité;
	}

	public Tuile getTuile() {
		return this.positionCourante;
	}

	public Tuile positionGrille(Grille aGrille) {
		throw new UnsupportedOperationException();
	}
        
	public void DeplaceJoueur(int Colonne, int ligne) {
		this.setColonne(Colonne);
                this.setLigne(ligne);
	}

	public void DeplacementsPossibles(Grille aGrille) {
            int cap = this.getCapacité();
            if(cap==4){//plongeur
                
            }else if(cap==5){//pilote
                
            }else{
                
            }
            
        }
}
