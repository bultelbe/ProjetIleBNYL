package projetilebnyl;

import java.awt.Color;
import java.awt.event.ActionEvent;
import static java.lang.Integer.parseInt;
import java.util.*;
import static projetilebnyl.Utils.EtatTuile.*;
import static java.lang.Integer.parseInt;

public class Controleur implements Observateur{
    public Grille grille;
    public ArrayList<Aventurier> joueurs = new ArrayList<>();
    public VueAventurier vueAventurier;

    private Tuile spawnMessager;
    private Tuile spawnPlongeur;
    private Tuile spawnIngenieur;
    private Tuile spawnNavigateur;
    private Tuile spawnPilote;
    private Tuile spawnExplorateur;
    private int act = 3;
    private Aventurier aventurierCourant;

    public Controleur() {
        
        grille = new Grille();
        spawnMessager = grille.getTuile(2, 3);
        spawnPlongeur = grille.getTuile(3, 2);
        spawnIngenieur = grille.getTuile(4, 1);
        spawnNavigateur = grille.getTuile(4, 2);
        spawnPilote = grille.getTuile(4, 3);
        spawnExplorateur = grille.getTuile(5, 3);
        
        joueurs.add(new Messager("Goddefroy", spawnMessager, "Messager"));
        joueurs.add(new Plongeur("Duck", spawnPlongeur, "Plongeur"));
        joueurs.add(new Ingenieur("Jean-Jack", spawnIngenieur, "Ingenieur"));
        joueurs.add(new Navigateur("Magelan", spawnNavigateur, "Navigateur"));
        joueurs.add(new Pilote("Jones", spawnPilote, "Pilote"));
        joueurs.add(new Explorateur("Colonb", spawnExplorateur, "Explorateur"));
        aventurierCourant = joueurs.get(0);
    }
    
    public void TourDeJeu() {

        if (act==0){
            System.out.println("Vous avez fini votre tour, Appuyez sur Terminer");
            vueAventurier.btnAller.setEnabled(false);
            vueAventurier.btnAssecher.setEnabled(false);
            vueAventurier.btnAutreAction.setEnabled(false);
            act=3;
        }
 
    }

    public void assechementCase() {
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = aventurierCourant.assechementsPossibles(grille);
        
        if (tuilesAssechables.isEmpty()) {
            System.out.println("\nIl n'y a aucunes tuiles à assécher autour de vous.");
        } else {
            Scanner sc = new Scanner(System.in);
            
            if(aventurierCourant.getNoma()=="Ingenieur"){
                
                System.out.println("Combien de tuiles voulez-vous assécher (2 maximum) ?");
                String nbrActions = sc.nextLine();
                int i = Integer.parseInt(nbrActions);
                int j=0;
                if(i==2 && tuilesAssechables.size()>=2){
                    while (j<=2){
                        
                        System.out.println("Vous assechez deux case");
                        
                        for (Tuile t : tuilesAssechables) {
                            System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
                        }
                        
                        System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
                        String tuileX = sc.nextLine();
                        int x = parseInt(tuileX);

                        System.out.print("\nY : ");
                        String tuileY = sc.nextLine();
                        int y = parseInt(tuileY);

                        Tuile t = grille.getTuile(x, y);

                        if (tuilesAssechables.contains(t)) {
                            t.setStatut(ASSECHEE);
                            System.out.println("Vous avez asséché la tuile : " + t.getNomCase() + "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
                            act=act-1;
                            j=j+1;
                        } else {
                            System.out.println("Cette tuile n'est pas asséchable.");
                        }
                    }
                }else{
                    System.out.println("Vous n'assechez qu'une case");
                    
                    for (Tuile t : tuilesAssechables) {
                            System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
                        }
                    
                    System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
                    String tuileX = sc.nextLine();
                    int x = parseInt(tuileX);

                    System.out.print("\nY : ");
                    String tuileY = sc.nextLine();
                    int y = parseInt(tuileY);

                    Tuile t = grille.getTuile(x, y);

                    if (tuilesAssechables.contains(t)) {
                        t.setStatut(ASSECHEE);
                        System.out.println("Vous avez asséché la tuile : " + t.getNomCase() + "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
                        act=act-1;
                    } else {
                        System.out.println("Cette tuile n'est pas asséchable."); 
                        }
                }
            }else{
                
                 for (Tuile t : tuilesAssechables) {
                            System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
                        }
                
                System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
                String tuileX = sc.nextLine();
                int x = parseInt(tuileX);

                System.out.print("\nY : ");
                String tuileY = sc.nextLine();
                int y = parseInt(tuileY);

                Tuile t = grille.getTuile(x, y);

                if (tuilesAssechables.contains(t)) {
                    t.setStatut(ASSECHEE);
                    System.out.println("Vous avez asséché la tuile : " + t.getNomCase() + "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
                    act=act-1;
                } else {
                    System.out.println("Cette tuile n'est pas asséchable.");

                }
            }
        }
        
        this.TourDeJeu();
    }


    public void passerJoueurSuivant() {
        
        act=3;
        VueAventurier avt = getVueAventurier();
        
        aventurierCourant = joueurs.get(((joueurs.indexOf(aventurierCourant))+1)%6);
        getVueAventurier().updateAventurier(aventurierCourant.getNomJ(), aventurierCourant.getNoma(), aventurierCourant.getColor());        
    }
    
    public VueAventurier getVueAventurier() {
        return this.vueAventurier;
    }
    
    public void setVueAvt (VueAventurier avt) {
        this.vueAventurier = avt;
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
            System.out.println("Vous vous êtes déplacés sur la tuile : " + t.getNomCase()+ "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
            act=act-1;
        } else {
            System.out.println("Vous ne pouvez pas vous déplacer sur cette Tuile.");
        }
        
        this.TourDeJeu();
    }
    
    public void traiterMessage(Message m) {
        switch(m) {
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
