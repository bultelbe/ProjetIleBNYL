package projetilebnyl;

import java.awt.event.ActionEvent;
import static java.lang.Integer.parseInt;
import java.util.*;
import static projetilebnyl.Utils.EtatTuile.*;

public class Controlleur {
	public Grille grille;
	public ArrayList<Aventurier> joueurs = new ArrayList<>();
	public VueAventurier vueAventurier;
        
        //Il faut créer différents aventuriers
        private Aventurier aventurier;
        
        
	public void TourDeJeu() {
            throw new UnsupportedOperationException();
	}

	public void effectuerAction(ActionEvent clic_bouton) {
		throw new UnsupportedOperationException();
	}

	public void AssechementCase() {
            ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
            tuilesAssechables = aventurier.assechementsPossibles(grille);
            
            for (Tuile t : tuilesAssechables) {
                System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
            String tuileX = sc.nextLine();
            int x = parseInt(tuileX);
            
            System.out.print("\nY : ");
            String tuileY = sc.nextLine();
            int y = parseInt(tuileY);
            
            Tuile t = grille.getTuile(x, y);
            
            if (tuilesAssechables.contains(t)) {
                t.setStatut(ASSECHEE);
            } else {
                System.out.println("Cette tuile n'est pas asséchable.");
            }
            
	}

	
        public void passerJoueurSuivant() {
            throw new UnsupportedOperationException();
	}
        

	public void DeplacementJoueur() {
            ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
            tuilesPossibles = aventurier.deplacementsPossibles(grille);
            
            for (Tuile t : tuilesPossibles) {
                System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
            }
            
            Scanner sc = new Scanner(System.in);
            System.out.print("\nRentrez les coordonnées de la Tuile où vous voulez aller. \nX : ");
            String tuileX = sc.nextLine();
            int x = parseInt(tuileX);
            
            System.out.print("\nY : ");
            String tuileY = sc.nextLine();
            int y = parseInt(tuileY);
            
            Tuile t = grille.getTuile(x, y);
            
            if (tuilesPossibles.contains(t)) {
                aventurier.setPositionCourante(t);
            } else {
                System.out.println("Vous ne pouvez pas vous déplacer sur cette Tuile.");
            }
	}
}
