/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetilebnyl;

/**
 *
 * @author bultelbe
 */
        
    
    


public class ProjetIleBNYL {
    private static Grille grillejeu = new Grille();

    /**
     * @param args the command line arguments
    */
    public static void main(String[] args) {
        // TODO code application logic here
        grillejeu.getGrille().get(1).setColonne(1);
        grillejeu.afficheGrille();
    }




}
        