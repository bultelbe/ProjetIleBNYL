/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pioches;

import projetilebnyl.Utils;

/**
 *
 * @author thorey
 */
public class Carte {
    
    private String nomCarte;

    public Carte(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    public Carte(Utils.Cartes carte) {
        this.nomCarte=carte.toString();
    }

    public String getNomCarte() {
        return nomCarte;
    }
    
    
    
}
