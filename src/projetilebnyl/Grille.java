package projetilebnyl;

import java.util.ArrayList;
import projetilebnyl.Tuile;
import java.util.Vector;

public class Grille {
	public ArrayList<Tuile> _tuiles = new ArrayList<>();

	public ArrayList<Tuile> getListeTuileAdj(Tuile aPositActu) {
                ArrayList<Tuile> Liste = new ArrayList();
                int col = aPositActu.getColonne();
                int lig = aPositActu.getLigne();
                for(int i=1; i<=_tuiles.size();i++) {
                    
                    
                if(col==0){
                    
                    
                    if (lig==2){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col+ 1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig +1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }

                    }else if (lig==3){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col+ 1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig -1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }
                    }
                    
                }else if(col==5) {     
                    if (lig==2){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col- 1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig +1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }

                    }else if (lig==3){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col-1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig -1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }
                    }
                    
                }else if(lig==0) { 
                    if (col==2){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col+1 ) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig-1 ) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }

                    }else if (col==3){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col-1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig -1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }                   
                    }
                }else if(lig==5) {   
                    if (col==2){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col+ 1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig +1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }

                    }else if (col==3){
                        
                        
                        if ( ((_tuiles.get(i).getColonne()== col-1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig +1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }                   
                    }
                }else if(col==1 && lig ==1){
                        if ( ((_tuiles.get(i).getColonne()== col+ 1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig +1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }

                }else if(col==1 && lig ==4){
                        if ( ((_tuiles.get(i).getColonne()== col+ 1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig -1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }

                }else if(col== 4 && lig == 1){
                        if ( ((_tuiles.get(i).getColonne()== col- 1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig +1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }

                }else if(col==4 && lig==4){
                        if ( ((_tuiles.get(i).getColonne()== col-1) && _tuiles.get(i).getLigne()==lig )  ||((_tuiles.get(i).getLigne()== lig -1) && (_tuiles.get(i).getColonne()== col))  ){
                            Liste.add(_tuiles.get(i));
                        }
                    
                }else{  
                    if (((_tuiles.get(i).getColonne()== col +1 )&&  _tuiles.get(i).getLigne()== lig )|| ((_tuiles.get(i).getColonne()== col -1)&&_tuiles.get(i).getLigne()== lig) || ((_tuiles.get(i).getLigne()== lig +1)&&_tuiles.get(i).getColonne()== col) ||((_tuiles.get(i).getLigne()== lig -1)&&_tuiles.get(i).getColonne()== col ) ){
                        
                    }
                  }      
                }                
                
                return Liste;
	}

	public ArrayList<Tuile> getListeTuileDiag(Tuile aPositActu) {
		throw new UnsupportedOperationException();
	}
}