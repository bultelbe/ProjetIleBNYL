/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pioches_Tresor;

/**
 *
 * @author gervasna
 */
public class Tresor {
    
    private String nom;
    private Boolean recupere;

    public Tresor(String nom) {
        this.nom = nom;
        this.recupere = false;
    }

    public void setRecupere(Boolean recupere) {
        this.recupere = recupere;
    }

    public Boolean getRecupere() {
        return recupere;
    }
    
    
    
    
    
    
}
