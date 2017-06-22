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
import java.util.ArrayList;
import java.util.HashMap;
import projetilebnyl.Controleur;
import projetilebnyl.Message;
import static projetilebnyl.Message.*;
import static projetilebnyl.Message.TypeMessage.CLIC_BoutonDemarrer;

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
    private String[] aventurier;
    private JTextField champJoueur1;
    private JTextField champJoueur2;
    private JTextField champJoueur3;
    private JTextField champJoueur4;
    private int nbrJoueurs = 0;
    private int niveauEau = 0;
    private Controleur c;
    private String nomA1;
    private String nomA2;
    private String nomA3;
    private String nomA4;
    private String nomJoueur1;
    private String nomJoueur2;
    private String nomJoueur3;
    private String nomJoueur4;
    
    private ArrayList<String> nomsAventuriers = new ArrayList();
    private ArrayList<String> nomsJoueurs = new ArrayList();
    
    private HashMap<Integer, JRadioButton> ensembleDesBoutonsRadios;
    
    public VueInscription (Controleur c){
        this.c = c;
        this.window = new JFrame();
        window.setSize(600, 340); 
        window.setTitle("L'Île interdite");
        
        aventurier = new String[]{"Explorateur","Navigateur","Messager","Ingénieur","Plongeur","Pilote"};
        
        mainPanel = new JPanel(new BorderLayout());
        grillePanel = new JPanel(new GridLayout(2,1));
        grilleAventurierPanel = new JPanel(new GridLayout(6,5));
        
        choixAventurier1 = new JComboBox(aventurier);
        choixAventurier2 = new JComboBox(aventurier);
        choixAventurier3 = new JComboBox(aventurier);
        choixAventurier4 = new JComboBox(aventurier);
        
               
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
                champJoueur1 = new JTextField();
                grilleAventurierPanel.add(champJoueur1);
            } else if (i == 13) {
                champJoueur2 = new JTextField();
                grilleAventurierPanel.add(champJoueur2);
            } else if (i == 18) {
                champJoueur3 = new JTextField();
                grilleAventurierPanel.add(champJoueur3);
            } else if (i == 23) {
                champJoueur4 = new JTextField();
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
        choixAventurier1.setSelectedIndex(0);
        choixAventurier2.setSelectedIndex(1);
        choixAventurier3.setSelectedIndex(2);
        choixAventurier4.setSelectedIndex(3);
        
    
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
                
                nomJoueur1 = champJoueur1.getText();
                nomJoueur2 = champJoueur2.getText();
                nomJoueur3 = champJoueur3.getText();
                nomJoueur4 = champJoueur4.getText();
                
                nomA1 = aventurier[choixAventurier1.getSelectedIndex()];
                nomA2 = aventurier[choixAventurier2.getSelectedIndex()];
                nomA3 = aventurier[choixAventurier3.getSelectedIndex()];
                nomA4 = aventurier[choixAventurier4.getSelectedIndex()];
                
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

                
                if("Explorateur".equals(nomA1) && ("Explorateur".equals(nomA2)||"Explorateur".equals(nomA3)||"Explorateur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");      
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Explorateur".equals(nomA2) && ("Explorateur".equals(nomA1)||"Explorateur".equals(nomA3)||"Explorateur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Explorateur".equals(nomA3) && ("Explorateur".equals(nomA1)||"Explorateur".equals(nomA2)||"Explorateur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Explorateur".equals(nomA4) && ("Explorateur".equals(nomA1)||"Explorateur".equals(nomA3)||"Explorateur".equals(nomA2))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                    
                } else if("Navigateur".equals(nomA1) && ("Navigateur".equals(nomA2)||"Navigateur".equals(nomA3)||"Navigateur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !"); 
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Navigateur".equals(nomA2) && ("Navigateur".equals(nomA1)||"Navigateur".equals(nomA3)||"Navigateur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Navigateur".equals(nomA3) && ("Navigateur".equals(nomA1)||"Navigateur".equals(nomA2)||"Navigateur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Navigateur".equals(nomA4) && ("Navigateur".equals(nomA1)||"Navigateur".equals(nomA3)||"Navigateur".equals(nomA2))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                
                } else if("Messager".equals(nomA1) && ("Messager".equals(nomA2)||"Messager".equals(nomA3)||"Messager".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !"); 
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Messager".equals(nomA2) && ("Messager".equals(nomA1)||"Messager".equals(nomA3)||"Messager".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Messager".equals(nomA3) && ("Messager".equals(nomA1)||"Messager".equals(nomA2)||"Messager".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Messager".equals(nomA4) && ("Messager".equals(nomA1)||"Messager".equals(nomA3)||"Messager".equals(nomA2))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                
                } else if("Ingénieur".equals(nomA1) && ("Ingénieur".equals(nomA2)||"Ingénieur".equals(nomA3)||"Ingénieur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Ingénieur".equals(nomA2) && ("Ingénieur".equals(nomA1)||"Ingénieur".equals(nomA3)||"Ingénieur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Ingénieur".equals(nomA3) && ("Ingénieur".equals(nomA1)||"Ingénieur".equals(nomA2)||"Ingénieur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Ingénieur".equals(nomA4) && ("Ingénieur".equals(nomA1)||"Ingénieur".equals(nomA3)||"Ingénieur".equals(nomA2))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                    
                } else if("Plongeur".equals(nomA1) && ("Plongeur".equals(nomA2)||"Plongeur".equals(nomA3)||"Plongeur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Plongeur".equals(nomA2) && ("Plongeur".equals(nomA1)||"Plongeur".equals(nomA3)||"Plongeur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Plongeur".equals(nomA3) && ("Plongeur".equals(nomA1)||"Plongeur".equals(nomA2)||"Plongeur".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Plongeur".equals(nomA4) && ("Plongeur".equals(nomA1)||"Plongeur".equals(nomA3)||"Plongeur".equals(nomA2))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                    
                } else if("Pilote".equals(nomA1) && ("Pilote".equals(nomA2)||"Pilote".equals(nomA3)||"Pilote".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Pilote".equals(nomA2) && ("Pilote".equals(nomA1)||"Pilote".equals(nomA3)||"Pilote".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Pilote".equals(nomA3) && ("Pilote".equals(nomA1)||"Pilote".equals(nomA2)||"Pilote".equals(nomA4))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                } else if ("Pilote".equals(nomA4) && ("Pilote".equals(nomA1)||"Pilote".equals(nomA3)||"Pilote".equals(nomA2))){
                    System.out.println("Il ne peut y avoir qu'une seul même aventurier !");
                    System.out.println("Veuillez redémarrez.");
                    System.exit(0);
                
                } else {
                    
                    if (nbrJoueurs < 2){
                        System.out.println("Il faut qu'il y ait au moins 2 joueurs !");
                        nbrJoueurs = 0;
                    } else {
                        for (Integer i : ensembleDesBoutonsRadios.keySet()) {
                            if (ensembleDesBoutonsRadios.get(i).getText() == "Novice" && ensembleDesBoutonsRadios.get(i).isSelected()){
                                niveauEau = 0;
                            } else if(ensembleDesBoutonsRadios.get(i).getText() == "Normal" && ensembleDesBoutonsRadios.get(i).isSelected()) {
                                niveauEau = 1;
                            } else if(ensembleDesBoutonsRadios.get(i).getText() == "Elite" && ensembleDesBoutonsRadios.get(i).isSelected()) {
                                niveauEau = 2;
                            } else if(ensembleDesBoutonsRadios.get(i).getText() == "Legendaire" && ensembleDesBoutonsRadios.get(i).isSelected()) {
                                niveauEau = 3;
                            }
                        }  

                        System.out.println("Le niveau de niveau d'eau choisie est : " + niveauEau);


                        System.out.println("Il y a " + nbrJoueurs + " joueurs");

                        Message m = new Message();                    
                        m.typeMessage = CLIC_BoutonDemarrer;
                        m.nomA = nomsAventuriers;
                        m.nomJ = nomsJoueurs;
                        c.setNiveauEau(niveauEau);

                        c.traiterMessage(m);
                        window.setVisible(false);

                    }
                    
                }
                
                    
                
                
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
    
    
    public boolean champVide(String nom){
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
    
    
    public void afficher(){
        this.window.setVisible(true);
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
    
    /*
    public static void main(String[] args) {
        // TODO code application logic here
        VueInscription V1 = new VueInscription();
        V1.afficher();
    }
    */
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

