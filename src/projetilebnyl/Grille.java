package projetilebnyl;

import java.util.ArrayList;
import java.util.Collections;
import projetilebnyl.Tuile;
import java.util.Vector;
import static projetilebnyl.Utils.EtatTuile.*;

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
        private Tuile t17=new Tuile("LeRocher Fantome");
        private Tuile t18=new Tuile("La Caverne du Brasier");
        private Tuile t19=new Tuile("Le Temple du Soleil");
        private Tuile t20=new Tuile("Le Temple de la Lune");
        private Tuile t21=new Tuile("Le Palais des Marées");
        private Tuile t22=new Tuile("Le Val du Crépuscule");
        private Tuile t23=new Tuile("La Tour du Guet");
        private Tuile t24=new Tuile("Le Jardin des Murmures");

        public Grille() {
               ArrayList<Tuile> liste= new ArrayList<>();
               
               
               t9.setStatut(COULEE);
               t14.setStatut(INONDEE);
               t15.setStatut(COULEE);
               t16.setStatut(INONDEE);
               t17.setStatut(COULEE);
               t18.setStatut(INONDEE);
               t20.setStatut(COULEE);
               t24.setStatut(INONDEE);
               liste.add(t1);liste.add(t2);liste.add(t3);liste.add(t4);liste.add(t5);liste.add(t6);liste.add(t7);liste.add(t8);liste.add(t9);liste.add(t10);
               liste.add(t11);liste.add(t12);liste.add(t13);liste.add(t14);liste.add(t15);liste.add(t16);liste.add(t17);liste.add(t18);liste.add(t19);liste.add(t20);
               liste.add(t21);liste.add(t22);liste.add(t23);liste.add(t24);
               //Collections.shuffle(liste);
               int j =0;
               int col=0;
               int lig =0;                    
               for (int i=1; i<=36; ++i){
                   if(i==1 || i==2 || i==5 || i==6 || i==7 || i==12 || i==25 || i==30|| i==31 || i==32 | i==35 || i==36){
                        Tuile vide=new Tuile("Vide");
                        vide.setColonne(col);
                        vide.setLigne(lig);
                        tuiles.add(vide);
                   }else{
                    liste.get(j).setColonne(col);
                    liste.get(j).setLigne(lig);
                    tuiles.add(liste.get(j));
                    ++j;
                   }
                   col=(col+1)%6;
                   if (i%6+1==1){
                       lig=lig+1;
                   }
                   
               }
        }
      


	public ArrayList<Tuile> getListeTuileAdj(Tuile positionCourante) {
                ArrayList<Tuile> Liste = new ArrayList();
                int col = positionCourante.getColonne();
                int lig = positionCourante.getLigne();
                for(int i=1; i<=tuiles.size();i++) {
                    
                    
                if(col==0){
                    
                    
                    if (lig==2){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                    }else if (lig==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }
                    }
                    
                }else if(col==5) {     
                    if (lig==2){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col- 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                    }else if (lig==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }
                    }
                    
                }else if(lig==0) { 
                    if (col==2){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col+1 ) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig+1 ) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                    }else if (col==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }                   
                    }
                }else if(lig==5) {   
                    if (col==2){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                    }else if (col==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }                   
                    }
                }else if(col==1 && lig ==1){
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                }else if(col==1 && lig ==4){
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                }else if(col== 4 && lig == 1){
                        if ( ((tuiles.get(i).getColonne()== col- 1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                }else if(col==4 && lig==4){
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }
                    
                }else{  
                    if (((tuiles.get(i).getColonne()== col +1 )&&  tuiles.get(i).getLigne()== lig )|| ((tuiles.get(i).getColonne()== col -1)&&tuiles.get(i).getLigne()== lig) || ((tuiles.get(i).getLigne()== lig +1)&&tuiles.get(i).getColonne()== col) ||((tuiles.get(i).getLigne()== lig -1)&&tuiles.get(i).getColonne()== col ) ){
                            Liste.add(tuiles.get(i));
                    }
                  }      
                }                
                
                return Liste;
	}

	public ArrayList<Tuile> getListeTuileDiag(Tuile positionCourante) {
		ArrayList<Tuile> Liste = new ArrayList();
                int col = positionCourante.getColonne();
                int lig = positionCourante.getLigne();
                for(int i=1; i<=tuiles.size();i++) {
                    
                    
                if(col==0){
                    
                    
                    if (lig==2||lig==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col+1))  ){
                            Liste.add(tuiles.get(i));
                        }

                    }
                    
                }else if(col==5) {     
                    if (lig==2 || lig==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col- 1) && tuiles.get(i).getLigne()==lig-1 )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col-1))  ){
                            Liste.add(tuiles.get(i));
                        }
                        
                    }
                    
                }else if(lig==0) { 
                    if (col==2 || col==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col+1 ) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig+1 ) && (tuiles.get(i).getColonne()== col))  ){
                            Liste.add(tuiles.get(i));
                        }

                    }else if (col==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig -1)  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col-1))  ){
                            Liste.add(tuiles.get(i));
                        }                   
                    }
                }else if(lig==5) {   
                    if (col==2 || col==3){
                        
                        
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig-1 )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col-1))||((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig-1 )   ){
                            Liste.add(tuiles.get(i));
                        }
                        
                    }
                }else if((col==1 && lig ==1)||(col==2 && lig ==1)||(col==1 && lig ==2)){
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col-1))  ){
                            Liste.add(tuiles.get(i));
                        }

                }else if((col==1 && lig ==4)||(col==1 && lig ==3)||(col==2 && lig ==4)){
                        if ( ((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col-1))||((tuiles.get(i).getColonne()== col+ 1) && tuiles.get(i).getLigne()==lig-1 )   ){
                            Liste.add(tuiles.get(i));
                        }

                }else if((col== 4 && lig == 1)||(col==3 && lig ==1)||(col==2 && lig ==4)){
                       if ( ((tuiles.get(i).getColonne()== col- 1) && tuiles.get(i).getLigne()==lig-1 )  ||((tuiles.get(i).getColonne()== col- 1) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig +1) && (tuiles.get(i).getColonne()== col+1))  ){
                            Liste.add(tuiles.get(i));
                        }

                }else if((col==4 && lig==4)||(col==4 && lig ==3)||(col==3 && lig ==4)){
                        if ( ((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig-1 )  ||((tuiles.get(i).getColonne()== col-1) && tuiles.get(i).getLigne()==lig+1 )  ||((tuiles.get(i).getLigne()== lig -1) && (tuiles.get(i).getColonne()== col+1))  ){
                            Liste.add(tuiles.get(i));
                        }
                    
                }else{  
                    if (((tuiles.get(i).getColonne()== col +1 )&&  tuiles.get(i).getLigne()== lig )|| ((tuiles.get(i).getColonne()== col -1)&&tuiles.get(i).getLigne()== lig) || ((tuiles.get(i).getLigne()== lig +1)&&tuiles.get(i).getColonne()== col) ||((tuiles.get(i).getLigne()== lig -1)&&tuiles.get(i).getColonne()== col ) ){
                            Liste.add(tuiles.get(i));
                    }
                  }      
                }                
                
                return Liste;
	}

    public ArrayList<Tuile> getGrille() {
        return tuiles;
    }
    
    public Tuile getTuile(int colonne, int ligne) {
        for(Tuile t : tuiles) {
            if(t.getColonne() == colonne && t.getLigne() == ligne) {
                return t;
            }
        }
        return null;
    }
        
    public void afficheGrille(){
        for (int i=0;i<(this.getGrille().size());++i){
               this.getGrille().get(i).afficheTuiles();System.out.println(" : "+i);
               
        }
    }
}

