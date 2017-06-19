/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pioches;

import Vues.Utils;

/**
 *
 * @author thorey
 */
public class Carte {
    
    private String nomCarte;

    public Carte(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    Carte(Utils.Cartes cartes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNomCarte() {
        return nomCarte;
    }
    
    
    
}
