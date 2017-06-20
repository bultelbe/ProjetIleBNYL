package projetilebnyl;


import Pioches_Tresor.Carte;
import Pioches_Tresor.CarteInondations;
import Pioches_Tresor.CarteTresors;
import Aventurier.*;

import Aventurier.Plongeur;
import Aventurier.Pilote;
import Aventurier.Navigateur;
import Aventurier.Messager;
import Aventurier.Ingenieur;
import Aventurier.Explorateur;
import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import Pioches_Tresor.Tresor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import static java.lang.Integer.parseInt;
import java.util.*;
import static Vues.Utils.EtatTuile.*;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static Vues.Utils.Cartes.*;
import Vues.VueAventurier;

public class Controleur implements Observateur{
    public Grille grille;
    public ArrayList<Aventurier> joueurs = new ArrayList<>();
    public VueAventurier vueAventurier;

    private final Tuile spawnMessager;
    private final Tuile spawnPlongeur;
    private final Tuile spawnIngenieur;
    private final Tuile spawnNavigateur;
    private final Tuile spawnPilote;
    private final Tuile spawnExplorateur;
    private int act = 3;
    private int niveauEau =0;
    private Aventurier aventurierCourant;
    private CarteTresors tresor= new CarteTresors();
    private CarteInondations inondations= new CarteInondations();
    private Tresor cristal = new Tresor(CRISTAL.toString());
    private Tresor statute = new Tresor(STATUE.toString());
    private Tresor pierre = new Tresor(PIERRE.toString());
    private Tresor calice = new Tresor(CALICE.toString());

    public Controleur() {
        
        grille = new Grille();
        
        
        spawnMessager = grille.getTuile("La Porte d'Or");
        spawnPlongeur = grille.getTuile("La Porte de Fer");
        spawnIngenieur = grille.getTuile("La Porte de Bronze");
        spawnNavigateur = grille.getTuile("La Porte d'Argent");
        spawnPilote = grille.getTuile("Héliport");
        spawnExplorateur = grille.getTuile("La Porte de Cuivre");
        
        joueurs.add(new Messager("Goddefroy", spawnMessager, "Messager"));
        joueurs.add(new Plongeur("Duck", spawnPlongeur, "Plongeur"));
        joueurs.add(new Ingenieur("Jean-Jack", spawnIngenieur, "Ingenieur"));
        joueurs.add(new Navigateur("Magelan", spawnNavigateur, "Navigateur"));
        joueurs.add(new Pilote("Jones", spawnPilote, "Pilote"));
        joueurs.add(new Explorateur("Colonb", spawnExplorateur, "Explorateur"));
        aventurierCourant = joueurs.get(0);
    }
    
    public void TourDeJeu() {

        if (getAct() == 0) {
            System.out.println("Vous avez fini votre tour, Appuyez sur Terminer");
            getVueAventurier().getBtnAller().setEnabled(false);
            getVueAventurier().getBtnAssecher().setEnabled(false);
            getVueAventurier().getBtnAutreAction().setEnabled(false);
            act = 3;
        }
    }

    public void assechementCase() {
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = aventurierCourant.assechementsPossibles(grille);
        
        if (tuilesAssechables.isEmpty()) {
            System.out.println("\nIl n'y a aucunes tuiles à assécher autour de vous.");
        } else {
            Scanner sc = new Scanner(System.in);
            
            if (aventurierCourant.getNoma() == "Ingenieur") {
                
                System.out.println("Combien de tuiles voulez-vous assécher (2 maximum) ?");
                String nbrActions = sc.nextLine();
                int i = Integer.parseInt(nbrActions);
                int j=0;
                if(i==2 && tuilesAssechables.size()>=2){
                    while (j<=2){
                        
                        System.out.println("Vous asséchez deux case.");
                        
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
                    System.out.println("Vous ne pouvez asséchez qu'une case.");
                    
                    for (Tuile t : tuilesAssechables) {
                            System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
                        }
                    
                    System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
                    String tuileX = sc.nextLine();
                    int x = parseInt(tuileX);

                    System.out.print("\nY : ");
                    String tuileY = sc.nextLine();
                    int y = parseInt(tuileY);

                    Tuile t = getGrille().getTuile(x, y);

                    if (tuilesAssechables.contains(t)) {
                        t.setStatut(ASSECHEE);

                        System.out.println("Vous avez asséché la tuile : " + t.getNomCase() + "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
                        act = act-1;
                    } else {
                        System.out.println("Cette tuile n'est pas asséchable."); 
                    }
                }
            } else {
                
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
        getVueAventurier().updateCellules(grille);
        
        this.TourDeJeu();
    }

    public void passerJoueurSuivant() {
        
        act=3;
        VueAventurier avt = getVueAventurier();
        
        aventurierCourant = joueurs.get(((joueurs.indexOf(aventurierCourant))+1)%6);
        getVueAventurier().updateAventurier(aventurierCourant.getNomJ(), aventurierCourant.getNoma(), aventurierCourant.getColor(), aventurierCourant.getPositionCourante().getNomCase());        
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
        getVueAventurier().updateAventurier(aventurierCourant.getNomJ(), aventurierCourant.getNoma(), aventurierCourant.getColor(), aventurierCourant.getPositionCourante().getNomCase());
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

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public Aventurier getAventurierCourant() {
        return aventurierCourant;
    }

    public Grille getGrille() {
        return grille;
    }

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }
    public int getNiveauEau() {
        return niveauEau;
    }

    public void setNiveauEau(int niveauEau) {
        this.niveauEau = niveauEau;
    }
    
    public void piocherTresor(){
        Boolean eauxPioche = false;
        Carte eaux = new Carte(EAUX);
        Carte pioche1 =tresor.piocheTresor();
        if (pioche1.getNomCarte()== eaux.getNomCarte()) {
            tresor.defausseTresor(pioche1);
            eauxPioche=true;
            setNiveauEau((getNiveauEau()+1));
        }else{
        aventurierCourant.addCarte(pioche1);
        }
        if(getNiveauEau()<=9){
            Carte pioche2 =tresor.piocheTresor();
            if (pioche2.getNomCarte()== eaux.getNomCarte()) {
                tresor.defausseTresor(pioche2);
               setNiveauEau((getNiveauEau()+1));

            }else{
            aventurierCourant.addCarte(pioche2);
            }

            if (eauxPioche){
                inondations.remiseDefausse();
            }
        }
    }
    
    public void piocherInnodation(){
        inondations.piocheInondation(getNiveauEau(),getGrille());       
    }
    
    public void initGrille(Grille grille,CarteInondations inondations){
    for (int i = 0; i < 5; i++){
            inondations.getDefausseInondation().add(inondations.getPiocheInondation().get(0));
            Tuile t1=grille.getTuile(inondations.getPiocheInondation().get(0).getNomCarte());
            t1.setStatut(INONDEE);

            
            inondations.getPiocheInondation().remove(inondations.getPiocheInondation().get(0));
        }
    }
}
