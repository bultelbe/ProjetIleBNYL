/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

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
    

    public VueDeplacement(Controleur c) {
        this.c = c;
        this.window = new JFrame();
        window.setSize(450, 250); 
        window.setTitle("Deplacement");
        
        mainPanel = new JPanel(new BorderLayout());
        grillePanel = new JPanel(new GridLayout(4,4));
        southPanel = new JPanel();
        
        seDeplacer= new JLabel("Coordonnées de la tuile où vous souhaitez vous déplacez");        
        valider = new JButton("Valider"); 
        X = new JLabel("X : ");
        Y = new JLabel("Y : ");
        
        textX = new JTextField();
        textY = new JTextField();
        
        grillePanel.add(new JLabel());
        
        for (int i = 0; i < 16; i++) {
            if (i == 5) {
                //grillePanel.add(X, SwingConstants.CENTER);
                grillePanel.add(new JLabel("X : ", SwingConstants.CENTER));
            } else if (i == 6) {
                grillePanel.add(textX);
                
            } else if (i == 10) {
                //grillePanel.add(Y, SwingConstants.CENTER);
                grillePanel.add(new JLabel("Y : ", SwingConstants.CENTER));
                
            } else if (i == 11) {
                grillePanel.add(textY);
            
            } else {
                grillePanel.add(new JLabel());
            }
        }
        
        
        
        southPanel.add(valider, SwingConstants.CENTER);
        
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
