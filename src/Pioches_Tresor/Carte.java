/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pioches_Tresor;

import Vues.Utils;

/**
 *
 * @author thorey
 */
public  class Carte {
    
    private String nomCarte;

    //Constructeurs
    public Carte(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    public Carte(Utils.Cartes carte) {
        this.nomCarte=carte.toString();
    }

    //Getter et setter de nomCarte
    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }
}
