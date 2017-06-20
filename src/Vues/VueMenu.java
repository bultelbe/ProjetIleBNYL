/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import projetilebnyl.Controleur;

/**
 *
 * @author schmuckl
 */
public class VueMenu {
    
    private JButton demarrer;
    private JButton quitter;
    private JComboBox nbrJoueurs;
    private JFrame window;
    private JLabel nbr;
    private JPanel panelBoutons;
    
    public VueMenu() {
        
        this.window = new JFrame();
        window.setSize(400, 200);
        
        window.setTitle("Menu");
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel panelCentre = new JPanel(new GridLayout(4, 4));

        demarrer = new JButton("Démarrer");
        quitter = new JButton("Quitter");
        
        panelBoutons = new JPanel(new BorderLayout());
        panelBoutons.add(demarrer, BorderLayout.EAST);
        panelBoutons.add(quitter, BorderLayout.WEST);
        
        nbrJoueurs = new JComboBox();
        nbrJoueurs.addItem("1");
        nbrJoueurs.addItem("2");
        nbrJoueurs.addItem("3");
        nbrJoueurs.addItem("4");
        
        JLabel nbr = new JLabel("Choix du nombre de joueurs", SwingConstants.CENTER);
        
        int count = 0;
        
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                JPanel panel = new JPanel();
                panel.setLayout(new BorderLayout());
                
                if (count == 5) panel.add(new JLabel("Joueurs :"), BorderLayout.CENTER);
                if (count == 6) panel.add(nbrJoueurs, BorderLayout.CENTER);
                
                panelCentre.add(panel);
                count++;
            }
        }
        
        mainPanel.add(nbr, BorderLayout.NORTH);
        mainPanel.add(panelBoutons, BorderLayout.SOUTH);
        mainPanel.add(panelCentre, BorderLayout.CENTER);
        window.add(mainPanel);
        
        quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        demarrer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        window.setLocationRelativeTo(null);
        this.window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String [] args) {
        VueMenu vue = new VueMenu();
    }
}