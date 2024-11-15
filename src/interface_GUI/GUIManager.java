/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_GUI;
import mypckg.*;
/**
 *
 * @author Amr
 */

public class GUIManager {
	
    public static Player []PL=new Player[2];
    private FirstScreen fs;
    public  GUIManager(){
        PL[0]=new Player();
        PL[1]=new Player();
        Main.objectz.setPlayer(PL[0], 0);
        Main.objectz.setPlayer(PL[1], 1);
        fs = new FirstScreen();
        fs.setVisible(true);
    }
    
}
