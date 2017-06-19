/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetilebnyl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author bultelbe
 */
public class Pion extends JPanel{
    private int diametre,x,y;
    private double distance;
    
    
    
    Pion(){
        setBackground(Color.white);
        
  
    }
    
    public void paintComponent(Graphics g) {
        Dimension dimension = getSize(); // Taille de la zone de dessin
        
        // Calcul des coordonnées et du diamètre du bouton.
        diametre=(Math.min(dimension.width,dimension.height)*90)/100;
        x=(dimension.width-diametre)/2;
        y=(dimension.height-diametre)/2;
        
            g.setColor(Color.green);
            g.fillOval(x, y,diametre,diametre);
            g.setColor(Color.black);
            g.drawOval(x, y,diametre,diametre);
    
    }
    
}
