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
import javax.swing.*;
import projetilebnyl.Controleur;
import static projetilebnyl.Message.TypeMessage.*;
import static java.lang.Integer.parseInt;
import projetilebnyl.Message;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;

/**
 *
 * @author thorey
 */
public class VueDeplacement {
    
    //Déclaration de la fênetre et de ses composants
    private JFrame window;
    private JPanel mainPanel;
    private JPanel grillePanel;
    private JPanel areaPanel;
    private JPanel southPanel;
    
    //Déclaration de la zone servant à afficher les coordonnées
    private JTextArea coordonee;
    
    //Déclaration de la partie d'entrée des coordonées
    private JTextField textX;
    private JTextField textY;
    private JLabel X;
    private JLabel Y;
    
    //Déclaration du bouton valider
    private JButton valider;
    
    //Déclaration du label indiquant le déplacement de qui
    private JLabel seDeplacer;
    
    private Controleur c;
    private Aventurier aventurier;
    private Integer x;
    private Integer y;
    
    
    /**
     * @param c
     * @param aventurier
     */
    

    public VueDeplacement(Controleur c,Aventurier aventurier) {
        this.aventurier=aventurier;
        this.c = c;
        
        //Définition de la fenêtre
        this.window = new JFrame();
        window.setSize(600, 450); 
        window.setTitle("Deplacement de "+aventurier.getNomJ()+" : "+aventurier.getNoma());
        
        //Définition des panels
        mainPanel = new JPanel(new BorderLayout());
        grillePanel = new JPanel(new GridLayout(6,6));
        southPanel = new JPanel();
        areaPanel = new JPanel(new BorderLayout());
        
        //Définitions des composants
        coordonee = new JTextArea(22,1);
        coordonee.setEditable(false);        
        seDeplacer= new JLabel(aventurier.getNoma() + " veuillez rentrer les coordonnées de la tuile où vous souhaitez vous déplacez" +"\n" );        
        valider = new JButton("Valider"); 
        X = new JLabel("X : ");
        Y = new JLabel("Y : ");        
        textX = new JTextField();
        textY = new JTextField();
        
        //Ajout des label X,Y et des texFields correspondants
        grillePanel.add(new JLabel());
        for (int i = 0; i < 36; i++) {
            switch (i) {
                case 8:
                    grillePanel.add(new JLabel("X : ", SwingConstants.CENTER));
                    break;
                case 9:
                    grillePanel.add(textX);
                    break;
                case 22:
                    grillePanel.add(new JLabel("Y : ", SwingConstants.CENTER));
                    break;
                case 23:
                    grillePanel.add(textY);
                    break;
                default:
                    grillePanel.add(new JLabel());
                    break;
            }
        }
        
        //Affichage des tuiles, leurs coordonnées et leurs statuts, sur lesquelles l'aventurier courant peut se déplacer
        for (Tuile t : aventurier.deplacementsPossibles(c.getGrille())){
            coordonee.append(t.getNomCase() + " (" + t.getColonne() +','+ t.getLigne() + ") " + t.getStatut() + "\n");
        }
        
        valider.addActionListener((ActionEvent e) -> {
            //Récupère les coordonnées x,y entrées par l'utilisateur
            x = getX();
            y = getY();
            
            //Création d'un message avec les coordonnées et envoie au controleur
            Message m = new Message();
            m.avt = getAventurier();
            m.typeMessage = CLIC_BoutonValider;
            c.traiterMessage(m);
            window.setVisible(false);

        });
        
        //Ajout des panels à la fenêtre
        areaPanel.add(coordonee,BorderLayout.CENTER);  
        southPanel.add(valider, SwingConstants.CENTER);
        mainPanel.add(areaPanel,BorderLayout.EAST);
        mainPanel.add(grillePanel, BorderLayout.CENTER);
        mainPanel.add(seDeplacer, BorderLayout.NORTH);
        mainPanel.add(southPanel, BorderLayout.SOUTH);        
        window.add(mainPanel);
        
        this.window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    public void afficher() {
        //Affiche la fenêtre
        this.window.setVisible(true);
    }
    
    public int getX() {
        return parseInt(textX.getText());
    }
    
    public int getY() {
        return parseInt(textY.getText());
    }

    public Aventurier getAventurier() {
        return aventurier;
    }
        
}
