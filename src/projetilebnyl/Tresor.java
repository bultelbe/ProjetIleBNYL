/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetilebnyl;

import Grille.Grille;
import Grille.Tuile;
import static Vues.Utils.Cartes.*;
import static Vues.Utils.EtatTuile.COULEE;
import java.awt.Color;

/**
 *
 * @author gervasna
 */
public class Tresor {
    
    private String nom;
    private Boolean recupere;
    private Tuile sanctuaire1;
    private Tuile sanctuaire2;
    private Color color;
    
    //Constructeur
    public Tresor(String nom,Color color) {
        this.nom = nom;
        this.recupere = false;
        this.color=color;
    }
    
    //Place les différentes statues sur la grille
    public void setSanctuaire1(Grille grille) {
        String nom = this.getNom();
        Tuile t1 = new Tuile("");
        if (nom== CRISTAL.toString()) {
            t1=grille.getTuile("La Caverne Des Ombres");
            
        } else if (nom== STATUE.toString())   {
            t1=grille.getTuile("Le Jardin des Hurlements");
            
        } else if (nom== PIERRE.toString()) {
            t1=grille.getTuile("Le Temple de la Lune");
            
        } else if (nom== CALICE.toString()) {
            t1=grille.getTuile("Le Palais de Corail");
        }
        this.setSanctuaire1(t1);
    }

    //Place les différentes statues sur la grille
    public void setSanctuaire2(Grille grille) {
        String nom=this.getNom();
        Tuile t1 = new Tuile("");
        if (nom== CRISTAL.toString()) {
            t1=grille.getTuile("La Caverne du Brasier");
        } else if (nom== STATUE.toString())   {
            t1=grille.getTuile("Le Jardin des Murmures");
        } else if (nom== PIERRE.toString()) {
            t1=grille.getTuile("Le Temple du Soleil");
        } else if (nom== CALICE.toString()) {
            t1=grille.getTuile("Le Palais des Marées");
        }
        this.setSanctuaire1(t1);
    }
    
    //Gère si le trésor est récupérable ou non
    public boolean recuperable(){
        Boolean acces = true;
        if (this.getSanctuaire1().getStatut()== COULEE && this.getSanctuaire2().getStatut()== COULEE && this.getRecupere()==false){ acces=false;}
        
        return acces;
    }
    
    //Getters et Setters
    public Color getColor() {
        return color;
    }
    
    public String getNom() {
        return nom;
    }

    public void setRecupere(Boolean recupere) {
        this.recupere = recupere;
    }

    public Boolean getRecupere() {
        return recupere;
    }

    public Tuile getSanctuaire1() {
        return sanctuaire1;
    }

    public void setSanctuaire1(Tuile sanctuaire1) {
        this.sanctuaire1 = sanctuaire1;
    }
    
    public Tuile getSanctuaire2() {
        return sanctuaire2;
    }

    public void setSanctuaire2(Tuile sanctuaire2) {
        this.sanctuaire2 = sanctuaire2;
    }
}
