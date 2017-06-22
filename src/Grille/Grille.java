package Grille;

import java.util.ArrayList;
import java.util.Collections;
import Grille.Tuile;
import java.util.Vector;
import static Vues.Utils.EtatTuile.*;


//Déclaration de toutes les tuiles de la grille
public class Grille {
	public ArrayList<Tuile> tuiles = new ArrayList<>();
        private Tuile t1=new Tuile("Le Pont des Abimes");
        private Tuile t2=new Tuile("La Porte de Bronze");
        private Tuile t3=new Tuile("La Caverne Des Ombres");
        private Tuile t4=new Tuile("La Porte de Fer");
        private Tuile t5=new Tuile("La Porte d'Or");
        private Tuile t6=new Tuile("Les Falaises de l'Oubli");
        private Tuile t7=new Tuile("Le Palais de Corail");
        private Tuile t8=new Tuile("La Porte d'Argent");
        private Tuile t9=new Tuile("Les Dunes de L'Illusion");
        private Tuile t10=new Tuile("Héliport");
        private Tuile t11=new Tuile("La Porte de Cuivre");
        private Tuile t12=new Tuile("Le Jardin des Hurlements");
        private Tuile t13=new Tuile("La Foret Pourpre");
        private Tuile t14=new Tuile("Le Lagon Perdu");
        private Tuile t15=new Tuile("Le Marais Brumeux");
        private Tuile t16=new Tuile("Observatoire");
        private Tuile t17=new Tuile("Le Rocher Fantome");
        private Tuile t18=new Tuile("La Caverne du Brasier");
        private Tuile t19=new Tuile("Le Temple du Soleil");
        private Tuile t20=new Tuile("Le Temple de la Lune");
        private Tuile t21=new Tuile("Le Palais des Marées");
        private Tuile t22=new Tuile("Le Val du Crépuscule");
        private Tuile t23=new Tuile("La Tour du Guet");
        private Tuile t24=new Tuile("Le Jardin des Murmures");

        //Constructeur
        public Grille() {
               ArrayList<Tuile> liste = new ArrayList<>();
               
               //ajout des tuiles à une collection
                liste.add(t1);liste.add(t2);liste.add(t3);liste.add(t4);liste.add(t5);liste.add(t6);liste.add(t7);liste.add(t8);liste.add(t9);liste.add(t10);
                liste.add(t11);liste.add(t12);liste.add(t13);liste.add(t14);liste.add(t15);liste.add(t16);liste.add(t17);liste.add(t18);liste.add(t19);liste.add(t20);
                liste.add(t21);liste.add(t22);liste.add(t23);liste.add(t24);
                
                //Permet de positionner les tuiles aléatoirement dans la collection
               Collections.shuffle(liste);
               int j =0;
               int col = 0;
               int lig = 0;
               
               //Créer la grille de 6 par 6 comprennant les tuiles vides
               for (int i=1; i<=36; ++i) {
                   if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
                        Tuile vide=new Tuile("Vide");
                        vide.setColonne(col);
                        vide.setLigne(lig);
                        tuiles.add(vide);
                   } else {
                    liste.get(j).setColonne(col);
                    liste.get(j).setLigne(lig);
                    tuiles.add(liste.get(j));
                    ++j;
                   }
                   col=(col+1)%6;
                   if (i%6 == 0){
                       lig=lig+1;
                   }
                   
               }
        }
      
        public ArrayList<Tuile> getTuilesGrille() {
            return tuiles;
        }

        
        //Retourne une collection de tuiles correspondant aux tuiles adjacentes à la positionCourante
	public ArrayList<Tuile> getListeTuileAdj(Tuile positionCourante) {
                
                ArrayList<Tuile> Liste = new ArrayList();
                int col = positionCourante.getColonne();
                int lig = positionCourante.getLigne();
                for(int i=1; i<tuiles.size();i++) {  
                if(col==0){
                // Verifie que la tuile positionCourante ne se situe pas sur les bord de la grille
                // Cad lig !=0 && lig!=5 && col!=0 && col!=5 
                // Sinon gére les exception
                    if (lig==2||lig==3){                       
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col)) ||((tuiles.get(i).getLigne()== lig+1 ) && (tuiles.get(i).getColonne()== col))  ){
                            // Verifie si la tuile "tuiles.get(i)" est adjacente a la tuile positionCourante
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                // Verifie si la tuile n'est pas definie comme vide
                                // Si oui l'ajoute à la liste
                                Liste.add(tuiles.get(i));
                            }
                        }
                    } 
                }else if(col==5) {     
                    if (lig==2||lig==3){                       
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col)) ||((tuiles.get(i).getColonne()== col) && tuiles.get(i).getLigne()==lig +1)  ){
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                Liste.add(tuiles.get(i));
                            }                        
                        }                        
                    }  
                }else if(lig==0) { 
                    if (col==2||col==3){
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col))||((tuiles.get(i).getLigne()== lig ) && (tuiles.get(i).getColonne()== col+1))  ){
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                Liste.add(tuiles.get(i));
                            }                        
                        }                   
                    }
                }else if(lig==5) {   
                    if (col==2||col==3){                        
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col)) ||((tuiles.get(i).getLigne()== lig ) && (tuiles.get(i).getColonne()== col+1)) ){
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                Liste.add(tuiles.get(i));
                            }                        
                        }                   
                    }                    
                }else{  // lig !=0 && lig!=5 && col!=0 && col!=5 
                        if (((tuiles.get(i).getColonne()== col +1 )&&  tuiles.get(i).getLigne()== lig )|| ((tuiles.get(i).getColonne()== col -1)&&tuiles.get(i).getLigne()== lig) || ((tuiles.get(i).getLigne()== lig +1)&&tuiles.get(i).getColonne()== col) ||((tuiles.get(i).getLigne()== lig -1)&&tuiles.get(i).getColonne()== col ) ){
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                Liste.add(tuiles.get(i));
                            }                    
                        }
                    }      
                }       
                
                
                for(Tuile t: Liste){
                t.afficheTuile();
            }
                System.out.println();
                System.out.println();
                System.out.println();
                return Liste;
	}

        
        //Retourne une collection de tuiles correspondant aux tuiles sur les diagonales de la positionCourante d'un Aventurier
        public ArrayList<Tuile> getListeTuileDiag(Tuile positionCourante) {
            
            ArrayList<Tuile> Liste = new ArrayList();
            int col = positionCourante.getColonne();
            int lig = positionCourante.getLigne();
            for(int i=0; i<tuiles.size();i++) {//boucle sur la taille de la grille
                if(col==0){
                // Verifie que la tuile positionCourante ne se situe pas sur les bord de la grille
                // Cad lig !=0 && lig!=5 && col!=0 && col!=5 
                // Sinon gére les exception
                    if (lig==2||lig==3){
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col+1))  ){
                            // Verifie si la tuile "tuiles.get(i)" est diagonale a la tuile positionCourante
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                // Verifie si la tuile n'est pas definie comme vide
                                // Si oui l'ajoute à la liste
                                Liste.add(tuiles.get(i));
                            }                        
                        }
                    }
                }else if(col==5) {     
                    if (lig==2 || lig==3){
                        if ( ((tuiles.get(i).getColonne()== col- 1) && tuiles.get(i).getLigne()==lig-1 )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col-1))  ){
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                Liste.add(tuiles.get(i));
                            }                        
                        }
                    }
                }else if(lig==0) { 
                    if (col==2 || col==3){
                        if ( ((tuiles.get(i).getColonne()== col+1 ) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig+1 ) && (tuiles.get(i).getColonne()== col))  ){
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                Liste.add(tuiles.get(i));
                            }
                        }                  
                    }
                }else if(lig==5) {  
                    if (col==2 || col==3){
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig-1 )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col-1))||((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig-1 )   ){
                            if (tuiles.get(i).getNomCase()!="Vide"){
                                Liste.add(tuiles.get(i));
                            }                         
                        }
                    }
                }else{ // lig !=0 && lig!=5 && col!=0 && col!=5 
                    if (((tuiles.get(i).getColonne()== col +1 )&&  tuiles.get(i).getLigne()== lig+1 )|| ((tuiles.get(i).getColonne()== col +1)&&tuiles.get(i).getLigne()== lig-1) || ((tuiles.get(i).getLigne()== lig +1)&&tuiles.get(i).getColonne()== col-1) ||((tuiles.get(i).getLigne()== lig -1)&&tuiles.get(i).getColonne()== col-1 ) ){
                        if (tuiles.get(i).getNomCase()!="Vide"){
                            Liste.add(tuiles.get(i));
                        }                        
                    }
                }      
            }                
            for(Tuile t: Liste){
                t.afficheTuile();
            }
            System.out.println();
            System.out.println();
            System.out.println();

            return Liste;
	}
               
        
        //Retourne une arrayList de tuiles comprennant les tuiles adjacentes et les tuiles diagonales
        public ArrayList<Tuile> getListeTuileAdjDiag(Tuile positionCourante) {
            ArrayList<Tuile> listReturn=new ArrayList();
            ArrayList<Tuile> listDiag;
            
            listReturn=this.getListeTuileAdj(positionCourante);
            listDiag=this.getListeTuileDiag(positionCourante);
            for(int i=0;i<listDiag.size();i++){
                listReturn.add(listDiag.get(i));
            }
            
            return listReturn;
        }
        
        
        //Retourne toutes les tuiles non coulées de la grille
        public ArrayList<Tuile> getTuilesPossibles(){
            ArrayList<Tuile> liste = new ArrayList();
            for(Tuile t : tuiles) {
                if(t.getNomCase()!="Vide"){
                    if(t.getStatut()==ASSECHEE || t.getStatut()==INONDEE){
                        liste.add(t);
                    }
                }
            }
            return liste;
        }
    
        
        //Retourne la tuile à partir d'une colonne et d'une ligne données
        public Tuile getTuile(int colonne, int ligne) {
            for(Tuile t : tuiles) {
                if(t.getColonne() == colonne && t.getLigne() == ligne) {
                    return t;
                }
            }
            return null;
        }
        
        
        //Retourne la tuile à partir d'un nom donné
        public Tuile getTuile(String nom){
            Tuile tuileRet=new Tuile("");
            for (Tuile T1:tuiles){
                if (T1.getNomCase()==nom){
                    tuileRet=T1;
                }
            }
            
            return tuileRet;
        }
       
        //Affiche intégralement, dans la console, la grille
        public void afficheGrille(){
        //fonction servant uniquement a affiché la grille lors de la création du code
        for (int i=0;i<(this.getTuilesGrille().size());++i){
               this.getTuilesGrille().get(i).afficheTuile();
               System.out.println(" : "+i);
               
        }
    }
}

