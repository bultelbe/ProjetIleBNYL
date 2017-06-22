/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetilebnyl;

import java.util.ArrayList;

/**
 *
 * @author schmuckl
 */

public class Message {
    public TypeMessage typeMessage;
    public ArrayList<String> nomJ = new ArrayList();
    public ArrayList<String> nomA = new ArrayList();
    
    public enum TypeMessage {
        CLIC_BoutonAller,
        CLIC_BoutonTerminer,
        CLIC_BoutonAssecher,
        CLIC_BoutonAutreAction,
        CLIC_BoutonDemarrer,
        CLIC_BoutonValider,
        CLIC_BoutonEchange;
    }

}

