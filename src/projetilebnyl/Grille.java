package projetilebnyl;

import java.util.ArrayList;
import projetilebnyl.Tuile;
import java.util.Vector;

public class Grille {
	public ArrayList<Tuile> tuiles = new ArrayList<>();
        private Tuile vide1=null;
        private Tuile vide2=null;
        private Tuile vide3=null;
        private Tuile vide4=null;
        private Tuile vide5=null;
        private Tuile vide6=null;
        private Tuile vide7=null;
        private Tuile vide8=null;
        private Tuile vide9=null;
        private Tuile vide10=null;
        private Tuile vide11=null;
        private Tuile vide12=null;
        private Tuile t1=new Tuile("Le Pont des Abimes");
        private Tuile t2=new Tuile("La Porte de Bronze");
        private Tuile t3=new Tuile("La Caverne Des Ombres");
        private Tuile t4=new Tuile("La Porte de Fer");
        private Tuile t5=new Tuile("La Porte d'Or");
        private Tuile t6=new Tuile("Les Falaises de l'Oubli");
        private Tuile t7=new Tuile("Le Palais de Corail");
        private Tuile t8=new Tuile("La Porte d'Argent");
        private Tuile t21=new Tuile("Les Dunes de L'Illusion");
        private Tuile t22=new Tuile("Héliport");
        private Tuile t23=new Tuile("La Porte de Cuivre");
        private Tuile t24=new Tuile("Le Jardin des Hurlements");
        private Tuile t25=new Tuile("La Foret Pourpre");
        private Tuile t26=new Tuile("Le Lagon Perdu");
        private Tuile t27=new Tuile("Le Marais Brumeux");
        private Tuile t28=new Tuile("Observatoire");
        private Tuile t29=new Tuile("LeRocher Fantome");
        private Tuile t30=new Tuile("La Caverne du Brasier");
        private Tuile t31=new Tuile("Le Temple du Soleil");
        private Tuile t32=new Tuile("Le Temple de la Lune");
        private Tuile t33=new Tuile("Le Palais des Marées");
        private Tuile t34=new Tuile("Le Val du Crépuscule");
        private Tuile t35=new Tuile("La Tour du Guet");
        private Tuile t36=new Tuile("Le Jardin des Murmures");

        public Grille() {
               
        }
      
        //public Grille(){
            
        //}
        

	public ArrayList<Tuile> getListeTuileAdj(Tuile aPositActu) {
                ArrayList<Tuile> Liste = new ArrayList();
                int col = aPositActu.getColonne();
                int lig = aPositActu.getLigne();
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

	public ArrayList<Tuile> getListeTuileDiag(Tuile aPositActu) {
		ArrayList<Tuile> Liste = new ArrayList();
                int col = aPositActu.getColonne();
                int lig = aPositActu.getLigne();
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
        
        
}