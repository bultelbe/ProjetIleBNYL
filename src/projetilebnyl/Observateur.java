/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetilebnyl;

import Aventurier.Aventurier;
import Grille.Grille;
import java.util.ArrayList;

/**
 *
 * @author laurillau
 */
public interface Observateur {
    public void traiterMessage(Message m);
    public Aventurier getAventurierCourant();
    public ArrayList<Aventurier> getJoueurs();
    public Grille getGrille();
}
