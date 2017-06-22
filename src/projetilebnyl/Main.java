/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetilebnyl;

import Pioches_Tresor.Carte;
import Vues.*;

/**
 *
 * @author schmuckl
 */
public class Main {

    
    public static void main(String [] args) {
        // Instanciation de la fenêtre 
        Controleur controleur = new Controleur();
        //VueAventurier vueAvt = new VueAventurier(controleur.joueurs.get(0).getNomJ(), controleur.joueurs.get(0).getNoma(), controleur.joueurs.get(0).getColor(), controleur);
        //controleur.setVueAvt(vueAvt);
        VueInscription vueInscrip = new VueInscription(controleur);
        //System.out.println(vueAvt.getCartesLabels().get(0).getText());         
    }
    
}
