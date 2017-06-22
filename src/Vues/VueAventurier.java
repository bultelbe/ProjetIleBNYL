package Vues;


import projetilebnyl.Tresor;
import Grille.Grille;
import Grille.Tuile;
import java.awt.BorderLayout;
import java.awt.Color;
import projetilebnyl.PionJoueur;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import projetilebnyl.Observateur;
import static projetilebnyl.Message.*;
import Vues.Utils.*;
import static Vues.Utils.EtatTuile.*;
import java.awt.FlowLayout;
import java.util.ArrayList;
import projetilebnyl.Message;
import static projetilebnyl.Message.TypeMessage.CLIC_BoutonAller;
import static projetilebnyl.Message.TypeMessage.CLIC_BoutonAssecher;
import static projetilebnyl.Message.TypeMessage.CLIC_BoutonEchange;
import static projetilebnyl.Message.TypeMessage.CLIC_BoutonRecupTresor;
import static projetilebnyl.Message.TypeMessage.CLIC_BoutonTerminer;
import projetilebnyl.Observateur;

 
public class VueAventurier  {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JPanel bigPanel;
    private final JPanel panelCartes;
    private final JButton btnAller  ;
    private final JButton btnAssecher;
    private final JButton btnCarteSpe;
    private final JButton btnTerminerTour;       
    private final JButton btnEchangeCarte;
    private final JButton btnRecupTresor;
    private final JPanel position;
    private final JPanel grilletuile;
    private final JPanel panelTresors;
    private JLabel nomAvt;
    private JLabel nomTuile;
    private Observateur controleur;
    private HashMap<Integer,JPanel> cases=new HashMap();
    private HashMap<Integer,JPanel> pions=new HashMap();
    private HashMap<Integer,JPanel> cartes=new HashMap();
    private HashMap<Integer,JPanel> trésors=new HashMap();
    private HashMap<Integer,JLabel> labels=new HashMap();
    private HashMap<Integer,JLabel> cartesLabels=new HashMap();
    private ArrayList<JLabel> tresorsLabels=new ArrayList();
    
    public VueAventurier (String nomJoueur, String nomAventurier, Color couleur, Observateur ctrl) {
        this.controleur = ctrl;
        
        this.window = new JFrame();
        window.setSize(900, 900);

        window.setTitle(nomJoueur);
        bigPanel = new JPanel(new BorderLayout());
        mainPanel = new JPanel(new BorderLayout());
        bigPanel.add(mainPanel,BorderLayout.SOUTH);
        this.window.add(bigPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier + nom du joueur sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        nomAvt = new JLabel(nomAventurier,SwingConstants.CENTER );
        
        panelAventurier.add(nomAvt);
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JPanel();
        nomTuile = new JLabel(controleur.getAventurierCourant().getPositionCourante().getNomCase());
        position.add(nomTuile);
        panelCentre.add(position);
        
        
        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(3,3));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnAller = new JButton("Aller") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnCarteSpe = new JButton("Carte spéciale") ;
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        this.btnEchangeCarte = new JButton("Echange de carte");
        this.btnRecupTresor = new JButton("Récuperer le trésor");
        
        this.panelBoutons.add(btnAller);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnEchangeCarte);
        this.panelBoutons.add(btnRecupTresor);
        this.panelBoutons.add(btnCarteSpe);
        this.panelBoutons.add(btnTerminerTour);
        
        //On rajoute nos ActionListener sur les boutons de l'IHM
        
        this.btnTerminerTour.addActionListener((ActionEvent e) -> {
            btnAller.setEnabled(true);
            btnAssecher.setEnabled(true);
            btnCarteSpe.setEnabled(true);
            btnEchangeCarte.setEnabled(true);
            btnCarteSpe.setEnabled(true);
            btnRecupTresor.setEnabled(true);
            Message m = new Message();                    
            m.typeMessage = CLIC_BoutonTerminer;
            controleur.traiterMessage(m);

        });
        
        this.btnAller.addActionListener((ActionEvent e) -> {
            Message m = new Message();                    
            m.typeMessage = CLIC_BoutonAller;
            controleur.traiterMessage(m);
          
        });
        
        this.btnAssecher.addActionListener((ActionEvent e) -> {
            Message m = new Message();                    
            m.typeMessage = CLIC_BoutonAssecher;
            controleur.traiterMessage(m);
          
        });
        
        this.btnCarteSpe.addActionListener((ActionEvent e) -> {
            
        });
        
        this.btnEchangeCarte.addActionListener((ActionEvent e) -> {
            Message m = new Message();                    
            m.typeMessage = CLIC_BoutonEchange;
            controleur.traiterMessage(m);
        });
        
        this.btnRecupTresor.addActionListener((ActionEvent e) -> {
            Message m = new Message();                    
            m.typeMessage = CLIC_BoutonRecupTresor;
            controleur.traiterMessage(m);
        });
        
        
        // =================================================================================
        // EST
        
        this.panelCartes = new JPanel(new GridLayout(9,1));
        bigPanel.add(this.panelCartes, BorderLayout.EAST);
        for(int i=0;i<9;i++){
            JPanel panelCarte = new JPanel(new BorderLayout());
            JLabel carte = new JLabel("pas de cartes",SwingConstants.CENTER);
            panelCarte.add(carte ,BorderLayout.CENTER);
            panelCarte.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            panelCartes.add(panelCarte);
            cartesLabels.put(i, carte);
            cartes.put(i, panelCarte);
            
        }
        // =================================================================================
        // OUEST
        JPanel panelOuest = new JPanel(new BorderLayout());
        JLabel titretrésor = new JLabel("Trésors récupérés",SwingConstants.CENTER);
        JPanel titre = new JPanel();
        titre.add(titretrésor);
        panelOuest.add(titre, BorderLayout.NORTH);
        this.panelTresors = new JPanel(new GridLayout(4,1));
        panelOuest.add(panelTresors);
        
        JPanel panelTresor1 = new JPanel(new BorderLayout());
        JLabel nomTresor1 = new JLabel("La Pierre sacrée",SwingConstants.CENTER);
        panelTresor1.add(nomTresor1);
        panelTresor1.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        trésors.put(0, panelTresor1);
        
        JPanel panelTresor2 = new JPanel(new BorderLayout());
        JLabel nomTresor2 = new JLabel("La Statue du zéphyr",SwingConstants.CENTER);
        panelTresor2.add(nomTresor2);
        panelTresor2.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        trésors.put(1, panelTresor2);
        
        JPanel panelTresor3 = new JPanel(new BorderLayout());
        JLabel nomTresor3 = new JLabel("Le Cristal ardent",SwingConstants.CENTER);
        panelTresor3.add(nomTresor3);
        panelTresor3.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        trésors.put(2, panelTresor3);
        
        JPanel panelTresor4 = new JPanel(new BorderLayout());
        JLabel nomTresor4 = new JLabel("Le Calice de l’onde",SwingConstants.CENTER);
        panelTresor4.add(nomTresor4);
        panelTresor4.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        trésors.put(3, panelTresor4);
        
        panelTresors.add(panelTresor1);
        panelTresors.add(panelTresor2);
        panelTresors.add(panelTresor3);
        panelTresors.add(panelTresor4);
        
        tresorsLabels.add(nomTresor1);
        tresorsLabels.add(nomTresor2);
        tresorsLabels.add(nomTresor3);
        tresorsLabels.add(nomTresor4);
        
        bigPanel.add(panelOuest,BorderLayout.WEST);
        // =================================================================================
        
        this.window.setVisible(true);
        mainPanel.repaint();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        grilletuile = new JPanel(new GridLayout(6, 6));
        bigPanel.add(grilletuile,BorderLayout.CENTER);
        
        for (int i=0; i<36; i++) {
             grilletuile.add(createCellule(i, controleur.getGrille()));
        }
    }  


    public void setPosition(String pos) {
        nomTuile.setText(pos);
    }

    public JButton getBtnAller() {
        return btnAller;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }

    public JButton getBtnCarteSpe() {
        return btnCarteSpe;
    }

    public JButton getBtnEchangeCarte() {
        return btnEchangeCarte;
    }

    public JButton getBtnRecupTresor() {
        return btnRecupTresor;
    }
    
    
    
    public void updateAventurier(String nomJ, String noma, Color couleur,String nomT) {
        window.setTitle(nomJ);
        panelAventurier.setBackground(couleur);
        nomAvt.setText(noma);
        nomTuile.setText(nomT);
    }

    public JLabel getNomAvt() {
        return nomAvt;
    }

    public void setNomAvt(JLabel nomAvt) {
        this.nomAvt = nomAvt;
    }
    
    
    public void updateCellules(Grille grilleListe) {
        
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(!tresorsLabels.get(i).getText().equals(controleur.getTrésors().get(j)) && controleur.getTrésors().get(j).getRecupere()){
                    trésors.get(j).setBackground(controleur.getTrésors().get(j).getColor());
                }
            }
        }
        
        for(int i=0;i<cartes.size();i++){
            JPanel carte = cartes.get(i);
            JLabel cartenom = cartesLabels.get(i);
            cartenom.repaint();
            carte.repaint();
        }
        
        for (int i=0; i<36; i++) {
            JPanel panel = cases.get(i);
            JPanel pion = pions.get(i);
            
            if (i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 || i==29|| i==30 || i==31 | i==34 || i==35){
            } else {
                pions.get(i).removeAll();
                
                for(int k=0; k<controleur.getJoueurs().size(); k++){
                    if(labels.get(i).getText() == controleur.getJoueurs().get(k).getPositionCourante().getNomCase()){
                        PionJoueur pionJ = controleur.getJoueurs().get(k).getPionjoueur();
                        pion.add(pionJ);
                        pionJ.repaint();
                    }
                }
                if (grilleListe.getTuilesGrille().get(i).getStatut() == ASSECHEE) {
                       panel.setBackground(Color.DARK_GRAY);
                       pion.setBackground(Color.DARK_GRAY);
                       
                    } else if (grilleListe.getTuilesGrille().get(i).getStatut()== INONDEE) {
                        panel.setBackground(Color.ORANGE);
                        pion.setBackground(Color.ORANGE);
                    
                    } else {
                        panel.setBackground(Color.BLUE);
                        pion.setBackground(Color.BLUE);
                    }
                

                panel.repaint();
            }
        
        }
    }
    
 
    public JPanel createCellule(int i, Grille grilleListe) {

        if(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 || i==29|| i==30 || i==31 | i==34 || i==35) {   
            JPanel panelPion = new JPanel();
            JPanel panelCellule = new JPanel();
            panelCellule.setBackground(Color.BLACK);
            return panelCellule ;
            
        } else {
            
            JPanel panelPion = new JPanel(new FlowLayout());
            JLabel nomCase = new JLabel(grilleListe.tuiles.get(i).getNomCase(), SwingConstants.CENTER);
            nomCase.setForeground(Color.white);
            JPanel panelCellule = new JPanel(new BorderLayout());
            
            panelCellule.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            panelCellule.add(nomCase, BorderLayout.CENTER);
            panelCellule.add(panelPion, BorderLayout.NORTH);
            
            
            if (grilleListe.tuiles.get(i).getStatut() == ASSECHEE) {
                panelCellule.setBackground(Color.DARK_GRAY);
                panelPion.setBackground(Color.DARK_GRAY);
                
            } else if (grilleListe.tuiles.get(i).getStatut() == INONDEE) {
                panelCellule.setBackground(Color.ORANGE);
                panelPion.setBackground(Color.ORANGE);
            } else {
                panelCellule.setBackground(Color.BLUE);
                panelPion.setBackground(Color.BLUE);
            }
            if("Le Temple du Soleil".equals(nomCase.getText()) ||"Le Temple de la Lune".equals(nomCase.getText())){
                JPanel tresor1=new JPanel();
                JLabel nomt1 = new JLabel("La Pierre sacrée");
                tresor1.add(nomt1);
                tresor1.setBackground(Color.GRAY);
                panelCellule.add(tresor1,BorderLayout.SOUTH);
            }
            if("Le Jardin des Murmures".equals(nomCase.getText()) ||"Le Jardin des Hurlements".equals(nomCase.getText())){
                JPanel tresor2=new JPanel();
                JLabel nomt2 = new JLabel("La Statue du zéphyr");
                tresor2.add(nomt2);
                tresor2.setBackground(Color.YELLOW);
                panelCellule.add(tresor2,BorderLayout.SOUTH);
            }
            
            if("La Caverne du Brasier".equals(nomCase.getText()) ||"La Caverne Des Ombres".equals(nomCase.getText())){
                JPanel tresor3=new JPanel();
                JLabel nomt3 = new JLabel("Le Cristal Ardent");
                tresor3.add(nomt3);
                tresor3.setBackground(Color.red);
                panelCellule.add(tresor3,BorderLayout.SOUTH);
            }
            
            if("Le Palais de Corail".equals(nomCase.getText()) ||"Le Palais des Marées".equals(nomCase.getText())){
                JPanel tresor4=new JPanel();
                JLabel nomt4 = new JLabel("Le Calice de l'onde");
                tresor4.add(nomt4);
                tresor4.setBackground(Color.green);
                panelCellule.add(tresor4,BorderLayout.SOUTH);
            }
            
            for(int k=0; k<controleur.getJoueurs().size(); k++){
                
                if(nomCase.getText()==controleur.getJoueurs().get(k).getPositionCourante().getNomCase()){
                    PionJoueur pion = controleur.getJoueurs().get(k).getPionjoueur();
                    panelPion.add(pion);
                    pion.repaint();
                }
            }
            
            
            
            labels.put(i, nomCase);
            pions.put(i, panelPion);
            cases.put(i, panelCellule);
            return panelCellule ;
        }
    }
    
    public JPanel getGrilletuile() {
        return grilletuile;
    }
    
    
    public void carteMainJoueurCourant(){
        
        for(int i=0;i<cartesLabels.size();i++){
            cartesLabels.get(i).setText("pas de cartes");  
        }
        
        for(int i=0;i<controleur.getAventurierCourant().getCarteMain().size();i++){
            String nomCarte =controleur.getAventurierCourant().getCarteMain().get(i).getNomCarte();
            cartesLabels.get(i).setText(nomCarte);
        }
    }

    public HashMap<Integer, JLabel> getCartesLabels() {
        return cartesLabels;
    }
    
    public void afficher(){
        this.window.setVisible(true);
    }
    
    public void ecranGagner(){
        JFrame gagne = new JFrame();
        gagne.setSize(400,100);
        JLabel message = new JLabel("Bravo vous avez gagné, vous êtes un dieu !!");
        gagne.add(message,SwingConstants.CENTER);
        window.setVisible(false);
        gagne.setVisible(true);
        gagne.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
    }

}
