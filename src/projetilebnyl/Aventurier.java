package projetilebnyl;

public class Aventurier {
	private String nom;
	private int capacité;
	private int colonne;
	private int ligne;
	public Pilote pilote;
	public Explorateur explorateur;
	public Ingénieur ingénieur;
	public Navigateur navigateur;
	public Messager messager;
	public Plongeur plongeur;
	public Tuile positionCourante;
        
        
        
	public void getCapacité() {
		throw new UnsupportedOperationException();
	}

	public Tuile getTuile() {
		return this._positionCourante;
	}

	public void positionGrille(Grille grille) {
		throw new UnsupportedOperationException();
	}
        
	public void DeplaceJoueur(int Colonne, int ligne) {
		this.setColonne(Colonne);
                this.setLigne(ligne);
	}

	public void DeplacementsPossibles(Grille grille) {
		throw new UnsupportedOperationException();
	}
}
