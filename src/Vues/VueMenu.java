/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author schmuckl
 */
public class VueMenu {
    
    private JButton demarrer;
    private JButton quitter;
    private JCheckBox choixAventuriers;
    private JComboBox nbrJoueurs;
    private JFrame window;
    
    public VueMenu() {
        
        this.window = new JFrame();
        window.setSize(200, 100);
        
        window.setTitle("Menu");
        
        JPanel mainPanel = new 
        JPanel panelNbrJoueurs = new JPanel(new BorderLayout());
        JPanel panelChoixAventurier = new JPanel(new BorderLayout());
        JPanel panelBoutons = new JPanel(new BorderLayout());
        
        
        
    }
    
}