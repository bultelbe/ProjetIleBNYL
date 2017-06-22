package Aventurier;

import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import java.awt.Color;
import java.util.ArrayList;
import Vues.Utils;
import static Vues.Utils.EtatTuile.*;

//Hérite d'Aventurier
public class Explorateur extends Aventurier {

    //Constructeur
    public Explorateur(String nomJ, Tuile positionCourante,String noma) {
        super(nomJ, positionCourante, noma);
    }
    
    @Override
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        ArrayList<Tuile> tuilesAdj = super.deplacementsPossibles(grille);
        ArrayList<Tuile> tuilesDiag = new ArrayList<>();
        tuilesDiag = grille.getListeTuileDiag(getPositionCourante());
        
        for (Tuile t : tuilesDiag) {
            if (t.getStatut() != COULEE)
                tuilesAdj.add(t);
        }
        return tuilesAdj;
    }
    
    
    @Override
    public ArrayList<Tuile> assechementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesAdj = super.assechementsPossibles(grille);
        ArrayList<Tuile> tuilesDiag = new ArrayList<>();
        tuilesDiag = grille.getListeTuileDiag(getPositionCourante());
        
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        
        for (Tuile t : tuilesDiag) {
            if (t.getStatut() == INONDEE) tuilesAssechables.add(t);
        }
        
        if (getPositionCourante().getStatut() == INONDEE && !tuilesAssechables.contains(getPositionCourante()))
        tuilesAssechables.add(getPositionCourante());
        
        for (Tuile t : tuilesAdj) {
            if (t.getStatut() == INONDEE && !tuilesAssechables.contains(t))
                tuilesAssechables.add(t);
        }
        return tuilesAssechables;
    }
    

    @Override
    public Color getColor() {
        return Utils.Pion.VERT.getCouleur();
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
