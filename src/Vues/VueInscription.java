/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 *
 * @author thorey
 */
public class VueInscription {

    /**
     * @param args the command line arguments
     */
    
    private JFrame window;
    private JPanel grillePanel;
    private JPanel mainPanel;
    private JPanel grilleAventurierPanel;
    private JPanel radioDifPanel;
    private JComboBox choixAventurier1;
    private JComboBox choixAventurier2;
    private JComboBox choixAventurier3;
    private JComboBox choixAventurier4;
    private JRadioButton buttonNovice;
    private JRadioButton buttonNormal;
    private JRadioButton buttonElite;
    private JRadioButton buttonLegendaire;
    private ButtonGroup groupDifficulte;
    private JButton demarrer;
    private JButton quitter;
    private JLabel parametre;
    private JPanel boutonPanel;
    
    private HashMap<Integer, JRadioButton> ensembleDesBoutonsRadios;
    
    public VueInscription (){
        this.window = new JFrame();
        window.setSize(600, 270); 
        window.setTitle("L'Île interdite");
        
        mainPanel = new JPanel(new BorderLayout());
        grillePanel = new JPanel(new GridLayout(2,1));
        grilleAventurierPanel = new JPanel(new GridLayout(6,5));
        
        choixAventurier1 = new JComboBox();        
        choixAventurier1.addItem("Explorateur");
        choixAventurier1.addItem("Navigateur");
        choixAventurier1.addItem("Messager");
        choixAventurier1.addItem("Ingénieur");
        choixAventurier1.addItem("Plongeur");
        choixAventurier1.addItem("Pilote");
        
        choixAventurier2 = new JComboBox();        
        choixAventurier2.addItem("Explorateur");
        choixAventurier2.addItem("Navigateur");
        choixAventurier2.addItem("Messager");
        choixAventurier2.addItem("Ingénieur");
        choixAventurier2.addItem("Plongeur");
        choixAventurier2.addItem("Pilote");
        
        choixAventurier3 = new JComboBox();        
        choixAventurier3.addItem("Explorateur");
        choixAventurier3.addItem("Navigateur");
        choixAventurier3.addItem("Messager");
        choixAventurier3.addItem("Ingénieur");
        choixAventurier3.addItem("Plongeur");
        choixAventurier3.addItem("Pilote");
        
        choixAventurier4 = new JComboBox();        
        choixAventurier4.addItem("Explorateur");
        choixAventurier4.addItem("Navigateur");
        choixAventurier4.addItem("Messager");
        choixAventurier4.addItem("Ingénieur");
        choixAventurier4.addItem("Plongeur");
        choixAventurier4.addItem("Pilote");
        
               
        for (int i=1; i<=30; i++) {
            
            if (i == 7){
                grilleAventurierPanel.add(new JLabel("JOUEUR 1 : ", SwingConstants.CENTER));
            } else if (i == 12) {
                grilleAventurierPanel.add(new JLabel("JOUEUR 2 : ", SwingConstants.CENTER));
            } else if (i == 17) {
                grilleAventurierPanel.add(new JLabel("JOUEUR 3 : ", SwingConstants.CENTER));
            } else if (i == 22) {
                grilleAventurierPanel.add(new JLabel("JOUEUR 4 : ", SwingConstants.CENTER));
                
            } else if (i == 8) {
                JTextField champJoueur1 = new JTextField();
                grilleAventurierPanel.add(champJoueur1);
            } else if (i == 13) {
                JTextField champJoueur2 = new JTextField();
                grilleAventurierPanel.add(champJoueur2);
            } else if (i == 18) {
                JTextField champJoueur3 = new JTextField();
                grilleAventurierPanel.add(champJoueur3);
            } else if (i == 23) {
                JTextField champJoueur4 = new JTextField();
                grilleAventurierPanel.add(champJoueur4);
                
            } else if (i == 9){
                grilleAventurierPanel.add(choixAventurier1);
            } else if (i == 14){
                grilleAventurierPanel.add(choixAventurier2);
            } else if (i == 19){
                grilleAventurierPanel.add(choixAventurier3);
            } else if (i == 24){
                grilleAventurierPanel.add(choixAventurier4);
                
            } else {
                grilleAventurierPanel.add(new JLabel());
            }
        }
        
        
    
        groupDifficulte = new ButtonGroup();
        ensembleDesBoutonsRadios = new HashMap<>();
        
        
        radioDifPanel = new JPanel(new GridLayout(5,2));
        
        
        for (int i=1; i<=8; i++) {
            if (i == 1){
                radioDifPanel.add(new JLabel("Choix du niveau de jeu : ", SwingConstants.CENTER));
            } else if (i == 2){
                buttonNovice = new JRadioButton("Novice");
                radioDifPanel.add(buttonNovice);
                groupDifficulte.add(buttonNovice);
                ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonNovice);
            } else if (i == 4){
                buttonNormal = new JRadioButton("Normal");
                radioDifPanel.add(buttonNormal);
                groupDifficulte.add(buttonNormal);
                ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonNormal);
            } else if (i == 6){
                buttonElite = new JRadioButton("Elite");
                radioDifPanel.add(buttonElite);
                groupDifficulte.add(buttonElite);
                ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonElite);
            } else if (i == 8){
                buttonLegendaire = new JRadioButton("Legendaire");
                radioDifPanel.add(buttonLegendaire);
                groupDifficulte.add(buttonLegendaire);          
                ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonLegendaire);
            } else {
                radioDifPanel.add(new JLabel());
            }
        }
        
        boutonPanel = new JPanel(new BorderLayout());
        demarrer = new JButton("Démarrer");
        quitter = new JButton("Quitter");
        
        boutonPanel.add(demarrer, BorderLayout.EAST);
        boutonPanel.add(quitter, BorderLayout.WEST);
        
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
        
        ensembleDesBoutonsRadios.get(1).setSelected(true);        
        
        //grilleAventurierPanel.setBackground(Color.BLUE);
        grillePanel.add(grilleAventurierPanel);
        
        //radioDifPanel.setBackground(Color.red);
        grillePanel.add(radioDifPanel);
        
        parametre = new JLabel("Paramètrage de la partie : ", SwingConstants.CENTER);
        
        mainPanel.add(grillePanel, BorderLayout.CENTER);
        mainPanel.add(boutonPanel,BorderLayout.SOUTH);
        mainPanel.add(parametre, BorderLayout.NORTH);
        
        
        window.add(mainPanel);
        
        
        
        
        this.window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    
    
    public void afficher(){
        this.window.setVisible(true);
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        VueInscription V1 = new VueInscription();
        V1.afficher();
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

