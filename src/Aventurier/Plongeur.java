package Aventurier;

import Grille.Grille;
import Grille.Tuile;
import java.awt.Color;
import java.util.ArrayList;
import Vues.Utils;
import static Vues.Utils.EtatTuile.*;

//Hérite d'Aventurier
public class Plongeur extends Aventurier {

    //Constructeur
    public Plongeur(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }
    
    //Retourne une ArrayList des tuiles non coulées où le plongeur peut aller grâce à sa capacité
    @Override
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        
        Tuile tuileL;
        ArrayList<Tuile> tuilesPossibles = super.deplacementsPossibles(grille);
        
        ArrayList<Tuile> tuilesTrav = new ArrayList();
        tuilesTrav.add(getPositionCourante());
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            tuileL = tuilesTrav.get(i);
            
            for (Tuile tuile : grille.getListeTuileAdj(tuileL)) {
                
                if (tuile.getStatut() != COULEE && !tuilesPossibles.contains(tuile))
                    tuilesPossibles.add(tuile);
                
                if (tuile.getStatut() != ASSECHEE && !tuilesTrav.contains(tuile))
                    tuilesTrav.add(tuile);
            }
        }
        
        tuilesPossibles.remove(getPositionCourante());
        return tuilesPossibles;
    }

    //Getter et setter
    @Override
    public Color getColor() {
        return Utils.Pion.NOIR.getCouleur();
    }

    @Override
    public boolean getActionPilote() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setActionPilote(boolean etat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
