package Aventurier;

import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import java.awt.Color;
import java.util.ArrayList;
import Vues.Utils;
import static Vues.Utils.EtatTuile.*;

//Hérite d'Aventurier
public class Pilote extends Aventurier {
    
    private boolean action = true;

    //Constructeur
    public Pilote(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    
    //Retourne une arrayList de tuiles correspondant à toutes les tuiles de la grille non coulées où le pilote peut aller
    @Override
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        
        if (getActionPilote() == true) {
            tuilesPossibles = grille.getTuilesPossibles();
            tuilesPossibles.remove(getPositionCourante());
        } else {
            tuilesPossibles.remove(getPositionCourante());
            tuilesPossibles = grille.getListeTuileAdj(getPositionCourante());
            
        }
        return tuilesPossibles;
    }
    

    @Override
    public boolean getActionPilote() {
        return action;
    }

    public void setActionPilote(boolean etat) {
        this.action = etat;
    }

    @Override
    public Color getColor() {
        return Utils.Pion.BLEU.getCouleur();
    }

}
