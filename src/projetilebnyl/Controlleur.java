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
        
        
        
        
	public void TourDeJeu() {
            int act=3;
            String choixAct;
            int choix=0;
            Scanner sc= new Scanner(System.in);
            while( act >0){
                System.out.println("Il vous reste"+act+" action à réalisé");
                System.out.println("1-Déplacement");
                System.out.println("2-Asséchage");
                System.out.println("3-Fin du tour");
                System.out.println();
                System.out.print("Que vouler vous faire?(1/2/3)   ");
                choixAct=sc.nextLine();
                choix=Integer.parseInt(choixAct);
                if(choix==1){
                    int xAvMouv=this.getColonne();
                    this.DeplacementJoueur();
                    act=act-1;
                }else if(choix==2){
                    this.AssechementCase();
                    act=act-1;
                }else if(choix==3){
                    System.out.println("Fin du tour");
                    act=0;
                }else{
                    System.out.println("Les action a réalisé sont désigné pas 1,2 ou 3");
                }
            }
	}

	public void effectuerAction(ActionEvent clic_bouton) {
		throw new UnsupportedOperationException();
	}

	public void AssechementCase() {
            ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
            tuilesAssechables = assechementsPossibles(grille);
            
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
            tuilesPossibles = deplacementsPossibles(grille);            
            
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
