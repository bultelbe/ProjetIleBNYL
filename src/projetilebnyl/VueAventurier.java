package projetilebnyl;

import Grille.Grille;
import java.awt.BorderLayout;
import java.awt.Color;

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
import static projetilebnyl.Message.*;
import projetilebnyl.Utils.*;

 
public class VueAventurier  {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JPanel bigPanel;
    public final JButton btnAller  ;
    public final JButton btnAssecher;
    public final JButton btnAutreAction;
    public final JButton btnTerminerTour;       

    private final JPanel position;
    private final JPanel grilletuile;
    
    private JLabel nomAvt;
    private JLabel nomTuile;
    private Observateur controleur;
    private HashMap<Integer,JPanel> cases=new HashMap();
    
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
            btnAller.setEnabled(false);
            btnAssecher.setEnabled(false);
            btnAutreAction.setEnabled(false);
            controleur.traiterMessage(CLIC_BoutonAller);
            btnAller.setEnabled(true);
            btnAssecher.setEnabled(true);
            btnAutreAction.setEnabled(true);
        });
        
        this.btnAssecher.addActionListener((ActionEvent e) -> {
            btnAller.setEnabled(false);
            btnAssecher.setEnabled(false);
            btnAutreAction.setEnabled(false);
            controleur.traiterMessage(CLIC_BoutonAssecher);
            btnAller.setEnabled(true);
            btnAssecher.setEnabled(true);
            btnAutreAction.setEnabled(true);
        });
        
        this.btnAutreAction.addActionListener((ActionEvent e) -> {});
        
        

        this.window.setVisible(true);
        mainPanel.repaint();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

        grilletuile = new JPanel(new GridLayout(6, 6));
        bigPanel.add(grilletuile,BorderLayout.CENTER);
        
        for (int i=0; i<36; i++) {
            
             grilletuile.add(createCellule(i,controleur.getGrille()));
             
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
    
    
    public void updateCellules(Grille grilleListe) {
        
        for (int i=0; i<36; i++) {

            JPanel panel = cases.get(i);
            if(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 || i==29|| i==30 || i==31 | i==34 || i==35){
            }else{
                if ( grilleListe.getGrille().get(i).getStatut()== EtatTuile.ASSECHEE) {
                       panel.setBackground(Color.DARK_GRAY);

                    } else if (grilleListe.getGrille().get(i).getStatut()== EtatTuile.INONDEE) {
                        panel.setBackground(Color.ORANGE);

                    } else {
                        panel.setBackground(Color.BLUE);
                    }

                panel.repaint();
                }
        
        }    
    }
        
 
    public JPanel createCellule(int i,Grille grilleListe) {

        if(i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 || i==29|| i==30 || i==31 | i==34 || i==35){   
            JPanel panelCellule = new JPanel();
            panelCellule.setBackground(Color.BLACK);
            return panelCellule ;
            
        } else {    
            JLabel nomCase = new JLabel(grilleListe.tuiles.get(i).getNomCase());
            nomCase.setForeground(Color.white);
            JPanel panelCellule = new JPanel();
            panelCellule.setBorder(BorderFactory.createLineBorder(Color.white, 1));
            panelCellule.add(nomCase);
            
            if (grilleListe.tuiles.get(i).getStatut() == EtatTuile.ASSECHEE) {
                panelCellule.setBackground(Color.DARK_GRAY);
                
            } else if (grilleListe.tuiles.get(i).getStatut()==EtatTuile.INONDEE) {
                panelCellule.setBackground(Color.ORANGE);
                
            } else {
                panelCellule.setBackground(Color.BLUE);
            }
            cases.put(i, panelCellule);
           /* panelCellule.addMouseListener(new MouseListener() {
                
                @Override
                public void mouseClicked(MouseEvent e) {
                    
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });*/
            
            return panelCellule ;
        }
    }
    

    public JPanel getGrilletuile() {
        return grilletuile;
    }
    
}
