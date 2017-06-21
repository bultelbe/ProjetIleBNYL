package Vues;

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
import projetilebnyl.Observateur;

 
public class VueAventurier  {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JPanel bigPanel;
    private final JPanel panelCartes;
    public final JButton btnAller  ;
    public final JButton btnAssecher;
    public final JButton btnCarteSpe;
    public final JButton btnTerminerTour;       
    public final JButton btnEchangeCarte;
    public final JButton btnRecupTresor;
    private final JPanel position;
    private final JPanel grilletuile;
    
    private JLabel nomAvt;
    private JLabel nomTuile;
    private Observateur controleur;
    private HashMap<Integer,JPanel> cases=new HashMap();
    private HashMap<Integer,JPanel> pions=new HashMap();
    private HashMap<Integer,JPanel> cartes=new HashMap();
    private HashMap<Integer,JLabel> labels=new HashMap();
    private HashMap<Integer,JLabel> cartesLabels=new HashMap();
    private JButton [] boutonsTuiles;
    
    
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
            controleur.traiterMessage(CLIC_BoutonTerminer);

        });
        
        this.btnAller.addActionListener((ActionEvent e) -> {
           
            controleur.traiterMessage(CLIC_BoutonAller);
          
        });
        
        this.btnAssecher.addActionListener((ActionEvent e) -> {
        
            controleur.traiterMessage(CLIC_BoutonAssecher);
          
        });
        
        this.btnCarteSpe.addActionListener((ActionEvent e) -> {});
        
        this.btnEchangeCarte.addActionListener((ActionEvent e) -> {});
        
        this.btnRecupTresor.addActionListener((ActionEvent e) -> {});
        
        
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
        
        this.window.setVisible(true);
        mainPanel.repaint();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        grilletuile = new JPanel(new GridLayout(6, 6));
        bigPanel.add(grilletuile,BorderLayout.CENTER);
        
        for (int i=0; i<36; i++) {
            
             grilletuile.add(createCellule(i, controleur.getGrille()));
        }
    }  

     public JButton getBtnCarteSpe() {
        return btnCarteSpe;
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
                
                for(int k=0; k<6; k++){
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
            
            
            /*boutonsTuiles = new JButton[36];
            if (controleur.getGrille().getTuilesGrille().get(i).getStatut() != null || controleur.getGrille().getTuilesGrille().get(i).getStatut() != COULEE) {
                boutonsTuiles[i] = new JButton();
                
                boutonsTuiles[i].add(nomCase);
                panelCellule.add(boutonsTuiles[i]);
            }*/
            
            
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
            
            for(int k=0; k<6; k++){
                
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
    
    
}
