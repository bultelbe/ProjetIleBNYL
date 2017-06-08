package projetilebnyl;

import java.awt.event.ActionEvent;
import static java.lang.Integer.parseInt;
import java.util.*;
import static projetilebnyl.Utils.EtatTuile.*;

public class Controlleur {
    public Grille grille;
    public ArrayList<Aventurier> joueurs = new ArrayList<>();
    public VueAventurier vueAventurier;

    private Tuile spawnMessager = grille.getTuile(2, 3);
    private Tuile spawnPlongeur = grille.getTuile(3, 2);
    private Tuile spawnIngenieur = grille.getTuile(4, 1);
    private Tuile spawnNavigateur = grille.getTuile(4, 2);
    private Tuile spawnPilote = grille.getTuile(4, 3);
    private Tuile spawnExplorateur = grille.getTuile(5, 3);
    
    private Aventurier aventurierCourant;
    //Il faut créer différents aventuriers

    public Controlleur() {
        joueurs.add(new Messager("Goddefroy", spawnMessager));
        joueurs.add(new Plongeur("Duck", spawnPlongeur));
        joueurs.add(new Ingenieur("Jean-Jack", spawnIngenieur));
        joueurs.add(new Navigateur("Magelan", spawnNavigateur));
        joueurs.add(new Pilote("Jones", spawnPilote));
        joueurs.add(new Explorateur("Colonb", spawnExplorateur));
        
    }



    public void TourDeJeu() {
        int act=3;
        String choixAct;
        int choix=0;
        Scanner sc=new Scanner(System.in);
        while(act>0){
            System.out.println("Il vous reste"+act+" actions.");
            System.out.println("Que vouler vous faire");
            System.out.println("1-Assécher");
            System.out.println("2-Déplacer");
            System.out.println("3-Finir le tour");
            System.out.println("Entré 1,2 ou 3");
            System.out.println();
            choixAct=sc.nextLine();
            choix=Integer.parseInt(choixAct);
            if(choix==1){
                System.out.println("Déplacement");
                /*if(){ //If pour le cas ou déplacement impossible
                    act=act-1;
                }*/
                    
            }else if(choix==2){
                System.out.println("Asséchage");
                /*if(){if pour le cas ou asséssage impossible
                    act=act-1;
                }*/
            }else if(choix==3){
                System.out.println("Fin du tour");
                act=0;
            }else{
                
            }
        }
                
         
    }

    public void assechementCase() {
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = aventurierCourant.assechementsPossibles(grille);

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


    public void deplacementJoueur() {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        tuilesPossibles = aventurierCourant.deplacementsPossibles(grille);

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
            aventurierCourant.setPositionCourante(t);
        } else {
            System.out.println("Vous ne pouvez pas vous déplacer sur cette Tuile.");
        }
    }
    
    public void traiterMessage(Message m) {
        switch(m){
            case CLIC_BoutonAller:
                deplacementJoueur();
                break;
            case CLIC_BoutonAssecher:
                assechementCase();
                break;
            case CLIC_BoutonAutreAction:
                break;
            case CLIC_BoutonTerminer:
                passerJoueurSuivant();
                break;
        }
    }
}
