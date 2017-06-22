/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Aventurier.Aventurier;
import Grille.Tuile;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.*;
import projetilebnyl.Controleur;
import static projetilebnyl.Message.CLIC_BoutonValider;
import static java.lang.Integer.parseInt;

/**
 *
 * @author thorey
 */
public class VueDeplacement {
    private JFrame window;
    private JPanel mainPanel;
    private JPanel grillePanel;
    private JPanel areaPanel;
    private JTextArea coordonee;
    private JTextField textX;
    private JTextField textY;
    private JButton valider;
    private JPanel southPanel;
    private JLabel seDeplacer;
    private JLabel X;
    private JLabel Y;
    private Controleur c;
    private Integer x;
    private Integer y;
    /**
     * @param args the command line arguments
     */
    

    public VueDeplacement(Controleur c,Aventurier aventurier) {
        this.c = c;
        this.window = new JFrame();
        window.setSize(600, 450); 
        window.setTitle("Deplacement de "+aventurier.getNomJ()+" : "+aventurier.getNoma());
        
        mainPanel = new JPanel(new BorderLayout());
        grillePanel = new JPanel(new GridLayout(6,6));
        southPanel = new JPanel();

        
        seDeplacer= new JLabel(aventurier.getNoma() + " veuillez rentrer les coordonnées de la tuile où vous souhaitez vous déplacez" +"\n" );        
        valider = new JButton("Valider"); 
        X = new JLabel("X : ");
        Y = new JLabel("Y : ");
        
        textX = new JTextField();
        textY = new JTextField();
        
        grillePanel.add(new JLabel());
        
        for (int i = 0; i < 36; i++) {
            if (i == 8) {
                //grillePanel.add(X, SwingConstants.CENTER);
                grillePanel.add(new JLabel("X : ", SwingConstants.CENTER));
            } else if (i == 9) {
                grillePanel.add(textX);
                
            } else if (i == 22) {
                //grillePanel.add(Y, SwingConstants.CENTER);
                grillePanel.add(new JLabel("Y : ", SwingConstants.CENTER));
                
            } else if (i == 23) {
                grillePanel.add(textY);
            
            } else {
                grillePanel.add(new JLabel(" "));
            }
        }
        
        coordonee = new JTextArea(24,1);
        //JScrollPane scroll = new JScrollPane(coordonee);
        coordonee.setEditable(false);
        
        for (Tuile t : aventurier.deplacementsPossibles(c.getGrille())){
            coordonee.append(t.getNomCase() + " (" + t.getColonne() +','+ t.getLigne() + ") " + t.getStatut() + "\n");
        }
        
        areaPanel = new JPanel(new BorderLayout());
        //areaPanel.add(scroll,BorderLayout.EAST);
        areaPanel.add(coordonee,BorderLayout.CENTER);        
        
        southPanel.add(valider, SwingConstants.CENTER);
        mainPanel.add(areaPanel,BorderLayout.EAST);
        mainPanel.add(grillePanel, BorderLayout.CENTER);
        mainPanel.add(seDeplacer, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
//        window.setLocationRelativeTo(null);
        
        window.add(mainPanel);
        
        this.window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        
        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x = getX();
                y = getY();
                c.traiterMessage(CLIC_BoutonValider);
                window.setVisible(false); 
                window.dispose();
            }
        });
    }
    
    public void afficher() {
        this.window.setVisible(true);
    }
    
    public int getX() {
        return parseInt(textX.getText());
    }
    
    public int getY() {
        return parseInt(textY.getText());
    }
        
}
