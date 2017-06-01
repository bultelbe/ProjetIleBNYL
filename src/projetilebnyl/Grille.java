package projetilebnyl;

import java.util.ArrayList;
import projetilebnyl.Tuile;
import java.util.Vector;

public class Grille {
	public ArrayList<Tuile> tuiles = new ArrayList<>();

	
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
}

