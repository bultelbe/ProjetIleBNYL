package projetilebnyl;


import Pioches_Tresor.Carte;
import Pioches_Tresor.CarteInondations;
import Pioches_Tresor.CarteTresors;

import Aventurier.Plongeur;
import Aventurier.Pilote;
import Aventurier.Navigateur;
import Aventurier.Messager;
import Aventurier.Ingenieur;
import Aventurier.Explorateur;
import Aventurier.Aventurier;
import Grille.Grille;
import Grille.Tuile;
import java.util.*;
import static Vues.Utils.EtatTuile.*;
import static Vues.Utils.Cartes.*;
import static java.lang.Integer.parseInt;
import Vues.*;
import static projetilebnyl.Message.TypeMessage.*;


public class Controleur implements Observateur {
    public Grille grille;
    public ArrayList<Aventurier> joueurs = new ArrayList<>();
    public VueAventurier vueAventurier;
    public VueInscription vueInscription;

    private final Tuile spawnMessager;
    private final Tuile spawnPlongeur;
    private final Tuile spawnIngenieur;
    private final Tuile spawnNavigateur;
    private final Tuile spawnPilote;
    private final Tuile spawnExplorateur;
    private int act = 3;
    private int niveauEau;
    private Aventurier aventurierCourant;
    private CarteTresors piocheCarteTresor= new CarteTresors();
    private CarteInondations piocheCarteInondations= new CarteInondations();
    private Tresor cristal = new Tresor(CRISTAL.toString());
    private Tresor statute = new Tresor(STATUE.toString());
    private Tresor pierre = new Tresor(PIERRE.toString());
    private Tresor calice = new Tresor(CALICE.toString());
    private Carte Helicoptere1= new Carte(HELICOPTERE);
    private Carte Helicoptere2= new Carte(HELICOPTERE);
    private Carte Helicoptere3= new Carte(HELICOPTERE);
    
    private VueDeplacement vueDeplacement;
    
    private boolean actionPilote = true;
    
    public Controleur() {
        
        grille = new Grille();        
        initGrille();
        piocheCarteTresor.addPiocheTresor(Helicoptere1);
        piocheCarteTresor.addPiocheTresor(Helicoptere2);
        piocheCarteTresor.addPiocheTresor(Helicoptere3);
        Collections.shuffle(piocheCarteTresor.getPiocheTresor());
        initTresor();
        spawnMessager = grille.getTuile("La Porte d'Or");
        spawnPlongeur = grille.getTuile("La Porte de Fer");
        spawnIngenieur = grille.getTuile("La Porte de Bronze");
        spawnNavigateur = grille.getTuile("La Porte d'Argent");
        spawnPilote = grille.getTuile("Héliport");
        spawnExplorateur = grille.getTuile("La Porte de Cuivre");

        
        
        
        
//        joueurs.add(new Messager("Goddefroy", spawnMessager, "Messager"));
//        joueurs.add(new Plongeur("Duck", spawnPlongeur, "Plongeur"));
//        joueurs.add(new Ingenieur("Jean-Jack", spawnIngenieur, "Ingenieur"));
//        joueurs.add(new Navigateur("Magelan", spawnNavigateur, "Navigateur"));
//        joueurs.add(new Pilote("Jones", spawnPilote, "Pilote"));
//        joueurs.add(new Explorateur("Colonb", spawnExplorateur, "Explorateur"));
//        aventurierCourant = joueurs.get(0);
    }
    
    
    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public Aventurier getAventurierCourant() {
        return aventurierCourant;
    }

    public Grille getGrille() {
        return grille;
    }

    public int getAct() {
        return act;
    }
    
    public int getNiveauEau() {
        return niveauEau;
    }
    
    public VueDeplacement getVueDeplacement() {
        return vueDeplacement;
    }
 
    public VueAventurier getVueAventurier() {
        return this.vueAventurier;
    }
    
    
    
    public void setAct(int act) {
        this.act = act;
    }
    
    public void setNiveauEau(int niveauEau) {
        this.niveauEau = niveauEau;
    }
   
    public void setVueDeplacement(VueDeplacement vueDeplacement) {
        this.vueDeplacement = vueDeplacement;
    }
      
    public void setVueAvt (VueAventurier vueAvt) {
        this.vueAventurier = vueAvt;
    }
    
    
    
    
    
    public void TourDeJeu() {

        if (getAct() == 0) {
            System.out.println("Vous avez fini votre tour, Appuyez sur Terminer");
            getVueAventurier().getBtnAller().setEnabled(false);
            getVueAventurier().getBtnAssecher().setEnabled(false);
            getVueAventurier().getBtnCarteSpe().setEnabled(false);
            getVueAventurier().getBtnEchangeCarte().setEnabled(false);
            getVueAventurier().getBtnRecupTresor().setEnabled(false);
            act = 3;
        }
    }

    
    public void assechementCase() {
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = aventurierCourant.assechementsPossibles(getGrille());
        
        if (tuilesAssechables.isEmpty()) {
            System.out.println("\nIl n'y a aucunes tuiles à assécher autour de vous.");
        } else {
            Scanner sc = new Scanner(System.in);
            
            if ("Ingenieur".equals(aventurierCourant.getNoma())) {
                
                System.out.println("Combien de tuiles voulez-vous assécher (2 maximum) ?");
                String nbrActions = sc.nextLine();
                int i = Integer.parseInt(nbrActions);
                int j=0;
                if(i==2 && tuilesAssechables.size()>=2){
                    while (j<=2){
                        
                        System.out.println("Vous asséchez deux case.");
                        
                        for (Tuile t : tuilesAssechables) {
                            t.afficheTuile();
                        }
                        
                        System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
                        String tuileX = sc.nextLine();
                        int x = parseInt(tuileX);

                        System.out.print("\nY : ");
                        String tuileY = sc.nextLine();
                        int y = parseInt(tuileY);

                        Tuile t = grille.getTuile(x, y);

                        if (tuilesAssechables.contains(t)) {
                            t.setStatut(ASSECHEE);
                            
                            System.out.println("Vous avez asséché la tuile : " + t.getNomCase() + "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
                            act=act-1;
                            j=j+1;
                        } else {
                            System.out.println("Cette tuile n'est pas asséchable.");
                        }
                    }
                }else{
                    System.out.println("Vous ne pouvez asséchez qu'une case.");
                    
                    for (Tuile t : tuilesAssechables) {
                        t.afficheTuile();
                    }
                    
                    System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
                    String tuileX = sc.nextLine();
                    int x = parseInt(tuileX);

                    System.out.print("\nY : ");
                    String tuileY = sc.nextLine();
                    int y = parseInt(tuileY);

                    Tuile t = getGrille().getTuile(x, y);

                    if (tuilesAssechables.contains(t)) {
                        t.setStatut(ASSECHEE);

                        System.out.println("Vous avez asséché la tuile : " + t.getNomCase() + "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
                        act = act-1;
                    } else {
                        System.out.println("Cette tuile n'est pas asséchable."); 
                    }
                }
            } else {
                
                 for (Tuile t : tuilesAssechables) {
                            t.afficheTuile();
                        }
                
                System.out.print("\nRentrez les coordonnées de la Tuile que vous voulez assécher. \nX : ");
                String tuileX = sc.nextLine();
                int x = parseInt(tuileX);

                System.out.print("\nY : ");
                String tuileY = sc.nextLine();
                int y = parseInt(tuileY);

                Tuile t = grille.getTuile(x, y);

                if (tuilesAssechables.contains(t)) {
                    t.setStatut(ASSECHEE);
                    System.out.println("Vous avez asséché la tuile : " + t.getNomCase() + "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
                    act=act-1;
                } else {
                    System.out.println("Cette tuile n'est pas asséchable.");

                }
            }
            
        }
        getVueAventurier().updateCellules(grille);
        
        this.TourDeJeu();
    }
    
    public void passerJoueurSuivant() {
        
        this.piocherInnodation();        
        for (int i = 0; i < joueurs.size(); i++) {
            if (joueurs.get(i).getPositionCourante().getStatut() == COULEE) {
                
                if (possibleMouvement(joueurs.get(i)) == true) {
                    System.out.println(joueurs.get(i).getNoma() + " doit immédiatement quitter " + joueurs.get(i).getPositionCourante().getNomCase()
                        + " et se déplacer sur une autre tuile !");
                    act ++;
                    joueurs.get(i).deplacementsPossibles(getGrille());
                    deplacementJoueurObligatoire(joueurs.get(i));
                    
                } else {
                    System.out.println("\nFin de partie ! Vous avez perdu.");
                    getVueAventurier().getBtnAller().setEnabled(false);
                    getVueAventurier().getBtnAssecher().setEnabled(false);
                    getVueAventurier().getBtnCarteSpe().setEnabled(false);
                    getVueAventurier().getBtnEchangeCarte().setEnabled(false);
                    getVueAventurier().getBtnRecupTresor().setEnabled(false);
                    getVueAventurier().getBtnTerminerTour().setEnabled(false);
                    break;
                }
            }
        }

       piocherTresor();
        act = 3;
        aventurierCourant = joueurs.get(((joueurs.indexOf(aventurierCourant))+1)%this.getJoueurs().size());
        getVueAventurier().updateAventurier(aventurierCourant.getNomJ(), aventurierCourant.getNoma(), aventurierCourant.getColor(), aventurierCourant.getPositionCourante().getNomCase());
        this.getVueAventurier().carteMainJoueurCourant();
        this.getVueAventurier().updateCellules(getGrille());
        
        for(int i=0;i<this.getAventurierCourant().getCarteMain().size();i++){
        
        System.out.println(this.getAventurierCourant().getCarteMain().get(i).getNomCarte());
        }
    }
       
    public void deplacementJoueurObligatoire(Aventurier avt) {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        tuilesPossibles = avt.deplacementsPossibles(grille);
        vueDeplacement = new VueDeplacement(this,avt);

        for (Tuile t : tuilesPossibles) {
            System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
        }
        
        getVueDeplacement().afficher();

        getVueAventurier().updateAventurier(avt.getNomJ(), avt.getNoma(), avt.getColor(), avt.getPositionCourante().getNomCase());

        getVueAventurier().updateCellules(grille);
    }
        
    
    
    public void deplacementJoueur() {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();
        vueDeplacement = new VueDeplacement(this, aventurierCourant);

        if (getAventurierCourant().getNoma() == "Pilote" && getAventurierCourant().getActionPilote() == true) {
            System.out.println("Voulez vous effectuer votre action spéciale ? (tapez oui ou non)");
            Scanner sc = new Scanner(System.in);
            String s1 = sc.nextLine();
            
            if (!"oui".equals(s1) && !"non".equals(s1)) {
                System.out.println("Tapez oui ou non.");
                String s2 = sc.nextLine();
                
                if (s2 == "oui") {
                    tuilesPossibles = getAventurierCourant().deplacementsPossibles(grille);
                    getAventurierCourant().setActionPilote(false);
                }
                
            } else if (s1 == "oui") {
                tuilesPossibles = getAventurierCourant().deplacementsPossibles(grille);
                getAventurierCourant().setActionPilote(false);
            } else if (s1 == "non") {
                
            }
            
            setActionPilote(false);
            
        } else if (getAventurierCourant().getNoma() == "Pilote" && getAventurierCourant().getActionPilote() == false) {
            setActionPilote(false);
            tuilesPossibles = aventurierCourant.deplacementsPossibles(grille);
            setActionPilote(true);
        } else {
            setActionPilote(false);
            tuilesPossibles = aventurierCourant.deplacementsPossibles(grille);
            setActionPilote(true);
        }
        
        for (Tuile t : tuilesPossibles) {
            System.out.println("\nNom : " + t.getNomCase() + "\nStatut : " + t.getStatut() + "\nX : " + t.getColonne() + "\nY : " + t.getLigne());
        }
        
        getVueDeplacement().afficher();
    }
    
    
    
    
    public void deplace(Aventurier avt) {
        ArrayList<Tuile> tuilesPossibles = new ArrayList<>();        
        tuilesPossibles = avt.deplacementsPossibles(grille);
        
        int x = getVueDeplacement().getX();
        int y = getVueDeplacement().getY();
        
        Tuile t = grille.getTuile(x, y);

        if (tuilesPossibles.contains(t)) {
            avt.setPositionCourante(t);
            System.out.println(avt.getNoma() + " s'est déplacé sur la tuile : " + t.getNomCase()+ "\nAux coordonnées : (" + t.getColonne() + ", " + t.getLigne() + ")");
            act = act - 1;
            
        } else {
            System.out.println("Vous ne pouvez pas vous déplacer sur cette Tuile.");
        }
        
        getVueAventurier().updateAventurier(avt.getNomJ(), avt.getNoma(), avt.getColor(), avt.getPositionCourante().getNomCase());
        
        getVueAventurier().updateCellules(grille);
    }
       
    public void echangeDeCarte() {
        ArrayList<Aventurier> echangeurs = new ArrayList<>();
        
        for(int i=0;i<joueurs.size();i++){
            if(aventurierCourant.getPositionCourante()==joueurs.get(i).getPositionCourante() && aventurierCourant!=joueurs.get(i)){
                echangeurs.add(joueurs.get(i));
            }
        }
        
        if(!(echangeurs.isEmpty())){
            if(!(aventurierCourant.getCarteMain().isEmpty())){    
                for (Aventurier a : echangeurs) {
                    System.out.println("Nom : "+a.getNomJ()+" Capacité : "+ a.getNoma());
                    System.out.println("Cartes en sa disposition : ");
                    for(Carte ca : a.getCarteMain()){
                    System.out.println("            "+ca.getNomCarte()+"\n");   
                    }
                }

                Scanner sc = new Scanner(System.in);
                System.out.print("\nRentrez le nom d'aventurier avec lequel vous voullez échanger des cartes : ");
                String aventurier = sc.nextLine();

                for (Aventurier a : echangeurs) {
                    if(aventurier.equals(a.getNoma())) {
                        System.out.print("\nQuelle carte voulez-vous échanger avec l'aventurier "+a.getNoma()+" ? : ");
                        String carte= sc.nextLine();

                        for (int i=0;i< aventurierCourant.getCarteMain().size();i++) {
                            
                            if(i!=aventurierCourant.getCarteMain().size()-1){
                                if(carte.equals(aventurierCourant.getCarteMain().get(i).getNomCarte())) {
                                    a.addCarte(aventurierCourant.getCarteMain().get(i));
                                    aventurierCourant.getCarteMain().remove(aventurierCourant.getCarteMain().get(i));
                                    act = act-1;
                                    break;
                                }
                            }else{
                                System.out.println("\nVous ne possédez pas cette carte");
                            }
                        }
                        break;
                    }else{
                        System.out.println("\nCet aventurier n'est pas disponible pour un échange");
                    }
                }
            }else{
                System.out.println("Vous n'avez pas de cartes en main pour échanger");
            }
        }else{
            System.out.println("Il n'y a pes d'Aventuriers pour echanger des cartes sur cette case");
        }

    this.getVueAventurier().updateCellules(grille);
    }
     
    public void traiterMessage(Message m) {
        switch(m.typeMessage) {
            case CLIC_BoutonAller:
                deplacementJoueur();
                break;
            case CLIC_BoutonAssecher:
                assechementCase();
                break;
            case CLIC_BoutonAutreAction:
                break;
            case CLIC_BoutonTerminer:
                passerJoueurSuivant();
                break;
            case CLIC_BoutonValider:
                for (int i = 0; i < joueurs.size(); i++) {
                    if (joueurs.get(i).getPositionCourante().getStatut() == COULEE) {
                        deplace(joueurs.get(i));
                        break;
                    } else {
                        deplace(getAventurierCourant());
                        this.TourDeJeu();
                        break;
                    }
                }
                break;
            case CLIC_BoutonEchange:
                echangeDeCarte();
                break;
                
            case CLIC_BoutonDemarrer:
                lancerVueAventurier(m);
                break;
            
            case CLIC_BoutonRecupTresor:
                recuperTresor();
                break;
        }
    }
    
    public void lancerVueAventurier(Message m){
        for (int i = 0; i < m.nomA.size(); i++) {
        
            if (m.nomA.get(i).equals("Messager"))
                joueurs.add(new Messager(m.nomJ.get(i), spawnMessager, "Messager"));

            if (m.nomA.get(i).equals("Plongeur"))
                joueurs.add(new Plongeur(m.nomJ.get(i), spawnPlongeur, "Plongeur"));

            if (m.nomA.get(i).equals("Ingénieur"))
                joueurs.add(new Ingenieur(m.nomJ.get(i), spawnIngenieur, "Ingénieur"));

            if (m.nomA.get(i).equals("Navigateur"))
                joueurs.add(new Navigateur(m.nomJ.get(i), spawnNavigateur, "Navigateur"));

            if (m.nomA.get(i).equals("Pilote"))
                joueurs.add(new Pilote(m.nomJ.get(i), spawnPilote, "Pilote"));

            if (m.nomA.get(i).equals("Explorateur"))
                joueurs.add(new Explorateur(m.nomJ.get(i), spawnExplorateur, "Explorateur"));
        }
                
        aventurierCourant = joueurs.get(0);

        VueAventurier vueAvt = new VueAventurier(joueurs.get(0).getNomJ(), joueurs.get(0).getNoma(), joueurs.get(0).getColor(), this);
        this.setVueAvt(vueAvt);
    }
    
    public void piocherTresor() {
        if (piocheCarteTresor.getPiocheTresor().size() > 0) {
            Boolean eauxPioche = false;
            Carte eaux = new Carte(EAUX);
            Carte pioche1 =piocheCarteTresor.piocheTresor();
            
            if (pioche1.getNomCarte()== eaux.getNomCarte()) {
                piocheCarteTresor.defausseTresor(pioche1);
                eauxPioche=true;
                setNiveauEau((getNiveauEau()+1));

            } else {
                aventurierCourant.addCarte(pioche1);
            }
            if (getNiveauEau()<=9 && piocheCarteTresor.getPiocheTresor().size() > 0) {
                Carte pioche2 =piocheCarteTresor.piocheTresor();
                
                if (pioche2.getNomCarte()== eaux.getNomCarte()) {
                    piocheCarteTresor.defausseTresor(pioche2);
                    setNiveauEau((getNiveauEau()+1));

                } else {
                    aventurierCourant.addCarte(pioche2);
                }

                if (eauxPioche){
                    piocheCarteInondations.remiseDefausse();
                }
            }
        }
        
    }
    
    public void piocherInnodation() {
        piocheCarteInondations.piocheInondation(getNiveauEau(),getGrille());
    }
    
    public void initGrille(){
    for (int i = 0; i < 6; i++){
            piocheCarteInondations.getDefausseInondation().add(piocheCarteInondations.getPiocheInondation().get(0));
            Tuile t1=grille.getTuile(piocheCarteInondations.getPiocheInondation().get(0).getNomCarte());
            t1.setStatut(INONDEE);

            
            piocheCarteInondations.getPiocheInondation().remove(piocheCarteInondations.getPiocheInondation().get(0));
        }
    }

    public void initTresor() {
        cristal.setSanctuaire1(grille);
        cristal.setSanctuaire2(grille);
        statute.setSanctuaire1(grille);
        statute.setSanctuaire2(grille);
        pierre.setSanctuaire1(grille);
        pierre.setSanctuaire2(grille);
        calice.setSanctuaire1(grille);
        calice.setSanctuaire2(grille);
    }
    
    public boolean possibleMouvement(Aventurier avt){
        return avt.deplacementsPossibles(grille).size() > 0 ||
                (avt.getCarteMain().contains(Helicoptere1)) ||
                (avt.getCarteMain().contains(Helicoptere2)) ||
                (avt.getCarteMain().contains(Helicoptere3));
    }
      
    public boolean continuer(){
        return (cristal.recuperable() && statute.recuperable() &&
                pierre.recuperable() && calice.recuperable() &&
                niveauEau < 9 && grille.getTuile("Héliport").getStatut() != COULEE &&
                (possibleMouvement(getAventurierCourant()) || (!possibleMouvement(getAventurierCourant()) && aventurierCourant.getPositionCourante().getStatut() != COULEE) ));
    }
    
    private boolean joueurHeliport(){
        Boolean surHeliport=true;
        for(Aventurier avt : joueurs){
            if(avt.getPositionCourante().getNomCase()!= "Héliport"){
                surHeliport=false;
            }
        }
        return surHeliport;
    }
    
    private boolean possedeHelico(){
        boolean helico=false;
        for(Aventurier avt : joueurs){
            for(Carte c: avt.getCarteMain())
                if(c.getNomCarte()== HELICOPTERE.toString()){
                    helico=true;
                }
        }
        return helico;
    }

    public boolean gagner(){
        return(cristal.getRecupere() && statute.getRecupere() &&
                pierre.getRecupere() && calice.getRecupere() &&
                joueurHeliport() && possedeHelico());
    }
    
    public void recuperTresor(){
        Tresor tr=null;
        Tuile positionJ= aventurierCourant.getPositionCourante();
        if(positionJ==cristal.getSanctuaire1() || positionJ==cristal.getSanctuaire2()){
            tr=cristal;
        }else if (positionJ==statute.getSanctuaire1() || positionJ==statute.getSanctuaire2()){
            tr=statute;
        }else if (positionJ==pierre.getSanctuaire1() || positionJ==pierre.getSanctuaire2()){
            tr=pierre;
        }else if (positionJ==calice.getSanctuaire1() || positionJ==calice.getSanctuaire2()){
            tr=calice;
        }
        if(tr!=null){
            int nbCarte=0;
            if(aventurierCourant.getPositionCourante()== tr.getSanctuaire1() || aventurierCourant.getPositionCourante()== tr.getSanctuaire2()){
                for(Carte c : aventurierCourant.getCarteMain()){
                    if (c.getNomCarte()==tr.getNom()){
                        nbCarte=nbCarte+1;
                    }
                }

                if (nbCarte>=4 ){
                    tr.setRecupere(true);
                    System.out.println("Vous avez récupéré le trésor : "+tr.getNom());
                    act=act-1;
                    ArrayList<Carte> cpMain= new ArrayList();
                    for(Carte c : aventurierCourant.getCarteMain()){
                        if (c.getNomCarte()!=tr.getNom()){
                            cpMain.add(c);
                        }
                    }
                    aventurierCourant.setCarteMain(cpMain);
                }        
            }
        }
    }

    public VueInscription getVueInscription() {
        return vueInscription;
    }

    public void setVueInscription(VueInscription vueInscription) {
        this.vueInscription = vueInscription;
    }

    public boolean isActionPilote() {
        return actionPilote;
    }

    public void setActionPilote(boolean actionPilote) {
        this.actionPilote = actionPilote;
    }
    
}
