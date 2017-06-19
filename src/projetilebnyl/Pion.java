/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetilebnyl;

import com.sun.prism.paint.Paint;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author bultelbe
 */
public class Pion extends JPanel{
   
    private String nomAvt;
    private JPanel panel;
    Pion(String nomAvt,Color color){
        
        panel = new JPanel();
        panel.setName(nomAvt);
        panel.setBackground(color);
    }

    public String getNomAvt() {
        return nomAvt;
    }
    
}
