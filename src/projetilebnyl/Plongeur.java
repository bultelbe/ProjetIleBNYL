package projetilebnyl;

import java.awt.Color;
import java.util.ArrayList;
import static projetilebnyl.Utils.EtatTuile.*;

public class Plongeur extends Aventurier {

    public Plongeur(String nomJ, Tuile positionCourante, String noma) {
        super(nomJ, positionCourante, noma);
    }

    
    public ArrayList<Tuile> deplacementsPossibles(Grille grille) {
        
        ArrayList<Tuile> tuilesArret=new ArrayList<>();
        
        ArrayList<Tuile> tuilesTrav=new ArrayList<>();
        ArrayList<Tuile> tuilesTrav2=new ArrayList<>();
        
        ArrayList<Tuile> tuilesAdjDiag=new ArrayList<>();
        
        if(positionCourante.getStatut()==INONDEE){
            
            tuilesAdjDiag=grille.getListeTuileAdjDiag(positionCourante);
            System.out.println(positionCourante.getNomCase());
            
        }else if(positionCourante.getStatut()==ASSECHEE){
            
            tuilesAdjDiag=grille.getListeTuileAdj(positionCourante);
            System.out.println(positionCourante.getNomCase());
            
        }
        
        tuilesTrav=tuilesTrav2;
        
        while(compareTo(tuilesTrav,tuilesTrav2)){
            
        }
        
        
        
        
        
         
        
        
        return tuilesArret;
        /*
        ArrayList<Tuile> tuilesTrav = new ArrayList<>();
        tuilesTrav.add(positionCourante);
        
        ArrayList<Tuile> tuilesInondeesCoulees = new ArrayList<>();
        tuilesInondeesCoulees = grille.getTuilesPossibles();
        
        for (int i = 0; i < tuilesTrav.size(); i++) {
            Tuile t1 = tuilesTrav.get(i);
            
            if (t1.getStatut() != COULEE) {
                tuilesInondeesCoulees.add(t1);
                
                for (Tuile t2 : grille.getListeTuileAdj(t1))
                    if (t2.getStatut() == COULEE && tuilesInondeesCoulees.contains(t2)) {
                        tuilesInondeesCoulees.add(t2);
                        
                    } else if (t2.getStatut() != COULEE && !tuilesTrav.contains(t2)) {
                        tuilesTrav.add(t2);
                    }
            }
        }
        return tuilesTrav;*/
    }

    @Override
    public Color getColor() {
        return Utils.Pion.NOIR.getCouleur();
    }

    private boolean compareTo(ArrayList<Tuile> tuilesTrav, ArrayList<Tuile> tuilesTrav2) {
        retun tuilesTrav.size==tuilesTrav2.size();
    }
}
