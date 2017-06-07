package projetilebnyl;

import java.util.ArrayList;
import java.util.Vector;

public class Controlleur {
	public Grille grille;
	public ArrayList<Aventurier> joueurs = new ArrayList<>();
	public VueAventurier vueAventurier;
        
        //Il faut créer différents aventuriers du coup
        private Aventurier aventurier;
        
        
        
	public void mouvPossible() {
		throw new UnsupportedOperationException();
        }

	public void TourDeJeu() {
		throw new UnsupportedOperationException();
	}

	/*public void effectuerAction(clic_bouton aEvt) {
		throw new UnsupportedOperationException();
	}*/

	public void AssechementCase() {
		ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
                tuilesAssechables = aventurier.assechementsPossibles(grille);
	}

	public void passerJoueurSuivant() {
		throw new UnsupportedOperationException();
	}

	public void DeplacementJoueur() {
		throw new UnsupportedOperationException();
	}
}
