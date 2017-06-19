
package Pioches;

import java.util.ArrayList;
import java.util.Collections;
import static Vues.Utils.Cartes.*;


public class CarteTresors {
    private ArrayList<Carte> piocheTresor = new ArrayList<>();
    private ArrayList<Carte> defausseTresor = new ArrayList<>();
    
            private Carte cristal1= new Carte(CRISTAL);
            private Carte cristal2= new Carte(CRISTAL);
            private Carte cristal3= new Carte(CRISTAL);
            private Carte cristal4= new Carte(CRISTAL);
            private Carte cristal5= new Carte(CRISTAL);
            
            private Carte statue1= new Carte(STATUE);
            private Carte statue2= new Carte(STATUE);
            private Carte statue3= new Carte(STATUE);
            private Carte statue4= new Carte(STATUE);
            private Carte statue5= new Carte(STATUE);
            
            private Carte pierre1= new Carte(PIERRE);
            private Carte pierre2= new Carte(PIERRE);
            private Carte pierre3= new Carte(PIERRE);
            private Carte pierre4= new Carte(PIERRE);
            private Carte pierre5= new Carte(PIERRE);
            
            private Carte calice1= new Carte(CALICE);
            private Carte calice2= new Carte(CALICE);
            private Carte calice3= new Carte(CALICE);
            private Carte calice4= new Carte(CALICE);
            private Carte calice5= new Carte(CALICE);
                        
            private Carte eaux1= new Carte(EAUX);
            private Carte eaux2= new Carte(EAUX);
            private Carte eaux3= new Carte(EAUX);
            
            private Carte Helicoptere1= new Carte(HELICOPTERE);
            private Carte Helicoptere2= new Carte(HELICOPTERE);
            private Carte Helicoptere3= new Carte(HELICOPTERE);
            
            private Carte Sac1= new Carte(SABLE);
            private Carte Sac2= new Carte(SABLE);
    
    public CarteTresors() {
        piocheTresor.add(cristal1);
        piocheTresor.add(cristal2);
        piocheTresor.add(cristal3);
        piocheTresor.add(cristal4);
        piocheTresor.add(cristal5);
        piocheTresor.add(statue1);
        piocheTresor.add(statue2);
        piocheTresor.add(statue3);
        piocheTresor.add(statue4);
        piocheTresor.add(statue5);
        piocheTresor.add(pierre1);
        piocheTresor.add(pierre2);
        piocheTresor.add(pierre3);
        piocheTresor.add(pierre4);
        piocheTresor.add(pierre5);
        piocheTresor.add(calice1);
        piocheTresor.add(calice2);
        piocheTresor.add(calice3);
        piocheTresor.add(calice4);
        piocheTresor.add(calice5);
        piocheTresor.add(eaux1);
        piocheTresor.add(eaux2);
        piocheTresor.add(Helicoptere1);
        piocheTresor.add(Helicoptere2);
        piocheTresor.add(Helicoptere3);
        piocheTresor.add(Sac1);
        piocheTresor.add(Sac2);
        Collections.shuffle(piocheTresor);
        } 

        public void setPiocheTresor(ArrayList<Carte> piocheTresor) {
            this.piocheTresor = piocheTresor;
        }

        public void setDefausseTresor(ArrayList<Carte> defausseTresor) {
            this.defausseTresor = defausseTresor;
        }

        public ArrayList<Carte> getPiocheTresor() {
            return piocheTresor;
        }

        public ArrayList<Carte> getDefausseTresor() {
            return defausseTresor;
        }
   
        
       public Carte piocheTresor(){
           Carte carteRet;
           
           carteRet=piocheTresor.get(0);
           piocheTresor.remove(piocheTresor.get(0));
           return carteRet;
           
       }
       
       public void defausseTresor(Carte carte){
           defausseTresor.add(carte);
       }
    
       public void remiseDefausse(){
            ArrayList<Carte> liste = this.getDefausseTresor();
            Collections.shuffle(liste);
            setPiocheTresor(liste);
       }
    
}
