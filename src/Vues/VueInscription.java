/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import projetilebnyl.Controleur;
import projetilebnyl.Message;
import static projetilebnyl.Message.TypeMessage.CLIC_BoutonDemarrer;

/**
 *
 * @author thorey
 */
public class VueInscription {

    /**
     * @param args the command line arguments
     */
    
    //Déclaration de la fênetre et de ses composants
    private JFrame window;
    private JPanel grillePanel;
    private JPanel mainPanel;
    private JPanel grilleAventurierPanel;
    private JPanel radioDifPanel;
    private JPanel boutonPanel;
    
    //Déclaration des champs d'entrée joueur 
    private JTextField champJoueur1;
    private JTextField champJoueur2;
    private JTextField champJoueur3;
    private JTextField champJoueur4;
    private String nomJoueur1;
    private String nomJoueur2;
    private String nomJoueur3;
    private String nomJoueur4;
    private ArrayList<String> nomsJoueurs = new ArrayList();
    
    //Déclaration des boutons
    private JButton demarrer;
    private JButton quitter;
    
    //Déclaration des radios boutons
    private JRadioButton buttonNovice;
    private JRadioButton buttonNormal;
    private JRadioButton buttonElite;
    private JRadioButton buttonLegendaire;
    private ButtonGroup groupDifficulte;
    private HashMap<Integer, JRadioButton> ensembleDesBoutonsRadios;
    
    //Déclaration des comboBox et de leurs composants
    private JComboBox choixAventurier1;    
    private JComboBox choixAventurier2;
    private JComboBox choixAventurier3;
    private JComboBox choixAventurier4;    
    private String[] aventurier;   
    private String nomA1;
    private String nomA2;
    private String nomA3;
    private String nomA4;    
    private ArrayList<String> nomsAventuriers = new ArrayList(); 
    
    //Déclaration libelle
    private JLabel parametre;
    
    private int nbrJoueurs = 0;
    private int niveauEau = 0;
    private Controleur c; 
    
    
    
    public VueInscription (Controleur c){
        this.c = c;
        
        //Définition de la fenêtre
        this.window = new JFrame();
        window.setSize(600, 340); 
        window.setTitle("L'Île interdite");
        
        //Paramétrage de différents panels, label et boutons
        mainPanel = new JPanel(new BorderLayout());
        grillePanel = new JPanel(new GridLayout(2,1));
        grilleAventurierPanel = new JPanel(new GridLayout(6,5));
        boutonPanel = new JPanel(new BorderLayout());
        groupDifficulte = new ButtonGroup();
        ensembleDesBoutonsRadios = new HashMap<>();
        radioDifPanel = new JPanel(new GridLayout(5,2));
        parametre = new JLabel("Paramètrage de la partie : ", SwingConstants.CENTER);
        demarrer = new JButton("Démarrer");
        quitter = new JButton("Quitter");
        
        //Paramétrage des comboBox
        aventurier = new String[]{"Explorateur","Navigateur","Messager","Ingénieur","Plongeur","Pilote"};
        choixAventurier1 = new JComboBox(aventurier);
        choixAventurier2 = new JComboBox(aventurier);
        choixAventurier3 = new JComboBox(aventurier);
        choixAventurier4 = new JComboBox(aventurier);
        
        //Ajout des labels joueurs, des champs d'entrées de noms joueurs et des comboBox de choix d'aventurier
        for (int i=1; i<=30; i++) {
            
            switch (i) {
                case 7:
                    grilleAventurierPanel.add(new JLabel("JOUEUR 1 : ", SwingConstants.CENTER));
                    break;
                case 12:
                    grilleAventurierPanel.add(new JLabel("JOUEUR 2 : ", SwingConstants.CENTER));
                    break;
                case 17:
                    grilleAventurierPanel.add(new JLabel("JOUEUR 3 : ", SwingConstants.CENTER));
                    break;
                case 22:
                    grilleAventurierPanel.add(new JLabel("JOUEUR 4 : ", SwingConstants.CENTER));
                    break;
                case 8:
                    champJoueur1 = new JTextField();
                    grilleAventurierPanel.add(champJoueur1);
                    break;
                case 13:
                    champJoueur2 = new JTextField();
                    grilleAventurierPanel.add(champJoueur2);
                    break;
                case 18:
                    champJoueur3 = new JTextField();
                    grilleAventurierPanel.add(champJoueur3);
                    break;
                case 23:
                    champJoueur4 = new JTextField();
                    grilleAventurierPanel.add(champJoueur4);
                    break;
                case 9:
                    grilleAventurierPanel.add(choixAventurier1);
                    break;
                case 14:
                    grilleAventurierPanel.add(choixAventurier2);
                    break;
                case 19:
                    grilleAventurierPanel.add(choixAventurier3);
                    break;
                case 24:
                    grilleAventurierPanel.add(choixAventurier4);
                    break;
                default:
                    grilleAventurierPanel.add(new JLabel());
                    break;
            }
        }
        
        //Option par défaut :
        //Explorateur
        choixAventurier1.setSelectedIndex(0);
        //Navigateur
        choixAventurier2.setSelectedIndex(1);
        //Messager
        choixAventurier3.setSelectedIndex(2);
        //Ingénieur
        choixAventurier4.setSelectedIndex(3);
        
        //Ajout des radioBoutons de difficulté 
        for (int i=1; i<=8; i++) {
            switch (i) {
                case 1:
                    radioDifPanel.add(new JLabel("Choix du niveau de jeu : ", SwingConstants.CENTER));
                    break;
                case 2:
                    buttonNovice = new JRadioButton("Novice");
                    radioDifPanel.add(buttonNovice);
                    groupDifficulte.add(buttonNovice);
                    ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonNovice);
                    break;
                case 4:
                    buttonNormal = new JRadioButton("Normal");
                    radioDifPanel.add(buttonNormal);
                    groupDifficulte.add(buttonNormal);
                    ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonNormal);
                    break;
                case 6:
                    buttonElite = new JRadioButton("Elite");
                    radioDifPanel.add(buttonElite);
                    groupDifficulte.add(buttonElite);
                    ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonElite);
                    break;
                case 8:
                    buttonLegendaire = new JRadioButton("Legendaire");
                    radioDifPanel.add(buttonLegendaire);
                    groupDifficulte.add(buttonLegendaire);
                    ensembleDesBoutonsRadios.put(ensembleDesBoutonsRadios.size(), buttonLegendaire);
                    break;
                default:
                    radioDifPanel.add(new JLabel());
                    break;
            }
        }
        
        quitter.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        demarrer.addActionListener((ActionEvent e) -> {
            
            //Récupération des noms entrées par l'utilisateur
            nomJoueur1 = champJoueur1.getText();
            nomJoueur2 = champJoueur2.getText();
            nomJoueur3 = champJoueur3.getText();
            nomJoueur4 = champJoueur4.getText();
            
            //Récupération des choix d'aventurier
            nomA1 = aventurier[choixAventurier1.getSelectedIndex()];
            nomA2 = aventurier[choixAventurier2.getSelectedIndex()];
            nomA3 = aventurier[choixAventurier3.getSelectedIndex()];
            nomA4 = aventurier[choixAventurier4.getSelectedIndex()];
            
            //Vérification que les noms entrées ne sont pas vide: 
            //s'ils ne sont pas vide on incrémente de le nombre de joueurs et on ajoute le nom joueur à la liste des noms joueurs
            if (!champVide(nomJoueur1)){
                nbrJoueurs = nbrJoueurs+1;
                nomsAventuriers.add(nomA1);
                nomsJoueurs.add(nomJoueur1);
            }            
            if (!champVide(nomJoueur2)){
                nbrJoueurs = nbrJoueurs+1;
                nomsAventuriers.add(nomA2);
                nomsJoueurs.add(nomJoueur2);
            }            
            if (!champVide(nomJoueur3)){
                nbrJoueurs = nbrJoueurs+1;
                nomsAventuriers.add(nomA3);
                nomsJoueurs.add(nomJoueur3);
            }            
            if (!champVide(nomJoueur4)){
                nbrJoueurs = nbrJoueurs+1;
                nomsAventuriers.add(nomA4);
                nomsJoueurs.add(nomJoueur4);
            }
            
            
            //Vérification qu'un aventurier n'est pas été choisie 2 fois ou plus, sinon il y a envoie d'un message 
            //et le jeu nécessite un rédémarage            
            if("Explorateur".equals(nomA1) && ("Explorateur".equals(nomA2)||"Explorateur".equals(nomA3)||"Explorateur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Explorateur".equals(nomA2) && ("Explorateur".equals(nomA1)||"Explorateur".equals(nomA3)||"Explorateur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Explorateur".equals(nomA3) && ("Explorateur".equals(nomA1)||"Explorateur".equals(nomA2)||"Explorateur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Explorateur".equals(nomA4) && ("Explorateur".equals(nomA1)||"Explorateur".equals(nomA3)||"Explorateur".equals(nomA2))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
                
            } else if("Navigateur".equals(nomA1) && ("Navigateur".equals(nomA2)||"Navigateur".equals(nomA3)||"Navigateur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Navigateur".equals(nomA2) && ("Navigateur".equals(nomA1)||"Navigateur".equals(nomA3)||"Navigateur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Navigateur".equals(nomA3) && ("Navigateur".equals(nomA1)||"Navigateur".equals(nomA2)||"Navigateur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Navigateur".equals(nomA4) && ("Navigateur".equals(nomA1)||"Navigateur".equals(nomA3)||"Navigateur".equals(nomA2))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
                
            } else if("Messager".equals(nomA1) && ("Messager".equals(nomA2)||"Messager".equals(nomA3)||"Messager".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Messager".equals(nomA2) && ("Messager".equals(nomA1)||"Messager".equals(nomA3)||"Messager".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Messager".equals(nomA3) && ("Messager".equals(nomA1)||"Messager".equals(nomA2)||"Messager".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Messager".equals(nomA4) && ("Messager".equals(nomA1)||"Messager".equals(nomA3)||"Messager".equals(nomA2))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
                
            } else if("Ingénieur".equals(nomA1) && ("Ingénieur".equals(nomA2)||"Ingénieur".equals(nomA3)||"Ingénieur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Ingénieur".equals(nomA2) && ("Ingénieur".equals(nomA1)||"Ingénieur".equals(nomA3)||"Ingénieur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Ingénieur".equals(nomA3) && ("Ingénieur".equals(nomA1)||"Ingénieur".equals(nomA2)||"Ingénieur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Ingénieur".equals(nomA4) && ("Ingénieur".equals(nomA1)||"Ingénieur".equals(nomA3)||"Ingénieur".equals(nomA2))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
                
            } else if("Plongeur".equals(nomA1) && ("Plongeur".equals(nomA2)||"Plongeur".equals(nomA3)||"Plongeur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Plongeur".equals(nomA2) && ("Plongeur".equals(nomA1)||"Plongeur".equals(nomA3)||"Plongeur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Plongeur".equals(nomA3) && ("Plongeur".equals(nomA1)||"Plongeur".equals(nomA2)||"Plongeur".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Plongeur".equals(nomA4) && ("Plongeur".equals(nomA1)||"Plongeur".equals(nomA3)||"Plongeur".equals(nomA2))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
                
            } else if("Pilote".equals(nomA1) && ("Pilote".equals(nomA2)||"Pilote".equals(nomA3)||"Pilote".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Pilote".equals(nomA2) && ("Pilote".equals(nomA1)||"Pilote".equals(nomA3)||"Pilote".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Pilote".equals(nomA3) && ("Pilote".equals(nomA1)||"Pilote".equals(nomA2)||"Pilote".equals(nomA4))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
            } else if ("Pilote".equals(nomA4) && ("Pilote".equals(nomA1)||"Pilote".equals(nomA3)||"Pilote".equals(nomA2))){
                System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                System.out.println("Veuillez redémarrez.");
                window.dispose();
                
            } else {
                //Vérification qu'il y a au moins 2 joueurs inscrits
                if (nbrJoueurs < 2){
                    System.out.println("Il faut qu'il y ait au moins 2 joueurs !");
                    nbrJoueurs = 0;
                } else {
                    //Envoie des messages avec les paramètres de la partie
                    //Récupération du niveau d'eau selon le niveau de difficulté choisi
                    for (Integer i : ensembleDesBoutonsRadios.keySet()) {
                        if ("Novice".equals(ensembleDesBoutonsRadios.get(i).getText()) && ensembleDesBoutonsRadios.get(i).isSelected()) {
                            niveauEau = 0;
                        } else if("Normal".equals(ensembleDesBoutonsRadios.get(i).getText()) && ensembleDesBoutonsRadios.get(i).isSelected()) {
                            niveauEau = 1;
                        } else if("Elite".equals(ensembleDesBoutonsRadios.get(i).getText()) && ensembleDesBoutonsRadios.get(i).isSelected()) {
                            niveauEau = 2;
                        } else if("Legendaire".equals(ensembleDesBoutonsRadios.get(i).getText()) && ensembleDesBoutonsRadios.get(i).isSelected()) {
                            niveauEau = 3;
                        }
                    }
                    //Définition du niveau d'eau
                    c.setNiveauEau(niveauEau);
                    
                    //Affichage de message de contrôle
                    System.out.println("Le niveau de niveau d'eau choisie est : " + niveauEau);
                    System.out.println("Il y a " + nbrJoueurs + " joueurs");
                    
                    //Création d'un message avec les noms des joueurs et des aventuriers et envoie au controleur
                    Message m = new Message();
                    m.typeMessage = CLIC_BoutonDemarrer;
                    m.nomA = nomsAventuriers;
                    m.nomJ = nomsJoueurs;
                    c.traiterMessage(m);
                    window.setVisible(false);
                }
            }
        });
        
        //Option par défaut de difficulté : Normal
        ensembleDesBoutonsRadios.get(1).setSelected(true);
        
        //Ajout des boutons
        boutonPanel.add(demarrer, BorderLayout.EAST);
        boutonPanel.add(quitter, BorderLayout.WEST);
        
        //Ajout des panels de choix joueur et de boutons radio
        grillePanel.add(grilleAventurierPanel);
        grillePanel.add(radioDifPanel);
        
        //Ajout des principaux panels à la fenêtre
        mainPanel.add(grillePanel, BorderLayout.CENTER);
        mainPanel.add(boutonPanel,BorderLayout.SOUTH);
        mainPanel.add(parametre, BorderLayout.NORTH);        
        window.add(mainPanel);
        
        this.window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    
    //Fonctions utiles :
    public boolean champVide(String nom){
    //Renvoie vrai si le champ est vide
        boolean vide = true;
        if (nom != null){
            for(int i =0; i < nom.length(); i++){
                if (nom.charAt(i) != ' '){
                    vide = false;
                }
            }
        }
        return vide;
    }
    
    public void afficher(){
        //Affiche la fenêtre de parametrage
        this.window.setVisible(true);
    }
    
    //Getters et setters :
    public int getNbrJoueurs() {
        return nbrJoueurs;
    }

    public int getNiveauEau() {
        return niveauEau;
    }

    public String getNomA1() {
        return nomA1;
    }

    public String getNomA2() {
        return nomA2;
    }

    public String getNomA3() {
        return nomA3;
    }

    public String getNomA4() {
        return nomA4;
    }

    public String getNomJoueur1() {
        return nomJoueur1;
    }

    public String getNomJoueur2() {
        return nomJoueur2;
    }

    public String getNomJoueur3() {
        return nomJoueur3;
    }

    public String getNomJoueur4() {
        return nomJoueur4;
    }   
    
    public ArrayList<String> getNomsAventuriers() {
        return nomsAventuriers;
    }
    
    public void setNomsAventuriers(ArrayList<String> nomsAventuriers) {
        this.nomsAventuriers = nomsAventuriers;
    }
    
    public ArrayList<String> getNomsJoueurs() {
        return nomsJoueurs;
    }
    
    public void setNomsJoueurs(ArrayList<String> nomsJoueurs) {
        this.nomsJoueurs = nomsJoueurs;
    }
}