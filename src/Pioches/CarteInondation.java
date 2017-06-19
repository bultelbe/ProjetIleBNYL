package Pioches;


import java.util.ArrayList;
import java.util.Collections;


public class CarteInondation {
    private String nomCarte;    
    public ArrayList<Carte> piocheInondation = new ArrayList<>();
    public ArrayList<Carte> defausseInondation = new ArrayList<>();

    
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
    
    CarteInondation(String nomCarte){
        this.nomCarte = nomCarte;
            
        
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
        
        Collections.shuffle(piocheInondation);
    }
    
    
    
    
    
    
    
    
}
