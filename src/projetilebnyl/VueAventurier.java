package projetilebnyl;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import static projetilebnyl.Message.*;
import projetilebnyl.Utils.*;

 
public class VueAventurier  {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window,grille;
    private final JPanel panelAventurier;
    private JPanel mainPanel;
    public final JButton btnAller  ;
    public final JButton btnAssecher;
    public final JButton btnAutreAction;
    public final JButton btnTerminerTour;
    private final JPanel position;
    
    
    private JLabel nomAvt;
    private JLabel nomTuile;
    private Observateur controleur;
    
    
    public VueAventurier (String nomJoueur, String nomAventurier, Color couleur, Observateur ctrl) {

        this.controleur = ctrl;
        
        this.window = new JFrame();
        window.setSize(350, 200);

        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

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
        nomTuile= new JLabel(controleur.getAventurierCourant().getPositionCourante().getNomCase());
        position.add(nomTuile);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnAller = new JButton("Aller") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnAutreAction = new JButton("AutreAction") ;
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        
        this.panelBoutons.add(btnAller);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);
        
        //On rajoute nos ActionListener sur les boutons de l'IHM
        
        this.btnTerminerTour.addActionListener((ActionEvent e) -> {
            btnAller.setEnabled(true);
            btnAssecher.setEnabled(true);
            btnAutreAction.setEnabled(true);
            controleur.traiterMessage(CLIC_BoutonTerminer);

        });
        
        this.btnAller.addActionListener((ActionEvent e) -> {
          
            controleur.traiterMessage(CLIC_BoutonAller);
           
        });
        
        this.btnAssecher.addActionListener((ActionEvent e) -> {
            
            controleur.traiterMessage(CLIC_BoutonAssecher);
        
        });
        
        this.btnAutreAction.addActionListener((ActionEvent e) -> {});
        
        

        this.window.setVisible(true);
        mainPanel.repaint();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        
        this.grille = new JFrame();
        grille.setSize(1000, 1000);
        this.grille.setVisible(true);
        grille.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        // Définit la taille de la fenêtre en pixels
       
        
        JPanel grilletuile = new JPanel(new GridLayout(6, 6));
        grille.add(grilletuile, BorderLayout.CENTER);
        
        for (int i=0; i<36; i++) {
            
             grilletuile.add(getCellule(i));
        }
    }  

     public JButton getBtnAutreAction() {
        return btnAutreAction;
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
    
    
    
 
    private JPanel getCellule(int i) {
        int numLigne = (int) (i+5)/6 ;
        int numCouleur = (i-numLigne) % 4 + 1;
        Grille grilleListe = new Grille();
        if(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 || i==29|| i==30 || i==31 | i==34 || i==35){   
            JPanel panelCellule = new JPanel();
            panelCellule.setBackground(Color.BLACK);
            return panelCellule ;
        }  else{    
            JLabel nomCase = new JLabel(grilleListe.tuiles.get(i).getNomCase());
            nomCase.setForeground(Color.white);
            JPanel panelCellule = new JPanel();
            panelCellule.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            panelCellule.add(nomCase);
            
            if(grilleListe.tuiles.get(i).getStatut()==EtatTuile.ASSECHEE){
                panelCellule.setBackground(Color.DARK_GRAY);
            }else if(grilleListe.tuiles.get(i).getStatut()==EtatTuile.INONDEE){
                panelCellule.setBackground(Color.ORANGE);
            } else{
                panelCellule.setBackground(Color.BLUE);
            }
            
            return panelCellule ;
        }
        
        
    }
}
