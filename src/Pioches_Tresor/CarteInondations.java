package Pioches_Tresor;


import Grille.Grille;
import Grille.Tuile;
import java.util.ArrayList;
import java.util.Collections;
import static Vues.Utils.EtatTuile.*;


public class CarteInondations {
       
    public ArrayList<Carte> piocheInondation = new ArrayList<>();
    public ArrayList<Carte> defausseInondation = new ArrayList<>();

    //Créer chacunes des cartes du jeu
    private Carte c1 = new Carte("Le Pont des Abimes");
    private Carte c2 = new Carte("La Porte de Bronze");
    private Carte c3 = new Carte("La Caverne Des Ombres");
    private Carte c4 = new Carte("La Porte de Fer");
    private Carte c5 = new Carte("La Porte d'Or");
    private Carte c6 = new Carte("Les Falaises de l'Oubli");
    private Carte c7 = new Carte("Le Palais de Corail");
    private Carte c8 = new Carte("La Porte d'Argent");
    private Carte c9 = new Carte("Les Dunes de L'Illusion");
    private Carte c10 = new Carte("Héliport");
    private Carte c11 = new Carte("La Porte de Cuivre");
    private Carte c12 = new Carte("Le Jardin des Hurlements");
    private Carte c13 = new Carte("La Foret Pourpre");
    private Carte c14 = new Carte("Le Lagon Perdu");
    private Carte c15 = new Carte("Le Marais Brumeux");
    private Carte c16 = new Carte("Observatoire");
    private Carte c17 = new Carte("Le Rocher Fantome");
    private Carte c18 = new Carte("La Caverne du Brasier");
    private Carte c19 = new Carte("Le Temple du Soleil");
    private Carte c20 = new Carte("Le Temple de la Lune");
    private Carte c21 = new Carte("Le Palais des Marées");
    private Carte c22 = new Carte("Le Val du Crépuscule");
    private Carte c23 = new Carte("La Tour du Guet");
    private Carte c24 = new Carte("Le Jardin des Murmures");
    
    
    //Constructeur
    public CarteInondations() {
        
        //Ajoute les cartes à une collection
        piocheInondation.add(c1);
        piocheInondation.add(c2);
        piocheInondation.add(c3);
        piocheInondation.add(c4);
        piocheInondation.add(c5);
        piocheInondation.add(c6);
        piocheInondation.add(c7);
        piocheInondation.add(c8);
        piocheInondation.add(c9);
        piocheInondation.add(c10);
        piocheInondation.add(c11);
        piocheInondation.add(c12);
        piocheInondation.add(c13);
        piocheInondation.add(c14);
        piocheInondation.add(c15);
        piocheInondation.add(c16);
        piocheInondation.add(c17);
        piocheInondation.add(c18);
        piocheInondation.add(c19);
        piocheInondation.add(c20);
        piocheInondation.add(c21);
        piocheInondation.add(c22);
        piocheInondation.add(c23);
        piocheInondation.add(c24);
        
        //Mélange aléatoirement ces cartes
        Collections.shuffle(piocheInondation);
    }
    
    //Gère le nombre de cartes piochées suivant le niveau d'eau du jeu
    public void piocheInondation (int niveauEau, Grille grille){
        int nbPioche=0;
        if(niveauEau==0||niveauEau==1){
            nbPioche=2;
        }else if (niveauEau==2||niveauEau==3||niveauEau==4){
            nbPioche=3;
        }else if (niveauEau==5|| niveauEau==6){
            nbPioche=4;
        }else if (niveauEau==7||niveauEau==8){
            nbPioche=5;
        }        
        
        //Rend les tuiles concernées par la pioche, inondées ou coulées
        for (int i = 0; i < nbPioche; i++){
            defausseInondation.add(piocheInondation.get(0));
            Tuile t1 = grille.getTuile(piocheInondation.get(0).getNomCarte());
            if (t1.getStatut()==ASSECHEE){
                t1.setStatut(INONDEE);
            } else if (t1.getStatut()==INONDEE){
                t1.setStatut(COULEE);
                defausseInondation.remove(t1);
            }
            System.out.println(t1.getNomCase() + " devient " + t1.getStatut());
            
            //Supprimer de la pioche la carte inondation utilisée
            //Remet à jour la pioche si celle-ci devient vide
            piocheInondation.remove(piocheInondation.get(0));
            if (piocheInondation.size()==0){
                this.remiseDefausse();
            }
        }
        
        
    }
     
    
    //Permet la "remise" à jour de la pioche
    public void remiseDefausse(){
        ArrayList<Carte> listePioche = this.getPiocheInondation();
        ArrayList<Carte> listeDefausse = this.getDefausseInondation();
        ArrayList<Carte> listeTemp = new ArrayList<>();
        Collections.shuffle(listeDefausse);
        listeTemp=listeDefausse;
        
        for (Carte c1 : listePioche){
            listeTemp.add(c1);
        }
        this.setPiocheInondation(listeTemp);
        ArrayList<Carte> listeVide = new ArrayList<>();
        setDefausseInondation(listeVide);
        
    }
    
    //Getter et setter
    public ArrayList<Carte> getPiocheInondation() {
        return piocheInondation;
    }

    public ArrayList<Carte> getDefausseInondation() {
        return defausseInondation;
    }

    public void setPiocheInondation(ArrayList<Carte> piocheInondation) {
        this.piocheInondation = piocheInondation;
    }

    public void setDefausseInondation(ArrayList<Carte> defausseInondation) {
        this.defausseInondation = defausseInondation;
    }
        
}
